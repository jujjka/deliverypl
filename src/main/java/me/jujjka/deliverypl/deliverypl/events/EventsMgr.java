package me.jujjka.deliverypl.deliverypl.events;

import me.jujjka.deliverypl.deliverypl.Deliverypl;

public class EventsMgr {

    public static void register(){


        Deliverypl.getInstance().getServer().getPluginManager().registerEvents(new ClickSendGui(),Deliverypl.getInstance());

    }
}
