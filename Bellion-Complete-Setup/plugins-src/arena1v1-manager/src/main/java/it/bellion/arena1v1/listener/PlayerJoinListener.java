package it.bellion.arena1v1.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // TODO: Carica dati player da database
        player.sendMessage("§6[Arena1v1] Benvenuto nell'arena duelli 1v1!");
    }
}