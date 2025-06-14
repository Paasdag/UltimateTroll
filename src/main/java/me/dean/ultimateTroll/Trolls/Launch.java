package me.dean.ultimateTroll.Trolls;

import me.dean.ultimateTroll.Util.TrollAction;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.List;

public class Launch implements TrollAction {
    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Launch");
        meta.setLore(List.of(ChatColor.GRAY + "Launch the player into the air!"));
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void execute(Player executor, Player target) {
        Vector v = executor.getLocation().getDirection().multiply(-1).setY(1);
        target.setVelocity(v);
        executor.sendMessage(ChatColor.GREEN + "Launched " + target.getName());
    }
}
