package com.aurelia_network.magicaddons.actions;

import com.elmakers.mine.bukkit.action.BaseSpellAction;
import com.elmakers.mine.bukkit.api.action.CastContext;
import com.elmakers.mine.bukkit.api.spell.SpellResult;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * Copyright (c) 2013-2017 Tyler Grissom
 */
public class ClearChatAction extends BaseSpellAction {

    private boolean global, targetSource;
    private int repeat;
    private String message;

    @Override
    public void prepare(CastContext context, ConfigurationSection parameters) {
        super.prepare(context, parameters);

        this.global = parameters.getBoolean("global", false);
        this.targetSource = parameters.getBoolean("target_source", true);
        this.repeat = parameters.getInt("repeat", 100);
        this.message = parameters.getString("message", "");
    }

    public SpellResult perform(CastContext castContext) {
        if (repeat < 1) return SpellResult.FAIL;

        if (global) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!targetSource && player.getName().equals(castContext.getMage().getName())) continue;

                for (int i = 0; i < repeat; i++) {
                    player.sendMessage(message);
                }
            }

            return SpellResult.CAST;
        }

        Entity entity = castContext.getTargetEntity();

        if (entity != null && entity instanceof Player) {
            Player player = (Player) entity;

            for (int i = 0; i < repeat; i++) {
                player.sendMessage(message);
            }
        }

        return SpellResult.CAST;
    }
}
