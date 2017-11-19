package com.aurelia_network.magicaddons.command;

import com.aurelia_network.magicaddons.Main;
import com.elmakers.mine.bukkit.api.magic.Mage;
import com.elmakers.mine.bukkit.api.magic.MagicAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright (c) 2013-2017 Tyler Grissom
 */
public class BalanceCommand extends CommandBase {

    private Main plugin;
    private MagicAPI api;

    public Main getPlugin() {
        return plugin;
    }

    public BalanceCommand(Main plugin) {
        this.plugin = plugin;
        this.api = plugin.getMagicAPI();
    }

    void execute(CommandSender sender, Command command, String[] args) {
        if (sender instanceof Player) {
            Mage mage = api.getMage(sender);

            sender.sendMessage("§6(§eMagic§6) §7Completion Credits: §e" + mage.getSkillPoints());
        } else {
            sender.sendMessage("§6(§eMagic§6) §cYou must be a player to do this.");
        }
    }
}
