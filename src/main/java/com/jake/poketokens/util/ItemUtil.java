package com.jake.poketokens.util;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.event.cause.EventContextKeys;
import org.spongepowered.api.event.cause.entity.spawn.SpawnTypes;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.entity.MainPlayerInventory;
import org.spongepowered.api.world.extent.Extent;

public class ItemUtil {

    @SuppressWarnings("deprecation")
    public static boolean giveItem(Player player, ItemStack item){
        if(player.getInventory().query(MainPlayerInventory.class).canFit(item)){
            player.getInventory().query(MainPlayerInventory.class).offer(item);
            return true;
        } else {
            Extent extent = player.getWorld();
            Entity entityItem = extent.createEntity(EntityTypes.ITEM, player.getPosition());
            entityItem.offer(Keys.REPRESENTED_ITEM, item.createSnapshot());
            try(CauseStackManager.StackFrame frame = Sponge.getCauseStackManager().pushCauseFrame()) {
                frame.addContext(EventContextKeys.SPAWN_TYPE, SpawnTypes.PLACEMENT);
                extent.spawnEntity(entityItem);
            }
            return false;
        }
    }

    public static ItemType getType(String id){
        return Sponge.getRegistry().getType(ItemType.class, id).orElse(ItemTypes.NONE);
    }

    public static ItemStack getMainHand(Player player){
        return player.getItemInHand(HandTypes.MAIN_HAND).orElse(ItemStack.empty());
    }

    public static void takeOne(Player player, ItemStack item){
        if(item.getQuantity() > 1){
            item.setQuantity(item.getQuantity() - 1);
            player.setItemInHand(HandTypes.MAIN_HAND, item);
        } else {
            player.setItemInHand(HandTypes.MAIN_HAND, ItemStack.empty());
        }
    }
}
