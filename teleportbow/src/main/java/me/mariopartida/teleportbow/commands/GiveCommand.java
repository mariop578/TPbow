package me.mariopartida.teleportbow.commands;

import me.mariopartida.teleportbow.Teleportbow;
import me.mariopartida.teleportbow.utility.BowUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveCommand implements CommandExecutor {
    private final Teleportbow plugin;
    private final BowUtils bowUtils;
    public GiveCommand(Teleportbow plugin) {
        this.plugin = plugin;
        this.bowUtils = new BowUtils(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p){
            if (p.isOp()){
                if (args.length == 0){
                    ItemStack bow = bowUtils.createTeleportBow();
                    p.getInventory().addItem(bow);
                    p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                    p.sendMessage(ChatColor.GREEN + "You have given yourself a tp bow!");
                } else{
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target == null) {
                        p.sendMessage(ChatColor.RED + "This player does not exist." );
                        return true;
                    }
                    ItemStack bow = bowUtils.createTeleportBow();
                    target.getInventory().addItem(bow);
                    target.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                    target.sendMessage(ChatColor.GREEN + "You have been given a tp bow!");
                }
            }
        }
        return true;
    }
}
