package me.jujjka.deliverypl.deliverypl.events;

import me.jujjka.deliverypl.deliverypl.inventory.DeliveryGUI;
import me.jujjka.deliverypl.deliverypl.language.LangMgr;
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
        if(e.getView().getTitle().contains(LangMgr.getLang().getString("GUI.deliveryguititle"))) {
            if (e.getCurrentItem() == null) {
                return;
            }
            ItemStack item = e.getCurrentItem();
            if (!item.getType().equals(Material.IRON_INGOT)) {
                e.setCancelled(true);
                return;
            }
            e.setCancelled(true);
            Player clicked = (Player) e.getWhoClicked();
            Player player = Bukkit.getPlayer(e.getView().getTitle());
            if(TransRoom.getRoom(clicked,player) == null){return;}
            TransRoom transRoom = TransRoom.getRoom(clicked, player);
            DeliveryGUI deliveryGUI = transRoom.getDeliveryGUI();
            for (int i = 0; i < 18; i++) {
                if (deliveryGUI.getInventory().getItem(i) != null) {
                    if (transRoom.getGetDeliveryGUI().getItems().size() < 18) {
                        transRoom.getGetDeliveryGUI().getItems().add(deliveryGUI.getInventory().getItem(i));
                    }
                }
            }
        }
    }
}
