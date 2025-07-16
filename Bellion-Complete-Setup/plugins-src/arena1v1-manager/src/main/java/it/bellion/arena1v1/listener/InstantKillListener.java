package it.bellion.arena1v1.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class InstantKillListener implements Listener {
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)) return;
        Player damager = (Player) event.getDamager();
        Player victim = (Player) event.getEntity();
        if (damager.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD) {
            // TODO: Verifica se in arena 1v1 e se la modalità instant-kill è attiva
            event.setDamage(1000.0);
            damager.sendMessage("§cColpo istantaneo! Duello deciso.");
            victim.sendMessage("§4Sei stato colpito da una spada one-hit!");
        }
    }
}