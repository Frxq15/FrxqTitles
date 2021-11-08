package me.frxq15.customtitles.Commands;

import me.frxq15.customtitles.CustomTitles;
import me.frxq15.customtitles.GUIManager.TitlesGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class titleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        CustomTitles plugin = CustomTitles.getInstance();
        if(!(sender instanceof Player)) {
            plugin.log("This command cannot be executed from console.");
            return true;
        }
        Player p = (Player) sender;
        if(!p.hasPermission("frxqtitles.title")) {
            p.sendMessage(plugin.formatMsg("NO_PERMISSION"));
            return true;
        }
        plugin.getTitlesGUI().open(p);
        return true;
    }
}
