package me.jujjka.deliverypl.deliverypl.inventory;

import me.jujjka.deliverypl.deliverypl.language.LangMgr;
import me.jujjka.deliverypl.deliverypl.module.TransRoom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class GetDeliveryGUI {
    private List<ItemStack> items = new ArrayList<>();
    private Player player;
    private Player sender;
    public GetDeliveryGUI(TransRoom transRoom) {
        this.player = transRoom.getTarget();
        this.sender = transRoom.getSender();
    }
    public List<ItemStack> getItems() {
        return items;
    }

    public void setItems(List<ItemStack> items) {
        this.items = items;
    }
}

