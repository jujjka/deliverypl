package me.jujjka.deliverypl.deliverypl.module;

import me.jujjka.deliverypl.deliverypl.inventory.DeliveryGUI;
import me.jujjka.deliverypl.deliverypl.inventory.GetDeliveryGUI;
import me.jujjka.deliverypl.deliverypl.language.LangMgr;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class TransRoom {

    static List<TransRoom> transRoomList = new ArrayList<>();
    static List<Player> playersRoomList = new ArrayList<>();
    private Player sender;
    private Player target;
    private DeliveryGUI deliveryGUI;
    private GetDeliveryGUI getDeliveryGUI;

    public TransRoom(Player sender, Player target) {
        this.sender = sender;
        this.target = target;
        deliveryGUI = new DeliveryGUI(sender,target);
        getDeliveryGUI = new GetDeliveryGUI(this);
        transRoomList.add(this);
        playersRoomList.add(sender);
        playersRoomList.add(target);
    }
    public void send(){
        if (getGetDeliveryGUI().getItems().size() < 9) {
            for (int i = 0; i < 9; i++){
                if(deliveryGUI.getInventory().getItem(i) != null){
                    getDeliveryGUI.getItems().add(deliveryGUI.getInventory().getItem(i));
                    deliveryGUI.getInventory().setItem(i,null);
                }
            }
        } else {
            sender.sendMessage(LangMgr.getLang().getString("ERROR.maximum"));
        }
    }
    public void get(){
            for (ItemStack stack : getDeliveryGUI.getItems()){
                target.getInventory().addItem(stack);
                getDeliveryGUI.getItems().clear();
            }
    }
    public static TransRoom getRoom(Player one, Player two){
        for(TransRoom transRoom : transRoomList){
            if(transRoom.getSender().equals(one)&& transRoom.getTarget().equals(two)){
                return transRoom;
            }
        }
        return null;
    }
    public Player getSender() {
        return sender;
    }

    public void setSender(Player sender) {
        this.sender = sender;
    }

    public Player getTarget() {
        return target;
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    public DeliveryGUI getDeliveryGUI() {
        return deliveryGUI;
    }

    public void setDeliveryGUI(DeliveryGUI deliveryGUI) {
        this.deliveryGUI = deliveryGUI;
    }

    public GetDeliveryGUI getGetDeliveryGUI() {
        return getDeliveryGUI;
    }

    public void setGetDeliveryGUI(GetDeliveryGUI getDeliveryGUI) {
        this.getDeliveryGUI = getDeliveryGUI;
    }

    public static List<Player> getPlayersRoomList() {
        return playersRoomList;
    }
}
