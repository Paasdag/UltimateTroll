package me.dean.ultimateTroll.Trolls;

import me.dean.ultimateTroll.UltimateTroll;
import me.dean.ultimateTroll.Util.TrollAction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class InvertMovement implements TrollAction {
    private final Set<UUID> invertedPlayers = new HashSet<>();

    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Invert Movement");
        meta.setLore(List.of(ChatColor.GRAY + "(Toggable) Inverts movement"));
        item.setItemMeta(meta);
        return item;
    }

    private final Listener listener = new Listener() {
        @EventHandler
        public void onMove(PlayerMoveEvent event) {
            if (invertedPlayers.contains(event.getPlayer().getUniqueId())) {
                Vector movement = event.getTo().toVector().subtract(event.getFrom().toVector());
                event.getPlayer().setVelocity(movement.multiply(-1));
            }
        }
    };

    public InvertMovement() {
        Bukkit.getPluginManager().registerEvents(listener, UltimateTroll.getInstance());
    }


    @Override
    public void execute(Player executor, Player target) {
        UUID id = target.getUniqueId();
        if (invertedPlayers.contains(id)) {
            executor.sendMessage(ChatColor.RED + target.getName() + " is already inverted.");
            return;
        }

        invertedPlayers.add(id);
        executor.sendMessage(ChatColor.GREEN + "Inverted " + target.getName() + "'s movement for 5 seconds!");

        new BukkitRunnable() {
            @Override
            public void run() {
                invertedPlayers.remove(id);
            }
        }.runTaskLater(UltimateTroll.getInstance(), 20 * 5); // 5 seconds
    }
}
