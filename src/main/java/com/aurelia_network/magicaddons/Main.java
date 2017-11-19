package com.aurelia_network.magicaddons;

import com.aurelia_network.magicaddons.command.BalanceCommand;
import com.elmakers.mine.bukkit.api.magic.MagicAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright (c) 2013-2017 Tyler Grissom
 */
public class Main extends JavaPlugin {

    private Main plugin;
    private MagicAPI magicAPI;

    public Main getPlugin() {
        return plugin;
    }

    public MagicAPI getMagicAPI() {
        return magicAPI;
    }

    @Override
    public void onEnable() {
        plugin = this;
        magicAPI = (MagicAPI) Bukkit.getPluginManager().getPlugin("Magic");

        getCommand("cc").setExecutor(new BalanceCommand(this));
    }
}
