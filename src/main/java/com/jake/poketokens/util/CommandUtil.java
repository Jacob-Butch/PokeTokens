package com.jake.poketokens.util;

import com.google.common.base.Functions;
import com.jake.poketokens.command.elements.SizeCommandElement;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommandUtil {

    public static List<String> getListOfStringsMatchingLastWord(CommandArgs args, Collection<String> possibleCompletions) {
        Optional<String> optS = args.nextIfPresent();
        if(optS.isPresent()) {
            String s = optS.get();
            List<String> list = new ArrayList<>();
            if (!possibleCompletions.isEmpty()) {
                List<String> strings = possibleCompletions.stream().map(Functions.toStringFunction()).collect(Collectors.toList());
                for (String s1 : strings) {
                    if (doesStringStartWith(s, s1)) {
                        list.add(s1);
                    }
                }
            }
            return list;
        }
        return new ArrayList<>(possibleCompletions);
    }

    public static boolean doesStringStartWith(String original, String region) {
        return region.regionMatches(true, 0, original, 0, original.length());
    }

    public static CommandElement playerElement(){ return GenericArguments.player(Text.of("player")); }

    public static CommandElement slotElement(){ return GenericArguments.integer(Text.of("slot")); }

    public static CommandElement sizeElement(){ return new SizeCommandElement(Text.of("size")); }

    public static CommandElement amountElement(){
        return GenericArguments.optional(GenericArguments.integer(Text.of("amount")));
    }

}
