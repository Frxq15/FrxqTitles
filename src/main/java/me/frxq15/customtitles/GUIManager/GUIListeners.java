package me.frxq15.customtitles.GUIManager;

import me.frxq15.customtitles.CustomTitles;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class GUIListeners implements Listener {
    CustomTitles plugin = CustomTitles.getInstance();
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        Player player = (Player) e.getWhoClicked();
        UUID playerUUID = player.getUniqueId();
        UUID inventoryUUID = TitlesGUI.openInventories.get(playerUUID);
        if (inventoryUUID != null) {
            e.setCancelled(true);
            GUITemplate gui = GUITemplate.getInventoriesByUUID().get(inventoryUUID);
            TitlesGUI.GUIAction action = gui.getActions().get(e.getSlot());
            if(e.getClickedInventory() != player.getOpenInventory().getTopInventory()) return;
            if (action != null) {
                action.click(player);
            }
        }
    }
    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        UUID playerUUID = player.getUniqueId();
        TitlesGUI.openInventories.remove(playerUUID);
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = (Player) e.getPlayer();
        UUID playerUUID = player.getUniqueId();
        TitlesGUI.openInventories.remove(playerUUID);
    }
}
