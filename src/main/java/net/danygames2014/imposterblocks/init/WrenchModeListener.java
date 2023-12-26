package net.danygames2014.imposterblocks.init;

import net.danygames2014.imposterblocks.ImposterBlocks;
import net.danygames2014.imposterblocks.item.Wrench;
import net.danygames2014.uniwrench.api.WrenchMode;
import net.danygames2014.uniwrench.api.event.UniversalWrenchModeEvent;
import net.mine_diver.unsafeevents.listener.EventListener;

public class WrenchModeListener {
    public static WrenchMode MODE_TEXTURE;
    public static WrenchMode MODE_DEBUG;

    @EventListener
    public void registerWrenchMode(UniversalWrenchModeEvent event) {
        MODE_TEXTURE = new WrenchMode(ImposterBlocks.MOD_ID.id("texture"));
        MODE_DEBUG = new WrenchMode(ImposterBlocks.MOD_ID.id("debug"));

        event.wrench.addWrenchMode(MODE_TEXTURE);
    }
}
