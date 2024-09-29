package me.mariopartida.teleportbow;

import me.mariopartida.teleportbow.commands.GiveCommand;
import me.mariopartida.teleportbow.listeners.TeleportBowListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Teleportbow extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        System.out.println("``````````````````````````````````````````````````");
        System.out.println("Teleportation Bow Plugin Initiated!!!!");
        System.out.println("``````````````````````````````````````````````````");
        getCommand("givebow").setExecutor(new GiveCommand(this));
        getServer().getPluginManager().registerEvents(new TeleportBowListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
