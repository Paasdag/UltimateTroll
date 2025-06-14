package me.dean.ultimateTroll.Trolls;

import me.dean.ultimateTroll.Util.TrollAction;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class SmiteTroll implements TrollAction {

    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.LIGHTNING_ROD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Smite");
        meta.setLore(List.of(ChatColor.GRAY + "Smites the player!"));
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void execute(Player executor, Player target) {
        target.getWorld().strikeLightningEffect(target.getLocation());
        executor.sendMessage(ChatColor.GREEN+"Smited "+target.getName());
    }
}
