package net.danygames2014.imposterblocks.init;

import net.danygames2014.imposterblocks.ImposterBlocks;
import net.danygames2014.imposterblocks.item.Wrench;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;

public class ItemListener {
    public static Item wrench;

    @EventListener
    public void registerWrench(ItemRegistryEvent event){
        wrench = new Wrench(ImposterBlocks.MOD_ID.id("wrench")).setTranslationKey(ImposterBlocks.MOD_ID,"wrench");
    }
}
