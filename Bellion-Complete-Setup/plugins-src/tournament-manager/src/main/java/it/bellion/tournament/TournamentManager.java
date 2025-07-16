package it.bellion.tournament;

import org.bukkit.plugin.java.JavaPlugin;

public class TournamentManager extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("[TournamentManager] Enabling tournament/event system...");
        // TODO: Setup database connection
        // TODO: Register event/tournament commands
        // TODO: Load event/tournament logic
    }

    @Override
    public void onDisable() {
        getLogger().info("[TournamentManager] Disabling...");
        // TODO: Close database connection
    }
}