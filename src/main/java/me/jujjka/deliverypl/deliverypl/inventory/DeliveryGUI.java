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
import java.util.List;

public class DeliveryGUI implements InventoryHolder {
    private final Inventory inv;


    public DeliveryGUI(Player player,Player target)  {
        inv = Bukkit.createInventory(player,27, target.getDisplayName() + LangMgr.getLang().getString("GUI.deliveryguititle"));
        init();
        player.openInventory(getInventory());
    }

    private void init()  {
        ItemStack item_send;
        ItemStack item_info;
        ItemStack item_partition;
        List<String > lore_send = new ArrayList<>();
        List<String > lore_info = new ArrayList<>();
        List<String > lore_partition = new ArrayList<>();

        item_send = createItem(LangMgr.getLang().getString("GUI.senditem"), Material.IRON_INGOT,lore_send);
        item_info = createItem(LangMgr.getLang().getString("GUI.infoitem"),Material.WARPED_PRESSURE_PLATE,lore_info);
        item_partition = createItem(LangMgr.getLang().getString("GUI.partitionitem"),Material.STONE_SLAB,lore_partition);
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
        meta.setCustomModelData(22522224);
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

