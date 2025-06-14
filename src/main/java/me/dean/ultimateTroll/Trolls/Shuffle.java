package me.dean.ultimateTroll.Trolls;

import me.dean.ultimateTroll.Util.TrollAction;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Shuffle implements TrollAction {

    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.REDSTONE_LAMP);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Shuffle");
        meta.setLore(List.of(ChatColor.GRAY + "Shuffles the player!"));
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void execute(Player executor, Player target) {
        if (!(executor.hasPermission("troll.use"))) {return;}
        Location currentLocation = target.getLocation();
        float randomYaw = (float) (Math.random() * 360.0 - 180.0);
        float randomPitch = (float) (Math.random() * 180.0 - 90.0);

        currentLocation.setYaw(randomYaw);
        currentLocation.setPitch(randomPitch);

        target.teleport(currentLocation);
        executor.sendMessage(ChatColor.GREEN+"shuffled "+target.getName());
    }
}
