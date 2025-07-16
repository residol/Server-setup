package it.bellion.cosmetics;

import org.bukkit.plugin.java.JavaPlugin;

public class CosmeticsSystem extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("[CosmeticsSystem] Enabling medieval cosmetics...");
        // TODO: Setup database connection
        // TODO: Setup ProtocolLib integration
        // TODO: Register GUI and effects
    }

    @Override
    public void onDisable() {
        getLogger().info("[CosmeticsSystem] Disabling...");
        // TODO: Close database connection
    }
}