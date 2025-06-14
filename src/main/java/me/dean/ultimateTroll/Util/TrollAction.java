package me.dean.ultimateTroll.Util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface TrollAction {
    ItemStack getItem();
    void execute(Player executor, Player target);
}