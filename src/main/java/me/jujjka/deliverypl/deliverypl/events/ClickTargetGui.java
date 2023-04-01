package me.jujjka.deliverypl.deliverypl.events;

import me.jujjka.deliverypl.deliverypl.inventory.GetDeliveryGUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ClickTargetGui implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!(e.getClickedInventory() instanceof GetDeliveryGUI)) {return;}
        e.setCancelled(true);
        if (e.getCurrentItem() == null) {return;}
        Player player = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        Inventory inventory = e.getClickedInventory();
        if (!item.getType().equals(Material.IRON_INGOT)) {return;}
        for (int i = 0; i < 18; i++){
            if(inventory.getItem(i) != null){
                player.getInventory().addItem(inventory.getItem(i));
            }
        }
    }
}