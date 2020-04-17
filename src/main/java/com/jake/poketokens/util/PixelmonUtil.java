package com.jake.poketokens.util;

import com.pixelmonmod.pixelmon.enums.EnumGrowth;

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

}
