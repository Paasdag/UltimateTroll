package me.dean.ultimateTroll.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrollRegistry {
    private static final List<TrollAction> trolls = new ArrayList<>();

    public static void registerTrolls(TrollAction troll){
        trolls.add(troll);
    }

    public static List<TrollAction> getTrolls(){
        return Collections.unmodifiableList(trolls);
    }
}
