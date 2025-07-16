package it.bellion.prisonskyblock;

import org.bukkit.plugin.java.JavaPlugin;
import it.bellion.prisonskyblock.database.DatabaseManager;
import it.bellion.prisonskyblock.command.PSBCommand;
import it.bellion.prisonskyblock.listener.PlayerJoinListener;

public class PrisonSkyblockCore extends JavaPlugin {
    private PrisonSkyblockConfig psbConfig;
    private DatabaseManager databaseManager;

    @Override
    public void onEnable() {
        getLogger().info("[PrisonSkyblockCore] Enabling Prison x Skyblock Hybrid Core...");
        this.psbConfig = new PrisonSkyblockConfig(this);
        this.databaseManager = new DatabaseManager(
            psbConfig.getMySQLHost(),
            psbConfig.getMySQLPort(),
            psbConfig.getMySQLDatabase(),
            psbConfig.getMySQLUser(),
            psbConfig.getMySQLPassword()
        );
        if (!databaseManager.connect()) {
            getLogger().severe("[PrisonSkyblockCore] Impossibile connettersi al database!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getCommand("psb").setExecutor(new PSBCommand());
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        // TODO: Carica sistemi dual progress, island, mine, economy bridge
    }

    @Override
    public void onDisable() {
        getLogger().info("[PrisonSkyblockCore] Disabling...");
        if (databaseManager != null && databaseManager.isConnected()) {
            databaseManager.disconnect();
        }
    }
}