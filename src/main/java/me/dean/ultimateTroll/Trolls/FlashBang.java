package me.dean.ultimateTroll.Trolls;

import me.dean.ultimateTroll.UltimateTroll;
import me.dean.ultimateTroll.Util.TrollAction;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class FlashBang implements TrollAction {
    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.SNOW_BLOCK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Flashbang");
        meta.setLore(List.of(ChatColor.GRAY + "Flashbangs the player"));
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public void execute(Player executor, Player target) {
        Location loc = target.getLocation();

        executor.sendMessage(ChatColor.GREEN + "Flashbanged " + target.getName());

        new BukkitRunnable() {
            int flashes = 0;

            @Override
            public void run() {
                if (flashes >= 3 || !target.isOnline()) {
                    cancel();
                    return;
                }
                loc.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 2f, 2f);
                loc.getWorld().spawnParticle(Particle.FLASH, target.getLocation(), 10);
                flashes++;
            }
        }.runTaskTimer(UltimateTroll.getInstance(), 0L, 20L);


        target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1));
        target.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 60, 2));
        target.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 60, 1));
    }
}
