package me.jujjka.deliverypl.deliverypl.events;

import me.jujjka.deliverypl.deliverypl.inventory.DeliveryGUI;
import me.jujjka.deliverypl.deliverypl.inventory.GetDeliveryGUI;
import me.jujjka.deliverypl.deliverypl.language.LangMgr;
import me.jujjka.deliverypl.deliverypl.module.TransRoom;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ClickSendGui implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getClickedInventory() == null) {return;}
        if (!(e.getClickedInventory().getHolder() instanceof DeliveryGUI)) {return; }
        if (e.getCurrentItem() == null) { return;}
                ItemStack it = e.getCurrentItem();
                if (it.getType() == Material.IRON_INGOT) {
                    e.setCancelled(true);
                    Player sender = (Player) e.getWhoClicked();
                    Player target = Bukkit.getPlayer(e.getView().getTitle().substring(10));
                    if (TransRoom.getRoom(sender, target) != null) {
                        TransRoom room = TransRoom.getRoom(sender, target);
                        room.send();
                    }
                } else if (e.getCurrentItem().getType() == Material.WARPED_PRESSURE_PLATE || e.getCurrentItem().getType() == Material.STONE_SLAB) {
                    e.setCancelled(true);
                }
    }
}