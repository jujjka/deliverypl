package me.jujjka.deliverypl.deliverypl.events;

import me.jujjka.deliverypl.deliverypl.inventory.DeliveryGUI;
import me.jujjka.deliverypl.deliverypl.module.TransRoom;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickSenderGui implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(!(e.getClickedInventory() instanceof DeliveryGUI)){return;}
        e.setCancelled(true);
        if(e.getCurrentItem() == null){return;}
        ItemStack item = e.getCurrentItem();
        if(!item.getType().equals(Material.IRON_INGOT)){return;}
        Player clicked = (Player) e.getWhoClicked();
        Player player = Bukkit.getPlayer(e.getView().getTitle());
        TransRoom transRoom = TransRoom.getRoom(clicked,player);
        DeliveryGUI deliveryGUI = transRoom.getDeliveryGUI();
        for (int i = 0; i < 17;i++){
            if(deliveryGUI.getInventory().getItem(i) != null) {
                if (transRoom.getGetDeliveryGUI().getItems().size() < 18) {
                    transRoom.getGetDeliveryGUI().getItems().add(deliveryGUI.getInventory().getItem(i));
                }
            }
        }
    }
}
