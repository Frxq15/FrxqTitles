package me.frxq15.customtitles.GUIManager;

import me.frxq15.customtitles.CustomTitles;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitlesGUI extends GUITemplate{
    CustomTitles plugin;
    Player p;
    public TitlesGUI(Player p, CustomTitles plugin) {
        super(plugin.getConfig().getInt("TITLES_GUI.SIZE"), plugin.colourize(plugin.getConfig().getString("TITLES_GUI.TITLE")));
        this.plugin = plugin;
        this.p = p;
        initializeItems();
    }
    void initializeItems() {
        plugin.getConfig().getConfigurationSection("TITLES").getKeys(false).forEach(title -> {
            if(p.hasPermission("frxqtitles.title."+title)) {
                setItem(plugin.getConfig().getInt(title+".GUI_SLOT"), titlesItem(title), player -> {
                    Bukkit.broadcastMessage(title);
                })
            ;}
        });
    }
    ItemStack titlesItem(String title) {
        String path = plugin.getConfig().getString("TITLES."+title);
        List<String> lore = new ArrayList<>();
        final ItemStack item = new ItemStack(Material.valueOf(path+".GUI_ITEM"), 1);
        final ItemMeta meta = item.getItemMeta();
        String name = plugin.getConfig().getString("TITLES_GUI.TITLES_NAME").replace("%title%", path+"TITLE_STRING");
        meta.setDisplayName(name);
        for(String line : plugin.getConfig().getStringList("TITLES_GUI.TITLES_LORE")) {
            line = line.replace("%title%", name);
            lore.add(line);
        }
        meta.setLore(plugin.colourize(lore));
        item.setItemMeta(meta);
        return item;
    }
}
