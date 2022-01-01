package org.opencommunity.opendeathmessages.listeners;

import org.bukkit.event.Listener;
import org.opencommunity.opendeathmessages.CustomDeathMessages;

public class PlayerLoginListener implements Listener {

    public CustomDeathMessages plugin;

    public PlayerLoginListener(CustomDeathMessages plugin) {
        this.plugin = plugin;
    }
}
