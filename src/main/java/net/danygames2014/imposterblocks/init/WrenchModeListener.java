package net.danygames2014.imposterblocks.init;

import net.danygames2014.imposterblocks.ImposterBlocks;
import net.danygames2014.uniwrench.api.WrenchMode;
import net.danygames2014.uniwrench.api.event.UniversalWrenchModeEvent;
import net.mine_diver.unsafeevents.listener.EventListener;

public class WrenchModeListener {
    public static final WrenchMode MODE_TEXTURE = new WrenchMode(ImposterBlocks.MOD_ID.id("texture"));
    public static final WrenchMode MODE_DEBUG = new WrenchMode(ImposterBlocks.MOD_ID.id("debug"));

    @EventListener
    public void registerWrenchMode(UniversalWrenchModeEvent event){
        event.wrench.addWrenchMode(MODE_TEXTURE);
    }
}
