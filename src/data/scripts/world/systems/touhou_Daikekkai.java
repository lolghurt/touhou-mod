package data.scripts.world.systems;

import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.econ.impl.HeavyIndustry;
import com.fs.starfarer.api.impl.campaign.ids.*;
import com.fs.starfarer.api.impl.campaign.procgen.NebulaEditor;
//import com.fs.starfarer.api.impl.campaign.procgen.StarSystemGenerator;
//import com.fs.starfarer.api.impl.campaign.procgen.themes.SalvageSpecialAssigner;
import com.fs.starfarer.api.impl.campaign.procgen.StarAge;
import com.fs.starfarer.api.impl.campaign.terrain.HyperspaceTerrainPlugin;
import com.fs.starfarer.api.impl.campaign.terrain.EventHorizonPlugin;
import com.fs.starfarer.api.util.Misc;
import data.utils.touhou.touhouUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

//import static com.fs.starfarer.api.impl.campaign.terrain.DebrisFieldTerrainPlugin.DebrisFieldParams;
//import static com.fs.starfarer.api.impl.campaign.terrain.DebrisFieldTerrainPlugin.DebrisFieldSource;
import static data.scripts.world.touhou_WorldGen.addMarketplace;

public class touhou_Daikekkai {
    public void generate(SectorAPI sector) {
        //create a star system
        StarSystemAPI system = sector.createStarSystem("Daikekkai");
        //set its location
        system.getLocation().set(22000f, 14200f);
        //set background image
        system.setBackgroundTextureFilename("graphics/backgrounds/background2.jpg");

        //the star
        PlanetAPI main_star = system.initStar("touhou_Daikekkai", StarTypes.ORANGE, 700f, 800f, 30f, 0.5f, 3f);
        //background light color
        main_star.setCustomDescriptionId("touhou_Daikekkai");
        system.setLightColor(new Color(255, 189, 61));


        //Gensokyo main planet
        PlanetAPI gensokyo = system.addPlanet("touhou_planet_gensokyo", main_star, touhouUtil.getStarSystemsString("planet_name_gensokyo"), "gas_giant", 215, 400f, 3000f, 92f);

        //humans somehow live out here
        MarketAPI gensokyoMarket = addMarketplace("touhou_gensokyo", gensokyo, null
                , gensokyo.getName(), 3,
                new ArrayList<>(
                        Arrays.asList(
                                Conditions.POPULATION_3,
                                Conditions.VOLATILES_DIFFUSE,
                                Conditions.HIGH_GRAVITY
                        )),
                new ArrayList<>(
                        Arrays.asList(
                                Submarkets.SUBMARKET_BLACK,
                                Submarkets.SUBMARKET_OPEN,
                                Submarkets.SUBMARKET_STORAGE
                        )),
                new ArrayList<>(
                        Arrays.asList(
                                Industries.POPULATION,
                                Industries.SPACEPORT,
                                Industries.BATTLESTATION,
                                Industries.GROUNDDEFENSES,
                                Industries.MINING,
                                Industries.PATROLHQ
                        )),
                0.3f,
                true,
                true);
        //make a custom description which is specified in descriptions.csv
        gensokyo.setCustomDescriptionId("touhou_planet_gensokyo");

        PlanetAPI village = system.addPlanet("touhou_planet_village", gensokyo, touhouUtil.getStarSystemsString("planet_name_village"), "terran", 110, 180, 190f, 30f);

        MarketAPI villageMarket = addMarketplace("touhou_gensokyo", village, null
                , village.getName(), 5,
                new ArrayList<>(
                        Arrays.asList(
                                Conditions.POPULATION_5,
                                Conditions.FARMLAND_ADEQUATE,
                                Conditions.TERRAN,
                                Conditions.HABITABLE,
                                Conditions.EXTREME_WEATHER
                        )),
                new ArrayList<>(
                        Arrays.asList(
                                Submarkets.SUBMARKET_BLACK,
                                Submarkets.SUBMARKET_OPEN,
                                Submarkets.GENERIC_MILITARY,
                                Submarkets.SUBMARKET_STORAGE
                        )),
                new ArrayList<>(
                        Arrays.asList(
                                Industries.POPULATION,
                                Industries.SPACEPORT,
                                Industries.BATTLESTATION,
                                Industries.HIGHCOMMAND,
                                Industries.FARMING,
                                Industries.HEAVYINDUSTRY
                        )),
                0.3f,
                false,
                true);
        village.setCustomDescriptionId("touhou_planet_village");
        villageMarket.getIndustry(Industries.HEAVYINDUSTRY).setAICoreId(Commodities.BETA_CORE);
        ((HeavyIndustry) villageMarket.getIndustry(Industries.HEAVYINDUSTRY)).setNanoforge(new SpecialItemData(Items.CORRUPTED_NANOFORGE, null));

        PlanetAPI forest = system.addPlanet("touhou_planet_forest", gensokyo, touhouUtil.getStarSystemsString("planet_name_forest"), "jungle", 110, 90, 425f, 18);
        Misc.initConditionMarket(forest);
        forest.getMarket().addCondition(Conditions.INIMICAL_BIOSPHERE);
        forest.getMarket().addCondition(Conditions.ORGANICS_PLENTIFUL);
        forest.getMarket().addCondition(Conditions.JUNGLE);
        forest.setCustomDescriptionId("touhou_planet_forest");

        PlanetAPI bamboo = system.addPlanet("touhou_planet_bamboo", gensokyo, touhouUtil.getStarSystemsString("planet_name_bamboo"), "arid", 110, 120, 630f, 102f);

        MarketAPI bambooMarket = addMarketplace("touhou_gensokyo", bamboo, null
                , bamboo.getName(), 3,
                new ArrayList<>(
                        Arrays.asList(
                                Conditions.POPULATION_3,
                                Conditions.FARMLAND_POOR,
                                Conditions.ORGANICS_PLENTIFUL,
                                Conditions.ARID
                        )),
                new ArrayList<>(
                        Arrays.asList(
                                Submarkets.SUBMARKET_BLACK,
                                Submarkets.SUBMARKET_OPEN,
                                Submarkets.SUBMARKET_STORAGE
                        )),
                new ArrayList<>(
                        Arrays.asList(
                                Industries.POPULATION,
                                Industries.SPACEPORT,
                                Industries.PATROLHQ,
                                Industries.MINING
                        )),
                0.3f,
                false,
                true);
        bamboo.setCustomDescriptionId("touhou_planet_bamboo");

        PlanetAPI mountain = system.addPlanet("touhou_planet_mountain", main_star, touhouUtil.getStarSystemsString("planet_name_mountain"), "arid", 110, 120, 4200f, 182f);

        MarketAPI mountainMarket = addMarketplace("touhou_gensokyo", mountain, null
                , mountain.getName(), 4,
                new ArrayList<>(
                        Arrays.asList(
                                Conditions.POPULATION_4,
                                Conditions.ARID,
                                Conditions.EXTREME_WEATHER,
                                Conditions.ORE_ABUNDANT,
                                Conditions.RARE_ORE_MODERATE,
                                Conditions.RUINS_EXTENSIVE
                        )),
                new ArrayList<>(
                        Arrays.asList(
                                Submarkets.SUBMARKET_BLACK,
                                Submarkets.SUBMARKET_OPEN,
                                Submarkets.SUBMARKET_STORAGE
                        )),
                new ArrayList<>(
                        Arrays.asList(
                                Industries.POPULATION,
                                Industries.SPACEPORT,
                                Industries.BATTLESTATION,
                                Industries.PATROLHQ,
                                Industries.FARMING,
                                Industries.HEAVYINDUSTRY
                        )),
                0.3f,
                false,
                true);
        mountain.setCustomDescriptionId("touhou_planet_mountain");

        PlanetAPI jigoku = system.addPlanet("touhou_planet_jigoku", main_star, touhouUtil.getStarSystemsString("planet_name_jigoku"), "lava", 110, 90, 6000f, 225f);
        Misc.initConditionMarket(jigoku);
        jigoku.getMarket().addCondition(Conditions.EXTREME_WEATHER);
        jigoku.getMarket().addCondition(Conditions.POOR_LIGHT);
        jigoku.getMarket().addCondition(Conditions.EXTREME_TECTONIC_ACTIVITY);
        jigoku.getMarket().addCondition(Conditions.VERY_HOT);
        jigoku.getMarket().addCondition(Conditions.RARE_ORE_ULTRARICH);
        jigoku.getMarket().addCondition(Conditions.ORE_ULTRARICH);
        jigoku.getMarket().addCondition(Conditions.RUINS_VAST);
        jigoku.setCustomDescriptionId("touhou_planet_jigoku");

        //the star
        PlanetAPI higanHole = system.addPlanet("touhou_higan", main_star, touhouUtil.getStarSystemsString("star_name_higan"), StarTypes.BLACK_HOLE, 100, 50f, 12000f, 30f);
        system.addCorona(higanHole, 50f, -30f, 1f, 5f);
        higanHole.setCustomDescriptionId("touhou_higan");

        //attempt to make an event horizon
        SectorEntityToken higanEventHorizon = system.addTerrain(Terrain.EVENT_HORIZON, new EventHorizonPlugin.CoronaParams(80f, 25f, higanHole, -40f, 1f, 5f));
        higanEventHorizon.setCircularOrbit(higanHole, 0, 0, 365);

        PlanetAPI tenkai = system.addPlanet("touhou_planet_tenkai", higanHole, touhouUtil.getStarSystemsString("planet_name_tenkai"), "frozen", 110, 60, 100f, 10f);
        Misc.initConditionMarket(tenkai);
        tenkai.getMarket().addCondition(Conditions.VERY_COLD);
        tenkai.getMarket().addCondition(Conditions.DARK);
        tenkai.getMarket().addCondition(Conditions.TECTONIC_ACTIVITY);
        tenkai.getMarket().addCondition(Conditions.ORE_ABUNDANT);
        tenkai.getMarket().addCondition(Conditions.LOW_GRAVITY);
        tenkai.getMarket().addCondition(Conditions.RARE_ORE_ABUNDANT);
        tenkai.getMarket().addCondition(Conditions.ORGANICS_ABUNDANT);
        tenkai.getMarket().addCondition(Conditions.VOLATILES_ABUNDANT);
        tenkai.getMarket().addCondition(Conditions.RUINS_VAST);
        tenkai.setCustomDescriptionId("touhou_planet_tenkai");

        //stable locations
        SectorEntityToken touhou_relay = system.addCustomEntity("touhou_Gensokyo_relay", "Gensokyo Buoy", "nav_buoy_makeshift", "touhou_gensokyo");
        touhou_relay.setCircularOrbit(main_star, 90f, 6500f, 20f);

        SectorEntityToken touhou_buoy = system.addCustomEntity("touhou_Gensokyo_relay", "Gensokyo Array", "sensor_array_makeshift", "touhou_gensokyo");
        touhou_buoy.setCircularOrbit(main_star, 180f, 7000f, 15f);

        SectorEntityToken touhou_array = system.addCustomEntity("touhou_Gensokyo_relay", "TORIFUNE", "comm_relay", "touhou_gensokyo");
        touhou_array.setCircularOrbit(main_star, 270f, 7500f, 10f);

        //nebula
        SectorEntityToken touhou_Nebula = Misc.addNebulaFromPNG("data/campaign/terrain/hyperspace_map_filled.png", 0, 0, system, "terrain", "nebula_amber", 4, 4, StarAge.AVERAGE);



        // generates hyperspace destinations for in-system jump points
        system.autogenerateHyperspaceJumpPoints(true, true);
        //custom entities
/*
        // Debris
        DebrisFieldParams params = new DebrisFieldParams(
                150f, // field radius - should not go above 1000 for performance reasons
                1f, // density, visual - affects number of debris pieces
                10000000f, // duration in days
                0f); // days the field will keep generating glowing pieces
        params.source = DebrisFieldSource.MIXED;
        params.baseSalvageXP = 500; // base XP for scavenging in field
        SectorEntityToken debris = Misc.addDebrisField(system, params, StarSystemGenerator.random);
        SalvageSpecialAssigner.assignSpecialForDebrisField(debris);

        // makes the debris field always visible on map/sensors and not give any xp or notification on being discovered
        debris.setSensorProfile(null);
        debris.setDiscoverable(null);

        // makes it discoverable and give 200 xp on being found
        // sets the range at which it can be detected (as a sensor contact) to 2000 units
        // commented out.
        debris.setDiscoverable(true);
        debris.setDiscoveryXP(200f);
        debris.setSensorProfile(1f);
        debris.getDetectedRangeMod().modifyFlat("gen", 2000);

        debris.setCircularOrbit(pg_Star, 45 + 10, 1600, 250);*/
        //Finally cleans up hyperspace
        cleanup(system);

    }

    //Learning from Tart scripts
    //Clean nearby Nebula
    private void cleanup(StarSystemAPI system) {
        HyperspaceTerrainPlugin plugin = (HyperspaceTerrainPlugin) Misc.getHyperspaceTerrain().getPlugin();
        NebulaEditor editor = new NebulaEditor(plugin);
        float minRadius = plugin.getTileSize() * 2f;

        float radius = system.getMaxRadiusInHyperspace();
        editor.clearArc(system.getLocation().x, system.getLocation().y, 0, radius + minRadius * 0.5f, 0, 360f);
        editor.clearArc(system.getLocation().x, system.getLocation().y, 0, radius + minRadius, 0, 360f, 0.25f);
    }
}
