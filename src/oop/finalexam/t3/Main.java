package oop.finalexam.t3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ConfigLoader config = new ConfigLoader("config.properties");
            ChatBotManager bot = new ChatBotManager(config.getServerUrl());

            System.out.println("🤖 Welcome to " + config.getBotName() + "!");
            System.out.println("🚀 Connected to: " + config.getServerUrl());

            while (true) {
                System.out.println("\n=== MENU ===");
                System.out.println("1. ➕ Create new blog post");
                System.out.println("2. 📚 View all posts");
                System.out.println("3. 📈 View site stats");
                System.out.println("0. ❌ Exit");
                System.out.print("Enter your choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("📝 Title: ");
                        String title = scanner.nextLine().trim();
                        while (title.isEmpty()) {
                            System.out.print("❌ Title is required. Try again: ");
                            title = scanner.nextLine().trim();
                        }

                        System.out.print("📄 Content: ");
                        String content = scanner.nextLine().trim();
                        while (content.isEmpty()) {
                            System.out.print("❌ Content is required. Try again: ");
                            content = scanner.nextLine().trim();
                        }

                        System.out.print("👤 Author (optional): ");
                        String author = scanner.nextLine().trim();

                        System.out.println("\n⏳ Creating post...");
                        System.out.println(bot.createPost(title, content, author.isEmpty() ? null : author));
                        break;

                    case "2":
                        System.out.println("\n⏳ Fetching all posts...");
                        System.out.println(bot.viewAllPosts());
                        break;

                    case "3":
                        System.out.println("\n⏳ Fetching stats...");
                        System.out.println(bot.viewStatistics());
                        break;

                    case "0":
                        System.out.println("👋 Goodbye from " + config.getBotName() + "!");
                        return;

                    default:
                        System.out.println("⚠️ Invalid option. Please choose between 0–3.");
                }
            }

        } catch (Exception e) {
            System.out.println("❗ Error: " + e.getMessage());
        }
    }
}
