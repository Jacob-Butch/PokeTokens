package com.jake.poketokens.command.elements;

import com.google.common.collect.Lists;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.text.Text;

import javax.annotation.Nonnull;
import java.util.List;

import static com.jake.poketokens.util.CommandUtil.getListOfStringsMatchingLastWord;

public class SizeCommandElement extends CommandElement {

    public SizeCommandElement(Text key) { super(key); }

    @Nonnull
    @Override
    protected Object parseValue(@Nonnull CommandSource source, @Nonnull CommandArgs args) throws ArgumentParseException {
        return args.next();
    }

    @Nonnull
    @Override
    public List<String> complete(@Nonnull CommandSource src, @Nonnull CommandArgs args, @Nonnull CommandContext context) {
        return getListOfStringsMatchingLastWord(args, Lists.newArrayList("microscopic", "pygmy", "runt",
                "small", "ordinary", "huge", "giant", "enormous", "ginormous"));
    }

    @Nonnull
    @Override
    public Text getUsage(CommandSource src) {
        return Text.of("<size>");
    }
}
