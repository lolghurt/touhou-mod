package data.scripts;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import data.scripts.world.touhou_WorldGen;
import exerelin.campaign.SectorManager;

import static com.fs.starfarer.api.Global.getSettings;

public class touhou_ModPlugin extends BaseModPlugin {/*
    @Override
    public void onApplicationLoad() throws Exception {
        boolean hasPart2 = getSettings().getModManager().isModEnabled("aBadIdea2");
        boolean hasPart3 = getSettings().getModManager().isModEnabled("aBadIdea3");
        if (!hasPart2) {
            throw new RuntimeException("The MEME FACTION requires MEME SHIPS (part 2)");
        }
        if (!hasPart3) {
            throw new RuntimeException("The MEME FACTION requires MEME SHIPS (part 3)");
        }
    }*/

    @Override
    public void onNewGame() {
        //Nex compatibility setting, if there is no nex or corvus mode(Nex), just generate the system
        boolean haveNexerelin = Global.getSettings().getModManager().isModEnabled("nexerelin");
        if (!haveNexerelin || SectorManager.getCorvusMode()) {
            new touhou_WorldGen().generate(Global.getSector());
        }
    }
}
