package net.danygames2014.imposterblocks.init;

import net.danygames2014.imposterblocks.block.CamoBlock;
import net.danygames2014.imposterblocks.block.CamoSlab;
import net.danygames2014.imposterblocks.block.CamoStairs;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;

@SuppressWarnings("unused")
public class BlockListener {

    @Entrypoint.Namespace
    public static Namespace NAMESPACE;

    public static Block camoBlock;
    public static Block camoSlab;
    public static Block camoStairs;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        camoBlock = new CamoBlock(NAMESPACE.id("camo_block")).setTranslationKey(NAMESPACE, "camo_block");
        camoSlab = new CamoSlab(NAMESPACE.id("camo_slab")).setTranslationKey(NAMESPACE, "camo_slab");
        camoStairs = new CamoStairs(NAMESPACE.id("camo_stairs")).setTranslationKey(NAMESPACE, "camo_stairs");
    }
}
