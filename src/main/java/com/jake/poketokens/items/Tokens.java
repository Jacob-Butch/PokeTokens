package com.jake.poketokens.items;

import com.jake.poketokens.util.ItemUtil;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import scala.util.Random;

import java.util.List;

import static com.jake.poketokens.util.TextUtil.deserialize;
import static com.jake.poketokens.util.TextUtil.getList;

public class Tokens {

    private static ItemStack getToken(int amount){
        return ItemStack.of(ItemUtil.getType("pixelmon:marsh_badge"), amount);
    }

    public static ItemStack shinyToken(int amount){
        ItemStack token = getToken(amount);
        Text name = deserialize("&e&lShiny Token");
        List<Text> lore = getList("&eMake a pokemon shiny by doing &5'&d/claimshinytoken <slot>' &ewhile holding this");
        token.offer(Keys.DISPLAY_NAME, name);
        token.offer(Keys.ITEM_LORE, lore);
        return token;
    }

    public static ItemStack sizeToken(int amount){
        ItemStack token = getToken(amount);
        Text name = deserialize("&e&lSize Change Token");
        List<Text> lore = getList("&eChange a pokemon's size by doing &5'&d/claimsizetoken <slot> <size>&5' &ewhile holding this");
        token.offer(Keys.DISPLAY_NAME, name);
        token.offer(Keys.ITEM_LORE, lore);
        return token;
    }

    public static ItemStack haToken(int amount){
        ItemStack token = getToken(amount);
        Text name = deserialize("&e&lHidden Ability Token");
        List<Text> lore = getList(
                "&eChange a pokemon's ability to their hidden ability by doing &5'&d/claimhatoken <slot>&5' &ewhile holding this",
                "&c&oCan only be used on pokemon that have a hidden ability");
        token.offer(Keys.DISPLAY_NAME, name);
        token.offer(Keys.ITEM_LORE, lore);
        return token;
    }

    public static ItemStack genderToken(int amount){
        ItemStack token = getToken(amount);
        Text name = deserialize("&e&lGender Change Token");
        List<Text> lore = getList(
                "&eChange a pokemon's gender by doing &5'&d/claimgendertoken <slot>&5' &ewhile holding this",
                "&c&oCan only be used on pokemon with a gender");
        token.offer(Keys.DISPLAY_NAME, name);
        token.offer(Keys.ITEM_LORE, lore);
        return token;
    }

    public static ItemStack ballToken(int amount){
        ItemStack token = getToken(amount);
        Text name = deserialize("&e&lBall Change Token");
        List<Text> lore = getList("&eChange a pokemon's caught ball by doing &5'&d/claimballtoken <slot> <ball>&5' &ewhile holding this");
        token.offer(Keys.DISPLAY_NAME, name);
        token.offer(Keys.ITEM_LORE, lore);
        return token;
    }

    public static ItemStack randomToken(){
        int random = (new Random()).nextInt(5);
        switch (random){
            case 0: return shinyToken(1);
            case 1: return sizeToken(1);
            case 2: return haToken(1);
            case 3: return genderToken(1);
            case 4: return ballToken(1);
            default: return ItemStack.empty();
        }
    }
}
