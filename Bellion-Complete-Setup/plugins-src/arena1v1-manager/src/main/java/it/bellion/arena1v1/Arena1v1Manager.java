package it.bellion.arena1v1;

import org.bukkit.plugin.java.JavaPlugin;

public class Arena1v1Manager extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("[Arena1v1Manager] Enabling Arena 1v1 Manager...");
        // TODO: Setup database connection
        // TODO: Setup queue system
        // TODO: Register commands and events
        // TODO: Load ELO and instant-kill system
    }

    @Override
    public void onDisable() {
        getLogger().info("[Arena1v1Manager] Disabling...");
        // TODO: Close database connection
    }
}