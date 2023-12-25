package net.danygames2014.imposterblocks.init;

import net.danygames2014.imposterblocks.block.CamoBlock;
import net.danygames2014.imposterblocks.block.CamoSlab;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class BlockListener {

    @Entrypoint.Namespace
    Namespace MOD_ID = Null.get();

    public static Block camoBlock;
    public static Block camoSlabTop;
    public static Block camoSlabBottom;
    public static Block camoSlabSide;

    @EventListener
    public void registerBlocks(BlockRegistryEvent event){
        camoBlock = new CamoBlock(MOD_ID.id("camo_block")).setTranslationKey(MOD_ID,"camo_block");
        camoSlabTop = new CamoSlab(MOD_ID.id("camo_slab_top"), CamoSlab.SlabType.TOP).setTranslationKey(MOD_ID,"camo_slab_top");
        camoSlabBottom = new CamoSlab(MOD_ID.id("camo_slab_bottom"), CamoSlab.SlabType.BOTTOM).setTranslationKey(MOD_ID,"camo_slab_bottom");
        camoSlabSide = new CamoSlab(MOD_ID.id("camo_slab_side"), CamoSlab.SlabType.SIDE).setTranslationKey(MOD_ID,"camo_slab_side");
    }
}
