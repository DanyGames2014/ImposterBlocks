package net.danygames2014.imposterblocks.init;

import net.danygames2014.imposterblocks.ImposterBlocks;
import net.danygames2014.imposterblocks.item.Wrench;
import net.danygames2014.uniwrench.api.WrenchMode;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;

public class ItemListener {
    public static Item wrench;

    @EventListener
    public void registerWrench(ItemRegistryEvent event) {
        wrench = new Wrench(ImposterBlocks.MOD_ID.id("wrench")).setTranslationKey(ImposterBlocks.MOD_ID, "wrench");

        Wrench cast_wrench = (Wrench) wrench;
        cast_wrench.addWrenchMode(WrenchMode.MODE_ROTATE);
        cast_wrench.addWrenchMode(WrenchModeListener.MODE_TEXTURE);
        cast_wrench.addWrenchMode(WrenchModeListener.MODE_DEBUG);
    }
}
