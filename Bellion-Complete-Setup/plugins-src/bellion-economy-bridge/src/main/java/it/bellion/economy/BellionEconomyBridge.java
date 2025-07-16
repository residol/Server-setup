package it.bellion.economy;

import org.bukkit.plugin.java.JavaPlugin;

public class BellionEconomyBridge extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("[BellionEconomyBridge] Enabling cross-server economy...");
        // TODO: Setup database connection
        // TODO: Setup Vault integration
        // TODO: Register API endpoints
    }

    @Override
    public void onDisable() {
        getLogger().info("[BellionEconomyBridge] Disabling...");
        // TODO: Close database connection
    }
}