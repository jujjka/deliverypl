package me.jujjka.deliverypl.deliverypl.language.files;

import me.jujjka.deliverypl.deliverypl.Deliverypl;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Fr {
    private static File file;
    private static FileConfiguration customFile;
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin(Deliverypl.getPluginName()).getDataFolder(), "Fr");

        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                //owww
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try{
            customFile.save(file);
        }catch (IOException e){
            System.out.println("Couldn't save file Fr");
        }
    }
    public static void setupMessages(){
        setup();
        get().set("ERROR.maximum","§4Vous avez atteint la limite!");
        get().set("ERROR.notPlayer","§4Le joueur [%s] n'existe pas");
        get().set("ERROR.notArguments","§4Pas assez d'arguments");
        get().set("GUI.senditem","§bSoumettre des ressources");
        get().set("GUI.setinfoitem","§bIci vous pouvez soumettre vos ressources");

        get().set("GUI.item_send_lore","§6Soumettre au lingot");
        get().set("GUI.partition","§bсlôture");
        get().options().copyDefaults(true);
        save();
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
