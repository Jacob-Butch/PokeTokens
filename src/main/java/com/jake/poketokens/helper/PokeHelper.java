package com.jake.poketokens.helper;

import com.jake.poketokens.util.PixelmonUtil;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.Gender;
import com.pixelmonmod.pixelmon.enums.EnumGrowth;
import com.pixelmonmod.pixelmon.enums.items.EnumPokeballs;
import org.spongepowered.api.entity.living.player.Player;

@SuppressWarnings("all")
public class PokeHelper {

    private Pokemon pokemon;

    public PokeHelper(Player player, int slot){
        this.pokemon = Pixelmon.storageManager.getParty(player.getUniqueId()).get(slot - 1);
    }

    public Pokemon getPokemon() { return pokemon; }

    public boolean pokemonInSlot() { return pokemon != null; }

    public String species() { return pokemon.getSpecies().name; }

    public String genderName() { return pokemon.getGender().name(); }

    public String sizeName() { return pokemon.getGrowth().name(); }

    public EnumGrowth getSize() { return pokemon.getGrowth(); }

    public void setSize(EnumGrowth size) { pokemon.setGrowth(size); }

    public void setSize(String size){ this.setSize(PixelmonUtil.growthFromString(size)); }

    public boolean isShiny() { return pokemon.isShiny(); }

    public void makeShiny() { pokemon.setShiny(true); }

    public boolean isHiddenAbility(){ return pokemon.getAbilitySlot() == 2; }

    public boolean hasHiddenAbility() { return pokemon.getBaseStats().abilities[2] != null; }

    public void giveHiddenAbility() { pokemon.setAbilitySlot(2); }

    public boolean hasGender() { return pokemon.getGender() != Gender.None; }

    public void swapGender() {
        if(hasGender()) {
            pokemon.setGender(pokemon.getGender() == Gender.Male ? Gender.Female : Gender.Male);
        }
    }

    public void setBall(EnumPokeballs ball){ pokemon.setCaughtBall(ball); }

    public boolean isCaughtBall(EnumPokeballs ball){ return pokemon.getCaughtBall() == ball; }
}
