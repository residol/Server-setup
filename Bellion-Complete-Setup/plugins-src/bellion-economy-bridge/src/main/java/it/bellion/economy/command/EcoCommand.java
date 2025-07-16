package it.bellion.economy.command;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            sender.sendMessage("§6[Economy] Usa /eco <give|take|bal|top> ...");
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "give":
                if (args.length < 3) {
                    sender.sendMessage("§cUso: /eco give <player> <amount>");
                    return true;
                }
                OfflinePlayer target = Bukkit.getOfflinePlayer(args[1]);
                // TODO: Aggiungi amount al saldo target
                sender.sendMessage("§aHai dato " + args[2] + " coins a " + target.getName());
                break;
            case "take":
                if (args.length < 3) {
                    sender.sendMessage("§cUso: /eco take <player> <amount>");
                    return true;
                }
                OfflinePlayer target2 = Bukkit.getOfflinePlayer(args[1]);
                // TODO: Rimuovi amount dal saldo target
                sender.sendMessage("§cHai tolto " + args[2] + " coins a " + target2.getName());
                break;
            case "bal":
                if (args.length == 1 && sender instanceof Player) {
                    // TODO: Mostra saldo sender
                    sender.sendMessage("§eIl tuo saldo: ... coins");
                } else if (args.length == 2) {
                    OfflinePlayer target3 = Bukkit.getOfflinePlayer(args[1]);
                    // TODO: Mostra saldo target
                    sender.sendMessage("§eSaldo di " + target3.getName() + ": ... coins");
                } else {
                    sender.sendMessage("§cUso: /eco bal [player]");
                }
                break;
            case "top":
                // TODO: Mostra top 10
                sender.sendMessage("§bTop 10 bilanci: ...");
                break;
            default:
                sender.sendMessage("§cComando sconosciuto.");
        }
        return true;
    }
}