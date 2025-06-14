package me.dean.ultimateTroll.Trolls;

import me.dean.ultimateTroll.Util.TrollAction;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class BurnTroll implements TrollAction {
    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Burn");
        meta.setLore(List.of(ChatColor.GRAY + "Burns the user for 3 seconds!"));
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void execute(Player executor, Player target) {
        target.setFireTicks(60);
        executor.sendMessage(ChatColor.GREEN + "Put "+target.getName()+" On fire!");
    }
}
