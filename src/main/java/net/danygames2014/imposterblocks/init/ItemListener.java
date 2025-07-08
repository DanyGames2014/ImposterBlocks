package net.danygames2014.imposterblocks.init;

import net.danygames2014.imposterblocks.item.CamoWrench;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;

@SuppressWarnings("unused")
public class ItemListener {
    @Entrypoint.Namespace
    public static Namespace NAMESPACE;

    public static Item wrench;

    @EventListener
    public void registerWrench(ItemRegistryEvent event) {
        wrench = new CamoWrench(NAMESPACE.id("wrench")).setTranslationKey(NAMESPACE, "wrench");
    }
}
