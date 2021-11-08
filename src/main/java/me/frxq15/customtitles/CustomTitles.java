package me.frxq15.customtitles;

import me.frxq15.customtitles.Commands.titleCommand;
import me.frxq15.customtitles.GUIManager.TitlesGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class CustomTitles extends JavaPlugin {
    private static CustomTitles instance;
    public TitlesGUI titlesGUI;
    public Player p;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        initializeClasses();
        log("Plugin enabled successfully.");
        getCommand("titles").setExecutor(new titleCommand());
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        log("Plugin disabled successfully.");
        // Plugin shutdown logic
    }
    public void log(String log) { Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"[FrxqTitles] "+log); }
    public String colourize(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
    public List<String> colourize(List<String> input) {
        List<String> newList = new ArrayList<>();
        for(String entry : input) {
            newList.add(colourize(entry));
        }
        return newList;
    }
    public String formatMsg(String input) { return ChatColor.translateAlternateColorCodes('&', getInstance().getConfig().getString("MESSAGES."+input)); }
    public static CustomTitles getInstance() { return instance; }
    public void initializeClasses() {
        titlesGUI = new TitlesGUI(p, this);
    }
    public TitlesGUI getTitlesGUI() { return titlesGUI; }
}
