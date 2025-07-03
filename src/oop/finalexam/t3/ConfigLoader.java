package oop.finalexam.t3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private final String serverUrl;
    private final String botName;

    public ConfigLoader(String filePath) throws IOException {
        Properties props = new Properties();
        try (FileInputStream input = new FileInputStream(filePath)) {
            props.load(input);
        }

        this.serverUrl = props.getProperty("server.url");
        if (serverUrl == null || serverUrl.isEmpty()) {
            throw new IOException("Missing 'server.url' in config file.");
        }

        this.botName = props.getProperty("bot.name", "DefaultBot");
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public String getBotName() {
        return botName;
    }
}
