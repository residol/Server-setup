package it.bellion.economy;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class EconomyConfig {
    private final JavaPlugin plugin;
    private FileConfiguration config;

    public EconomyConfig(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.saveDefaultConfig();
        this.config = plugin.getConfig();
    }

    public String getMySQLHost() {
        return config.getString("mysql.host", "localhost");
    }
    public int getMySQLPort() {
        return config.getInt("mysql.port", 3306);
    }
    public String getMySQLDatabase() {
        return config.getString("mysql.database", "bellion");
    }
    public String getMySQLUser() {
        return config.getString("mysql.user", "root");
    }
    public String getMySQLPassword() {
        return config.getString("mysql.password", "password");
    }
    public boolean isCrossServerEnabled() {
        return config.getBoolean("cross_server.enabled", true);
    }
    // Altri getter per feature toggle...
}