package oop.finalexam.t3;

import java.net.URI;
import java.net.http.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatBotManager {
    private final String baseUrl;
    private final HttpClient client = HttpClient.newHttpClient();

    public ChatBotManager(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String createPost(String title, String content, String author) throws Exception {
        String json = String.format("{\"title\": \"%s\", \"content\": \"%s\", \"author\": \"%s\"}",
                escapeJson(title),
                escapeJson(content),
                author != null ? escapeJson(author) : "Anonymous");

        String url = baseUrl + "?api=blogs";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("Content-Type", "application/json; charset=utf-8")
                .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return formatCreateResponse(response);
    }

    public String viewAllPosts() throws Exception {
        String url = baseUrl + "?api=blogs";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return formatPostsResponse(response);
    }

    public String viewStatistics() throws Exception {
        String url = baseUrl + "?api=stats";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return formatStatsResponse(response);
    }

    private String escapeJson(String input) {
        if (input == null) return "";
        return input.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    private String extractJsonValue(String json, String key) {
        if (json == null || key == null) return null;

        Pattern[] patterns = new Pattern[] {
                Pattern.compile("\"" + key + "\"\\s*:\\s*\"([^\"]*)\""),     // string
                Pattern.compile("\"" + key + "\"\\s*:\\s*([0-9.]+)"),       // number
                Pattern.compile("\"" + key + "\"\\s*:\\s*(true|false)")    // boolean
        };

        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(json);
            if (matcher.find()) return matcher.group(1);
        }

        return null;
    }

    private String formatCreateResponse(HttpResponse<String> response) {
        if (response.statusCode() < 200 || response.statusCode() >= 300)
            return "❌ HTTP Error: " + response.statusCode() + " - " + response.body();

        String body = response.body();
        if (body == null || body.isEmpty())
            return "❌ Server returned empty response.";

        String success = extractJsonValue(body, "success");
        if ("true".equals(success)) {
            String title = extractJsonValue(body, "title");
            String author = extractJsonValue(body, "author");
            String id = extractJsonValue(body, "id");
            String createdAt = extractJsonValue(body, "created_at");

            return String.format("✅ Blog post created!\n📝 Title: %s\n👤 Author: %s\n🆔 ID: %s\n📅 Created: %s",
                    title != null ? title : "N/A",
                    author != null ? author : "N/A",
                    id != null ? id : "N/A",
                    createdAt != null ? createdAt : "N/A");
        } else {
            return "❌ Post creation failed: " + body;
        }
    }

    private String formatPostsResponse(HttpResponse<String> response) {
        if (response.statusCode() < 200 || response.statusCode() >= 300)
            return "❌ HTTP Error: " + response.statusCode() + " - " + response.body();

        String body = response.body();
        if (body == null || body.isEmpty())
            return "❌ Server returned empty response.";

        String success = extractJsonValue(body, "success");
        if (!"true".equals(success)) return "❌ Failed to fetch posts.";

        String total = extractJsonValue(body, "total");
        StringBuilder result = new StringBuilder();
        result.append("📋 Total Posts: ").append(total != null ? total : "N/A").append("\n");
        result.append("══════════════════════════════\n");

        Pattern dataPattern = Pattern.compile("\"data\"\\s*:\\s*\\[(.*?)\\]\\s*,\\s*\"meta\"", Pattern.DOTALL);
        Matcher matcher = dataPattern.matcher(body);
        if (!matcher.find()) return result.append("📭 No blog data found.").toString();

        String postsJsonArray = matcher.group(1).trim();
        if (postsJsonArray.isEmpty()) return result.append("📭 No blog posts in data.").toString();

        String[] posts = postsJsonArray.split("\\},\\s*\\{");

        int count = 1;
        for (String rawPost : posts) {
            rawPost = rawPost.trim();
            if (!rawPost.startsWith("{")) rawPost = "{" + rawPost;
            if (!rawPost.endsWith("}")) rawPost = rawPost + "}";

            String title = extractJsonValue(rawPost, "title");
            String content = extractJsonValue(rawPost, "content");
            String author = extractJsonValue(rawPost, "author");
            String createdAt = extractJsonValue(rawPost, "created_at");
            String id = extractJsonValue(rawPost, "id");

            result.append(String.format("📝 Post #%d\n", count++));
            result.append("Title: ").append(title != null ? title : "N/A").append("\n");
            result.append("Content: ").append(content != null ? content : "N/A").append("\n");
            result.append("Author: ").append(author != null ? author : "N/A").append("\n");
            result.append("Created: ").append(createdAt != null ? createdAt : "N/A").append("\n");
            result.append("ID: ").append(id != null ? id : "N/A").append("\n");
            result.append("----------------------------\n");
        }

        return result.toString();
    }

    private String formatStatsResponse(HttpResponse<String> response) {
        if (response.statusCode() < 200 || response.statusCode() >= 300)
            return "❌ HTTP Error: " + response.statusCode() + " - " + response.body();

        String body = response.body();
        if (body == null || body.isEmpty())
            return "❌ Empty statistics from server.";

        return String.format(
                "📊 BLOG STATS\n" +
                        "Total Posts: %s\n" +
                        "Max Posts: %s\n" +
                        "Remaining: %s\n" +
                        "Usage: %s%%\n" +
                        "Can Add More: %s",
                extractJsonValue(body, "total_posts"),
                extractJsonValue(body, "max_posts"),
                extractJsonValue(body, "remaining_posts"),
                extractJsonValue(body, "percentage_used"),
                "true".equals(extractJsonValue(body, "can_add_more")) ? "Yes" : "No"
        );
    }
}
