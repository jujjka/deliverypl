package me.jujjka.deliverypl.deliverypl.language.files;

import me.jujjka.deliverypl.deliverypl.Deliverypl;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Ru {
    private static File file;
    private static FileConfiguration customFile;
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin(Deliverypl.getPluginName()).getDataFolder(), "Ru");

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
            System.out.println("Couldn't save file Ru");
        }
    }
    public static void setupMessages(){
        setup();
        get().set("ERROR.maximum","§4Вы достигли предела!");
        get().set("ERROR.notPlayer","§4Игрока [%s] не существует");
        get().set("ERROR.notArguments","§4Недостаочно аргументов");
        get().set("GUI.senditem","§bОтправьте ресурсы");
        get().set("GUI.setinfoitem","§bТут вы можете отправить свои ресурсы");

        get().set("GUI.item_send_lore","§6Отправьте на слиток");
        get().set("GUI.partition","§bОтправьте!");
        get().options().copyDefaults(true);
        save();
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
