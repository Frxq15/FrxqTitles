package me.frxq15.customtitles.Commands;

import me.frxq15.customtitles.CustomTitles;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class atitleCommand implements CommandExecutor {
    CustomTitles plugin;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("frxqtitles.admin")) {
            sender.sendMessage(plugin.formatMsg("NO_PERMISSION"));
            return true;
        }
        return true;
    }
}
