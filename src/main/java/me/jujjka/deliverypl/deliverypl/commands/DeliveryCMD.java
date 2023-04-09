package me.jujjka.deliverypl.deliverypl.commands;

import me.jujjka.deliverypl.deliverypl.language.LangMgr;
import me.jujjka.deliverypl.deliverypl.module.TransRoom;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeliveryCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){sender.sendMessage("Only players"); return false;}
        if(args.length < 2){sender.sendMessage(LangMgr.getLang().getString("ERROR.notArguments")); return false;}
        if(args[0].equalsIgnoreCase("send")){
            if(Bukkit.getPlayer(args[1]) == null){sender.sendMessage(String.format(LangMgr.getLang().getString("ERROR.notPlayer"), args[1])); return false;}
            Player p = (Player) sender;
            Player target = Bukkit.getPlayer(args[1]);
            TransRoom transRoom = new TransRoom(p,target);
            return true;
        } else if(args[0].equalsIgnoreCase("get")){
            if(Bukkit.getPlayer(args[1]) == null){sender.sendMessage(String.format(LangMgr.getLang().getString("ERROR.notPlayer"), args[1])); return false;}
            Player player = Bukkit.getPlayer(args[1]);
            Player trg = (Player) sender;
            if(TransRoom.getRoom(player,trg) != null){
                TransRoom transRoom = TransRoom.getRoom(player,trg);
                transRoom.get();
            }
        }
        return false;
    }
}
