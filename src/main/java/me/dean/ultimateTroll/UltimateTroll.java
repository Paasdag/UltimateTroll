package me.dean.ultimateTroll;

import dev.jorel.commandapi.CommandAPI;
import me.dean.ultimateTroll.Trolls.*;
import me.dean.ultimateTroll.Util.TrollRegistry;
import me.dean.ultimateTroll.commands.TrollCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class UltimateTroll extends JavaPlugin {
    private static UltimateTroll instance;

    @Override
    public void onEnable() {
        CommandAPI.onEnable();
        instance = this;
        TrollCommand.register();
        TrollRegistry.registerTrolls(new Launch());
        TrollRegistry.registerTrolls(new FakeOp());
        TrollRegistry.registerTrolls(new DemoScreenTroll());
        TrollRegistry.registerTrolls(new Shuffle());
        TrollRegistry.registerTrolls(new ShuffleInventory());
        TrollRegistry.registerTrolls(new SmiteTroll());
        TrollRegistry.registerTrolls(new InvertMovement());
        TrollRegistry.registerTrolls(new TallnessTroll());
        TrollRegistry.registerTrolls(new LeviationTroll());
        TrollRegistry.registerTrolls(new BurnTroll());
        TrollRegistry.registerTrolls(new FlashBang());
    }

    @Override
    public void onDisable() {

    }

    public static UltimateTroll getInstance() {
        return instance;
    }
}
