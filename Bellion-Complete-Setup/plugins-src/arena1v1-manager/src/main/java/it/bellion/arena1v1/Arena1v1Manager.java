package it.bellion.arena1v1;

import org.bukkit.plugin.java.JavaPlugin;
import it.bellion.arena1v1.database.DatabaseManager;
import it.bellion.arena1v1.command.Arena1v1Command;
import it.bellion.arena1v1.listener.PlayerJoinListener;
import it.bellion.arena1v1.listener.InstantKillListener;

public class Arena1v1Manager extends JavaPlugin {
    private Arena1v1Config configManager;
    private DatabaseManager databaseManager;

    @Override
    public void onEnable() {
        getLogger().info("[Arena1v1Manager] Enabling Arena 1v1 Manager...");
        this.configManager = new Arena1v1Config(this);
        this.databaseManager = new DatabaseManager(
            configManager.getMySQLHost(),
            configManager.getMySQLPort(),
            configManager.getMySQLDatabase(),
            configManager.getMySQLUser(),
            configManager.getMySQLPassword()
        );
        if (!databaseManager.connect()) {
            getLogger().severe("[Arena1v1Manager] Impossibile connettersi al database!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getCommand("arena1v1").setExecutor(new Arena1v1Command());
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new InstantKillListener(), this);
        // TODO: Carica sistemi queue, betting, elo, tournament, replay
    }

    @Override
    public void onDisable() {
        getLogger().info("[Arena1v1Manager] Disabling...");
        if (databaseManager != null && databaseManager.isConnected()) {
            databaseManager.disconnect();
        }
    }
}