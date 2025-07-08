package net.danygames2014.imposterblocks.item;

import net.danygames2014.imposterblocks.init.WrenchModeListener;
import net.danygames2014.uniwrench.api.WrenchMode;
import net.danygames2014.uniwrench.item.WrenchBase;
import net.modificationstation.stationapi.api.util.Identifier;

public class CamoWrench extends WrenchBase {
    public CamoWrench(Identifier identifier) {
        super(identifier);
        this.addWrenchMode(WrenchMode.MODE_ROTATE);
        this.addWrenchMode(WrenchModeListener.MODE_TEXTURE);
        this.addWrenchMode(WrenchModeListener.MODE_DEBUG);
    }
}
