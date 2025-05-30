package net.danygames2014.imposterblocks.init;

import net.danygames2014.uniwrench.api.WrenchMode;
import net.danygames2014.uniwrench.api.event.UniversalWrenchModeEvent;
import net.danygames2014.uniwrench.api.event.WrenchModeRegistryEvent;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;

@SuppressWarnings("unused")
public class WrenchModeListener {
    @Entrypoint.Namespace
    public static Namespace NAMESPACE;

    public static WrenchMode MODE_TEXTURE;
    public static WrenchMode MODE_DEBUG;

    @EventListener
    public void registerWrenchMode(WrenchModeRegistryEvent event) {
        MODE_TEXTURE = new WrenchMode(NAMESPACE.id("texture"));
        MODE_DEBUG = new WrenchMode(NAMESPACE.id("debug"));
    }

    @EventListener
    public void addUniversalWrenchMode(UniversalWrenchModeEvent event){
        event.wrench.addWrenchMode(MODE_TEXTURE);
    }
}
