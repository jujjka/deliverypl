package me.jujjka.deliverypl.deliverypl.language.files;

import me.jujjka.deliverypl.deliverypl.Deliverypl;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class En {
    private static File file;
    private static FileConfiguration customFile;
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin(Deliverypl.getPluginName()).getDataFolder(), "En");

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
            System.out.println("Couldn't save file En");
        }
    }
    public static void setupMessages(){
        setup();
        get().set("ERROR.maximum","§4You have reached the limit!");
        get().set("ERROR.notPlayer","§4Player [%s] does not exist");
        get().set("ERROR.notArguments","§4Not enough arguments");
        get().set("GUI.senditem","§bSubmit Resources");
        get().set("GUI.setinfoitem","§bHere you can submit your resources");

        get().set("GUI.item_send_lore","§6Submit to the ingot");
        get().set("GUI.partition","");
        get().options().copyDefaults(true);
        save();
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
