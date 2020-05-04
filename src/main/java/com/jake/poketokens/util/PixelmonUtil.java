package com.jake.poketokens.util;

import com.pixelmonmod.pixelmon.enums.EnumGrowth;
import com.pixelmonmod.pixelmon.enums.items.EnumPokeballs;

import java.util.HashMap;
import java.util.Map;

public class PixelmonUtil {

    public static EnumGrowth growthFromString(String string){
        switch (string.toLowerCase()){
            case "microscopic": return EnumGrowth.Microscopic;
            case "pygmy": return EnumGrowth.Pygmy;
            case "runt": return EnumGrowth.Runt;
            case "small": return EnumGrowth.Small;
            case "ordinary": return EnumGrowth.Ordinary;
            case "huge": return EnumGrowth.Huge;
            case "giant": return EnumGrowth.Giant;
            case "enormous": return EnumGrowth.Enormous;
            case "ginormous": return EnumGrowth.Ginormous;
            default: return null;
        }
    }

    public static Map<String, EnumGrowth> getSizes(){
        Map<String, EnumGrowth> sizes = new HashMap<>();
        for(EnumGrowth size : EnumGrowth.values()){
            sizes.put(size.name().toLowerCase(), size);
        }
        return sizes;
    }

    public static Map<String, EnumPokeballs> getBalls(){
        Map<String, EnumPokeballs> balls = new HashMap<>();
        for(EnumPokeballs ball : EnumPokeballs.values()){
            balls.put(ball.getFilenamePrefix().replace("_", " ").split(" ")[0], ball);
        }
        return balls;
    }
}
