package com.jake.poketokens.util;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

import java.util.ArrayList;
import java.util.List;

public class TextUtil {

    public static List<Text> getList(String... strings){
        List<Text> texts = new ArrayList<>();
        for(String string : strings){
            texts.add(deserialize(string));
        }
        return texts;
    }

    public static Text deserialize(String s) {
        return TextSerializers.FORMATTING_CODE.deserialize(s);
    }

}
