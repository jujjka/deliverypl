package me.jujjka.deliverypl.deliverypl.language;

import me.jujjka.deliverypl.deliverypl.Deliverypl;
import me.jujjka.deliverypl.deliverypl.language.files.En;
import me.jujjka.deliverypl.deliverypl.language.files.Fr;
import me.jujjka.deliverypl.deliverypl.language.files.Ge;
import me.jujjka.deliverypl.deliverypl.language.files.Ru;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class LangMgr {
    public static FileConfiguration getLang(){
        String lang = Bukkit.getPluginManager().getPlugin(Deliverypl.getPluginName()).getConfig().getString("lang");
        File file = new File(Bukkit.getPluginManager().getPlugin(Deliverypl.getPluginName()).getDataFolder().getPath(),lang);
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config;
    }
    public static void setupLanguages(){
        Ru.setupMessages();
        En.setupMessages();
        Fr.setupMessages();
        Ge.setupMessages();
    }
}
