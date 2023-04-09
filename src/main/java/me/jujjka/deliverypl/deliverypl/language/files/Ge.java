package me.jujjka.deliverypl.deliverypl.language.files;

import me.jujjka.deliverypl.deliverypl.Deliverypl;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Ge {
  private static File file;
    private static FileConfiguration customFile;
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin(Deliverypl.getPluginName()).getDataFolder(), "Ge");

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
            System.out.println("Couldn't save file Ge");
        }
    }
    public static void setupMessages(){
        setup();
        get().set("ERROR.maximum","§4Sie haben die Grenze erreicht!");
        get().set("ERROR.notPlayer","§4Spieler [%s] existiert nicht");
        get().set("ERROR.notArguments","§4Nicht genug Argumente");
        get().set("GUI.senditem","§bRessourcen einreichen");
        get().set("GUI.setinfoitem","§bHier können Sie Ihre Ressourcen einreichen");

        get().set("GUI.item_send_lore","§6Reichen Sie den Goldbarren ein");
        get().set("GUI.partition","§bZaun");
        get().options().copyDefaults(true);
        save();
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
