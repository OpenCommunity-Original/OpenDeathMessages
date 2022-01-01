package org.opencommunity.opendeathmessages;

import org.bukkit.plugin.java.JavaPlugin;
import org.opencommunity.opendeathmessages.commands.CustomDeathMessagesCommand;
import org.opencommunity.opendeathmessages.listeners.PlayerDeathListener;
import org.opencommunity.opendeathmessages.listeners.PlayerKilledByEntityListener;
import org.opencommunity.opendeathmessages.listeners.PlayerLoginListener;

import java.util.HashMap;

public class CustomDeathMessages extends JavaPlugin {

    public HashMap<String, String> deathMessage = new HashMap<String, String>();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        registerCommandsListeners();
    }

    public void registerCommandsListeners() {
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerKilledByEntityListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerLoginListener(this), this);
        getCommand("odm").setExecutor(new CustomDeathMessagesCommand(this));
        getCommand("odm").setTabCompleter(new CustomDeathMessagesCommand(this));
    }
}