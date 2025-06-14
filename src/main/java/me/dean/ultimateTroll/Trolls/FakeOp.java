package me.dean.ultimateTroll.Trolls;

import me.dean.ultimateTroll.Util.TrollAction;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class FakeOp implements TrollAction {
    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.CHERRY_SIGN);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Fake op");
        meta.setLore(List.of(ChatColor.GRAY + "Fake ops the player!"));
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void execute(Player executor, Player target) {
        target.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC +"[Console: Made "+target.getName()+" a server operator]");
        executor.sendMessage(ChatColor.GREEN + "Fake opped "+ target.getName());
    }
}
