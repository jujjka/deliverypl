package me.jujjka.deliverypl.deliverypl.commands;

import me.jujjka.deliverypl.deliverypl.Deliverypl;

public class CommandsMgr {

    public static void  register(){
        Deliverypl.getInstance().getCommand("trans").setExecutor(new DeliveryCMD());
    }
}
