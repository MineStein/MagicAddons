package com.aurelia_network.magicaddons.actions;

import com.elmakers.mine.bukkit.action.BaseSpellAction;
import com.elmakers.mine.bukkit.api.action.CastContext;
import com.elmakers.mine.bukkit.api.spell.SpellResult;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

/**
 * Copyright (c) 2013-2017 Tyler Grissom
 */
public class ChatAction extends BaseSpellAction {

    private String message;
    private List<String> randomizedMessages;

    @Override
    public void prepare(CastContext context, ConfigurationSection parameters) {
        super.prepare(context, parameters);

        this.message = parameters.getString("message", "Default Magic message.");
        this.randomizedMessages = parameters.getStringList("randomized_messages");
    }

    public SpellResult perform(CastContext castContext) {
        Entity entity = castContext.getTargetEntity();

        if (castContext.getTargetEntity() == null) return SpellResult.NO_TARGET;
        if (entity instanceof Player) {
            Player player = (Player) entity;

            if (randomizedMessages == null) {
                player.chat(message);
            } else {
                String msg = randomizedMessages.get(new Random().nextInt(randomizedMessages.size()));

                player.chat(msg);
            }
        }

        return SpellResult.FAIL;
    }
}
