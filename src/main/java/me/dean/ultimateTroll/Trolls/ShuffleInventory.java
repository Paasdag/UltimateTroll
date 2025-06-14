package me.dean.ultimateTroll.Trolls;

import me.dean.ultimateTroll.Util.TrollAction;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleInventory implements TrollAction {

    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.CHEST_MINECART);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Shuffle inventory");
        meta.setLore(List.of(ChatColor.GRAY + "Shuffles the inventory!"));
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void execute(Player executor, Player target) {
        ItemStack[] contents = target.getInventory().getContents();
        List<ItemStack> items = new ArrayList<>();

        for (ItemStack item : contents) {
            if (item != null) {
                items.add(item);
            }
        }

        Collections.shuffle(items);

        ItemStack[] newContents = new ItemStack[contents.length];
        int index = 0;
        for (int i = 0; i < newContents.length; i++) {
            if (contents[i] != null && index < items.size()) {
                newContents[i] = items.get(index++);
            } else {
                newContents[i] = null;
            }
        }

        target.getInventory().setContents(newContents);
        executor.sendMessage(ChatColor.GREEN+"Shuffled "+target.getName()+"'s Inventory");
    }
}
