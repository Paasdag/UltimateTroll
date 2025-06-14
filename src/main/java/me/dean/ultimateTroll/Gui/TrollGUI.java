package me.dean.ultimateTroll.Gui;

import me.dean.ultimateTroll.Trolls.*;
import me.dean.ultimateTroll.UltimateTroll;
import me.dean.ultimateTroll.Util.TrollAction;
import me.dean.ultimateTroll.Util.TrollRegistry;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class TrollGUI {
    private static final List<TrollAction> actions = List.of(
            new LeviationTroll(),
            new OpenInventoryTroll(),
            new BurnTroll(),
            new FlashBang()
    );


    public static void openTrollMenu(Player executor, Player target) {
        List<TrollAction> trolls = TrollRegistry.getTrolls();
        int size = ((trolls.size() - 1) / 9 + 1) * 9;
        Inventory gui = Bukkit.createInventory(null, size, "Currently trolling " + target.getName());

        for (int i = 0; i < trolls.size(); i++) {
            gui.setItem(i, trolls.get(i).getItem());
        }

        executor.openInventory(gui);

        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onClick(InventoryClickEvent e) {
                if (!(e.getWhoClicked() instanceof Player)) return;
                Player clicker = (Player) e.getWhoClicked();

                if (!e.getView().getTitle().equals("Currently trolling " + target.getName())) return;
                e.setCancelled(true);

                ItemStack clicked = e.getCurrentItem();
                if (clicked == null || clicked.getType() == Material.AIR) return;

                for (TrollAction action : TrollRegistry.getTrolls()) {
                    if (clicked.isSimilar(action.getItem())) {
                        action.execute(clicker, target);
                        clicker.closeInventory();
                        HandlerList.unregisterAll(this);
                        break;
                    }
                }
            }
        }, UltimateTroll.getInstance());
    }
}
