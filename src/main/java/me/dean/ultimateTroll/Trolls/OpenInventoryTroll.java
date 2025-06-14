package me.dean.ultimateTroll.Trolls;

import me.dean.ultimateTroll.Util.TrollAction;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class OpenInventoryTroll implements TrollAction {

    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.CHERRY_CHEST_BOAT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Open inventory");
        meta.setLore(List.of(ChatColor.GRAY + "Opens the inventory of the trolling player"));
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void execute(Player executor, Player target) {
        Inventory targetinv = target.getInventory();
        target.openInventory(targetinv);

        executor.sendMessage(ChatColor.GREEN + "Opend "+target.getName()+" inventory");
    }
}
