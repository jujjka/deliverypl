package me.jujjka.deliverypl.deliverypl.module;

import me.jujjka.deliverypl.deliverypl.inventory.DeliveryGUI;
import me.jujjka.deliverypl.deliverypl.inventory.GetDeliveryGUI;
import org.bukkit.entity.Player;

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
        getDeliveryGUI = new GetDeliveryGUI(target);
        transRoomList.add(this);
        playersRoomList.add(sender);
        playersRoomList.add(target);
    }
    public static TransRoom getRoom(Player one, Player two){
        for(TransRoom transRoom : transRoomList){
            if(transRoom.getSender().equals(one )&& transRoom.getTarget().equals(two)){
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
