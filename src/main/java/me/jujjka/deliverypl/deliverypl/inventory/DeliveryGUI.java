package me.jujjka.deliverypl.deliverypl.inventory;

import me.jujjka.deliverypl.deliverypl.language.LangMgr;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeliveryGUI implements InventoryHolder {
    private final Inventory inv;
    public DeliveryGUI(Player player,Player target)  {
        inv = Bukkit.createInventory(this,27, "§bsend to " + target.getDisplayName());
        init();
        player.openInventory(inv);
    }

    private void init()  {
        ItemStack item_send;
        ItemStack item_info;
        ItemStack item_partition;
        List<String > lore_send = Collections.singletonList(LangMgr.getLang().getString("GUI.item_send_lore"));
        List<String > lore_info = Collections.singletonList("");

        item_send = createItem(LangMgr.getLang().getString("GUI.senditem"), Material.IRON_INGOT,lore_send);
        item_info = createItem(LangMgr.getLang().getString("GUI.setinfoitem"),Material.WARPED_PRESSURE_PLATE,lore_info);
        item_partition = createItem(LangMgr.getLang().getString("GUI.partition"),Material.STONE_SLAB,null);
        //
        inv.setItem(18,item_send);
        inv.setItem(26,item_info);
        for (int i  = 9; i < 18; i++){
            inv.setItem(i,item_partition);
        }
        //
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
}

