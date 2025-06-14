package me.dean.ultimateTroll.Trolls;

import me.dean.ultimateTroll.Util.TrollAction;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class LeviationTroll implements TrollAction {

    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.SPLASH_POTION);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Leviation");
        meta.setLore(List.of(ChatColor.GRAY + "Sky goes brrr"));
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void execute(Player executor, Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 120, 2));
        executor.sendMessage(ChatColor.GREEN + "Gave "+target.getName()+" Leviation");
    }
}
