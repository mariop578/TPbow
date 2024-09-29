package me.mariopartida.teleportbow.utility;

import me.mariopartida.teleportbow.Teleportbow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

// Create and Provide teleport bows
public class BowUtils {
    private final Teleportbow plugin;

    public BowUtils(Teleportbow plugin) {
        this.plugin = plugin;
    }

    public ItemStack createTeleportBow(){

        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-name")));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-lore")));
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.INFINITY, 1, false);
        bow.setItemMeta(bowMeta);
        return bow;
    }
}
