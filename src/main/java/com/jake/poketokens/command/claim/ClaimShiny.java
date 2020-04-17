package com.jake.poketokens.command.claim;

import com.jake.poketokens.PokeTokens;
import com.jake.poketokens.helper.PokeHelper;
import com.jake.poketokens.items.Tokens;
import com.jake.poketokens.util.ItemUtil;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.common.item.inventory.util.ItemStackUtil;

import javax.annotation.Nonnull;

import static com.jake.poketokens.util.TextUtil.deserialize;

public class ClaimShiny implements CommandExecutor {

    @Nonnull
    public CommandResult execute(@Nonnull CommandSource src, @Nonnull CommandContext args) throws CommandException {
        if(!(src instanceof Player)){
            throw new CommandException(Text.of("You must be a player to execute this command!"));
        }
        Player player = (Player) src;
        ItemStack token = ItemUtil.getMainHand(player);
        if(ItemStackUtil.compareIgnoreQuantity(token, Tokens.shinyToken(1))) {
            int slot = args.<Integer>getOne("slot").orElse(-1);
            if(slot < 1 || slot > 6){
                throw new CommandException(Text.of("Invalid slot! Pick a slot between 1-6"));
            }
            PokeHelper helper = new PokeHelper(player, slot);
            if(!helper.pokemonInSlot()) {
                throw new CommandException(Text.of("There is no pokemon in that slot!"));
            }
            if(!helper.isShiny()){
                helper.makeShiny();
                ItemUtil.takeOne(player, token);
                player.sendMessage(deserialize("&2*&a&o" + helper.species() + " has been made shiny&2*"));
                PokeTokens.logger.info(player.getName() + " redeemed a Shiny Token on " + helper.species());
            } else {
                throw new CommandException(Text.of(helper.species() + " is already shiny!"));
            }
        } else {
            throw new CommandException(Text.of("You must be holding a Shiny Token!"));
        }
        return CommandResult.success();
    }
}
