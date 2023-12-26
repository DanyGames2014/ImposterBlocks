package net.danygames2014.imposterblocks.init;

import net.danygames2014.imposterblocks.tileentity.CamoBlockTileEntity;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.block.entity.BlockEntityRegisterEvent;

public class TileEntityListener {
    @EventListener
    public void registerTileEntities(BlockEntityRegisterEvent event) {
        event.register(CamoBlockTileEntity.class, "camo_block");
    }
}
