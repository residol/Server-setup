package it.bellion.prisonskyblock.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PSBCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Solo i giocatori possono usare questo comando.");
            return true;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage("§6[PrisonSkyblock] Usa /psb <info|rank|island|prestige>");
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "info":
                player.sendMessage("§ePrisonSkyblock: Modalità ibrida unica!");
                break;
            case "rank":
                // TODO: Mostra info rank/mina
                player.sendMessage("§bIl tuo rank attuale: ...");
                break;
            case "island":
                // TODO: Gestione isola
                player.sendMessage("§aGestione isola: ...");
                break;
            case "prestige":
                // TODO: Sistema prestige
                player.sendMessage("§dPrestige: ...");
                break;
            default:
                player.sendMessage("§cComando sconosciuto.");
        }
        return true;
    }
}