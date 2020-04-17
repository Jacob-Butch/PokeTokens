package com.jake.poketokens.command.give;

import com.jake.poketokens.PokeTokens;
import com.jake.poketokens.items.Tokens;
import com.jake.poketokens.util.ItemUtil;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;

import javax.annotation.Nonnull;

import static com.jake.poketokens.util.TextUtil.deserialize;
import static org.spongepowered.api.text.Text.of;

public class GiveGender implements CommandExecutor {

    @Nonnull
    public CommandResult execute(@Nonnull CommandSource src, @Nonnull CommandContext args) throws CommandException {
        Player player = args.<Player>getOne("player").orElseThrow(() -> new CommandException(of("Invalid player!")));
        int amount = args.<Integer>getOne("amount").orElse(1);
        if(amount < 1 || amount > 64){
            throw new CommandException(of("Invalid amount! Choose a number between 1-64"));
        }
        ItemStack token = Tokens.genderToken(amount);
        if(token.getType().equals(ItemTypes.NONE)){
            throw new CommandException(of("Unable to fetch token item type. Is Pixelmon installed?"));
        }
        if(ItemUtil.giveItem(player, token)){
            player.sendMessage(deserialize("&2*&a&oYou've been given a Gender Token&2*"));
        } else {
            player.sendMessage(deserialize("&2*&a&oThe Gender Token would not fit in your inventory, so it was dropped at your feet&2*"));
        }
        PokeTokens.logger.info(player.getName() + " has been given a Gender Token");
        return CommandResult.success();
    }
}
