package me.dean.ultimateTroll.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.PlayerArgument;
import dev.jorel.commandapi.arguments.SafeSuggestions;
import me.dean.ultimateTroll.Gui.TrollGUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TrollCommand {
    public static void register(){
        new CommandAPICommand("troll")
                .withPermission("troll.use")
                .withArguments(new PlayerArgument("target").replaceSafeSuggestions(SafeSuggestions.suggest(info -> Bukkit.getOnlinePlayers().toArray(new Player[0]))))
                .executesPlayer((executor, args) -> {
                    Player target = (Player) args.get("target");
                    TrollGUI.openTrollMenu(executor, target);
                })
                .register();
    }

}
