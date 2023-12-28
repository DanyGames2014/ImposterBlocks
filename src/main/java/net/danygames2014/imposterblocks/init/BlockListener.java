package net.danygames2014.imposterblocks.init;

import net.danygames2014.imposterblocks.block.CamoBlock;
import net.danygames2014.imposterblocks.block.CamoSlab;
import net.danygames2014.imposterblocks.block.CamoStairs;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

@SuppressWarnings("unused")
public class BlockListener {

    @Entrypoint.Namespace
    Namespace MOD_ID = Null.get();

    public static Block camoBlock;
    public static Block camoSlab;
    public static Block camoStairs;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        camoBlock = new CamoBlock(MOD_ID.id("camo_block")).setTranslationKey(MOD_ID, "camo_block");
        camoSlab = new CamoSlab(MOD_ID.id("camo_slab")).setTranslationKey(MOD_ID, "camo_slab");
        camoStairs = new CamoStairs(MOD_ID.id("camo_stairs")).setTranslationKey(MOD_ID, "camo_stairs");
    }
}
