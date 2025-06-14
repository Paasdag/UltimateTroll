package me.dean.ultimateTroll.Trolls;

import me.dean.ultimateTroll.UltimateTroll;
import me.dean.ultimateTroll.Util.TrollAction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class TallnessTroll implements TrollAction {

    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.ARMOR_STAND);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Tallness");
        meta.setLore(List.of(ChatColor.GRAY + "You suddently grow tall :O"));
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void execute(Player executor, Player target) {
        executor.sendMessage(ChatColor.GREEN + "Made "+target.getName()+" taller");
        Bukkit.getScheduler().runTaskLater (UltimateTroll.getInstance(), () -> target.getAttribute(Attribute.SCALE).setBaseValue(1.2), 20);
        Bukkit.getScheduler().runTaskLater (UltimateTroll.getInstance(), () -> target.getAttribute(Attribute.SCALE).setBaseValue(1), 20*6);
    }
}
