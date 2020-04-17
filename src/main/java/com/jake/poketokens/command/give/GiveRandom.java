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

public class GiveRandom implements CommandExecutor {

    @Nonnull
    public CommandResult execute(@Nonnull CommandSource src, @Nonnull CommandContext args) throws CommandException {
        Player player = args.<Player>getOne("player").orElseThrow(() -> new CommandException(of("Invalid player!")));
        ItemStack token = Tokens.randomToken();
        if(token.getType().equals(ItemTypes.NONE)){
            throw new CommandException(of("Unable to fetch token item type. Is Pixelmon installed?"));
        }
        if(ItemUtil.giveItem(player, token)){
            player.sendMessage(deserialize("&2*&a&oYou've been given a Random Token&2*"));
        } else {
            player.sendMessage(deserialize("&2*&a&oA Random Token was dropped at your feet because your inventory was full&2*"));
        }
        PokeTokens.logger.info(player.getName() + " has been given a Random Token");
        return CommandResult.success();
    }
}
