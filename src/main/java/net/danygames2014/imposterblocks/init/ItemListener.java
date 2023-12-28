package net.danygames2014.imposterblocks.init;

import net.danygames2014.imposterblocks.item.Wrench;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

@SuppressWarnings("unused")
public class ItemListener {
    @Entrypoint.Namespace
    public static final Namespace MOD_ID = Null.get();

    public static Item wrench;

    @EventListener
    public void registerWrench(ItemRegistryEvent event) {
        wrench = new Wrench(MOD_ID.id("wrench")).setTranslationKey(MOD_ID, "wrench");
    }
}
