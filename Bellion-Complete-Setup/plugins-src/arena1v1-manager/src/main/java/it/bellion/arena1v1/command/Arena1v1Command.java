package it.bellion.arena1v1.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Arena1v1Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Solo i giocatori possono usare questo comando.");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage("§6[Arena1v1] Usa /arena1v1 <join|leave|stats|elo|tournament>");
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "join":
                // TODO: Aggiungi player alla queue
                player.sendMessage("§aSei entrato in coda per 1v1!");
                break;
            case "leave":
                // TODO: Rimuovi player dalla queue
                player.sendMessage("§cSei uscito dalla coda 1v1.");
                break;
            case "stats":
                // TODO: Mostra statistiche player
                player.sendMessage("§bStatistiche 1v1: ...");
                break;
            case "elo":
                // TODO: Mostra ELO player
                player.sendMessage("§eIl tuo ELO: ...");
                break;
            case "tournament":
                // TODO: Gestione torneo
                player.sendMessage("§dTorneo: ...");
                break;
            default:
                player.sendMessage("§cComando sconosciuto.");
        }
        return true;
    }
}