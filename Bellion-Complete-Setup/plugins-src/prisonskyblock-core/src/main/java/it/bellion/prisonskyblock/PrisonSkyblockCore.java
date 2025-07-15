package it.bellion.prisonskyblock;

import org.bukkit.plugin.java.JavaPlugin;

public class PrisonSkyblockCore extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("[PrisonSkyblockCore] Enabling Prison x Skyblock Hybrid Core...");
        // TODO: Setup database connection
        // TODO: Setup economy bridge
        // TODO: Register commands and events
        // TODO: Load dual progress system
    }

    @Override
    public void onDisable() {
        getLogger().info("[PrisonSkyblockCore] Disabling...");
        // TODO: Close database connection
    }
}