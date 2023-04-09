package me.jujjka.deliverypl.deliverypl;

import me.jujjka.deliverypl.deliverypl.commands.CommandsMgr;
import me.jujjka.deliverypl.deliverypl.commands.DeliveryCMD;
import me.jujjka.deliverypl.deliverypl.events.EventsMgr;
import me.jujjka.deliverypl.deliverypl.language.LangMgr;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Deliverypl extends JavaPlugin {

    private static String PLUGIN_NAME = "Deliverypl";

    private static Deliverypl instance;

    @Override
    public void onEnable() {
        this.instance = this;
        Bukkit.getLogger().info(" ============= delivery plugin ============= ");
        Bukkit.getLogger().info("author: " + this.getDescription().getAuthors().get(0));
        Bukkit.getLogger().info("version: " + this.getDescription().getVersion());
        Bukkit.getLogger().info("description: " + this.getDescription().getDescription());

        EventsMgr.register();
        CommandsMgr.register();

        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        LangMgr.setupLanguages();

        int pluginId = 18170; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);
    }

    public static Deliverypl getInstance() {
        return instance;
    }

    public static String getPluginName() {
        return PLUGIN_NAME;
    }
}
