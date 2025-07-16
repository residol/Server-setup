package it.bellion.economy;

import org.bukkit.plugin.java.JavaPlugin;
import it.bellion.economy.database.DatabaseManager;
import it.bellion.economy.command.EcoCommand;
import it.bellion.economy.listener.PlayerJoinListener;
import org.bukkit.plugin.RegisteredServiceProvider;
import net.milkbowl.vault.economy.Economy;

public class BellionEconomyBridge extends JavaPlugin {
    private EconomyConfig configManager;
    private DatabaseManager databaseManager;
    private Economy vaultEconomy;

    @Override
    public void onEnable() {
        getLogger().info("[BellionEconomyBridge] Enabling cross-server economy...");
        this.configManager = new EconomyConfig(this);
        this.databaseManager = new DatabaseManager(
            configManager.getMySQLHost(),
            configManager.getMySQLPort(),
            configManager.getMySQLDatabase(),
            configManager.getMySQLUser(),
            configManager.getMySQLPassword()
        );
        if (!databaseManager.connect()) {
            getLogger().severe("[EconomyBridge] Impossibile connettersi al database!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if (!setupVaultEconomy()) {
            getLogger().severe("[EconomyBridge] Vault non trovato!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getCommand("eco").setExecutor(new EcoCommand());
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        // TODO: Carica sistemi sync, API, shop integration
    }

    private boolean setupVaultEconomy() {
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) return false;
        vaultEconomy = rsp.getProvider();
        return vaultEconomy != null;
    }

    @Override
    public void onDisable() {
        getLogger().info("[BellionEconomyBridge] Disabling...");
        if (databaseManager != null && databaseManager.isConnected()) {
            databaseManager.disconnect();
        }
    }
}