package data.utils.touhou;

import com.fs.starfarer.api.Global;

public class touhouUtil {
    private static final String touhou_SHIP_SYSTEM = "shipSystem";
    private static final String touhou_STAR_SYSTEMS = "starSystems";
    private static final String touhou_HULL_MOD = "hullMod";

    public static String getString(String category, String id) {
        return Global.getSettings().getString(category, id);
    }

    public static String getShipSystemString(String id) {
        return getString(touhou_SHIP_SYSTEM, id);
    }

    public static String getStarSystemsString(String id) {
        return getString(touhou_STAR_SYSTEMS, id);
    }

    public static String getHullModString(String id) {
        return getString(touhou_HULL_MOD, id);
    }
}
