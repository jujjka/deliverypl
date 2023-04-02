package me.jujjka.deliverypl.deliverypl.inventory;

import me.jujjka.deliverypl.deliverypl.language.LangMgr;
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

public class GetDeliveryGUI  implements InventoryHolder {
    private final Inventory inv;
    List<ItemStack> items = new ArrayList<>();
    public GetDeliveryGUI(Player player)  {
        inv = Bukkit.createInventory(player,27, "получние спермы");
        init();
    }

    private void init()  {
        ItemStack item_send;
        ItemStack item_info;
        List<String > lore_send = new ArrayList<>();
        List<String > lore_info = new ArrayList<>();

        item_send = createItem(LangMgr.getLang().getString("GUI.getitem"), Material.IRON_INGOT,lore_send);
        item_info = createItem(LangMgr.getLang().getString("GUI.infoitem"),Material.WARPED_PRESSURE_PLATE,lore_info);
        //
        inv.setItem(18,item_send);
        inv.setItem(26,item_info);
        int i = 0;
        for(ItemStack item : items) {
            if(i < 18){
                inv.addItem(item);
                i++;
            }

        }
    }

    private ItemStack createItem(String name, Material mat, List<String > lore){
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }

    public List<ItemStack> getItems() {
        return items;
    }

    public void setItems(List<ItemStack> items) {
        this.items = items;
    }
}

