package com.jake.poketokens;

import com.jake.poketokens.command.claim.*;
import com.jake.poketokens.command.give.*;
import com.jake.poketokens.util.CommandUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;

import javax.inject.Inject;

@Plugin(id = "poketokens",
        name = "PokeTokens",
        version = "0.1",
        authors = "Jake",
        description = "Plugin to give out certain Pixelmon Modifying tokens for players to use",
        dependencies = @Dependency(id = "pixelmon"))
public class PokeTokens {

    public static Logger logger;

    @Inject
    public PokeTokens() {
        logger = LoggerFactory.getLogger("PokeTokens");
    }

    @Listener
    public void onServerStarting(GameStartingServerEvent event) {
        registerCommands();
    }

    private void registerCommands(){
        // Token Claiming Commands
        Sponge.getCommandManager().register(this, CommandSpec.builder()
                .arguments(CommandUtil.slotElement())
                .permission("poketokens.command.claim.gender")
                .executor(new ClaimGender())
                .build(), "claimgendertoken");
        Sponge.getCommandManager().register(this, CommandSpec.builder()
                .arguments(CommandUtil.slotElement())
                .permission("poketokens.command.claim.ha")
                .executor(new ClaimHA())
                .build(), "claimhatoken");
        Sponge.getCommandManager().register(this, CommandSpec.builder()
                .arguments(CommandUtil.slotElement())
                .permission("poketokens.command.claim.shiny")
                .executor(new ClaimShiny())
                .build(), "claimshinytoken");
        Sponge.getCommandManager().register(this, CommandSpec.builder()
                .arguments(CommandUtil.slotElement(), CommandUtil.sizeElement())
                .permission("poketokens.command.claim.size")
                .executor(new ClaimSize())
                .build(), "claimsizetoken");
        Sponge.getCommandManager().register(this, CommandSpec.builder()
                .arguments(CommandUtil.slotElement(), CommandUtil.ballElement())
                .permission("poketokens.command.claim.ball")
                .executor(new ClaimBall())
                .build(), "claimballtoken");

        // Token Giving Commands
        Sponge.getCommandManager().register(this, CommandSpec.builder()
                .arguments(CommandUtil.playerElement(), CommandUtil.amountElement())
                .permission("poketokens.command.give.gender")
                .executor(new GiveGender())
                .build(), "givegendertoken");
        Sponge.getCommandManager().register(this, CommandSpec.builder()
                .arguments(CommandUtil.playerElement(), CommandUtil.amountElement())
                .permission("poketokens.command.give.ha")
                .executor(new GiveHA())
                .build(), "givehatoken");
        Sponge.getCommandManager().register(this, CommandSpec.builder()
                .arguments(CommandUtil.playerElement(), CommandUtil.amountElement())
                .permission("poketokens.command.give.shiny")
                .executor(new GiveShiny())
                .build(), "giveshinytoken");
        Sponge.getCommandManager().register(this, CommandSpec.builder()
                .arguments(CommandUtil.playerElement(), CommandUtil.amountElement())
                .permission("poketokens.command.give.size")
                .executor(new GiveSize())
                .build(), "givesizetoken");
        Sponge.getCommandManager().register(this, CommandSpec.builder()
                .arguments(CommandUtil.playerElement(), CommandUtil.amountElement())
                .permission("poketokens.command.give.ball")
                .executor(new GiveBall())
                .build(), "giveballtoken");

        Sponge.getCommandManager().register(this, CommandSpec.builder()
                .arguments(CommandUtil.playerElement())
                .permission("poketokens.command.give.random")
                .executor(new GiveRandom())
                .build(), "giverandomtoken");
    }
}
