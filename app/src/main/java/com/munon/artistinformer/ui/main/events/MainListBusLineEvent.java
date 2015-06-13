package com.munon.artistinformer.ui.main.events;


import com.hrules.busline.BusLineEvent;

public class MainListBusLineEvent extends BusLineEvent {
    public static final String ACTION_SHOW_LIST = "ACTION_SHOW_LIST";
    public static final String ACTION_SHOW_PROGRESS = "ACTION_SHOW_PROGRESS";
    public static final String ACTION_SHOW_TEXT = "ACTION_SHOW_TEXT";

    public MainListBusLineEvent(String action) {
        super(action);
    }

    public MainListBusLineEvent(String action, Object object) {
        super(action, object);
    }
}
