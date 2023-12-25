package net.danygames2014.imposterblocks.block;

import net.danygames2014.imposterblocks.tileentity.CamoBlockTileEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import net.modificationstation.stationapi.api.template.block.TemplateBlockWithEntity;
import net.modificationstation.stationapi.api.util.Identifier;

public class CamoBlock extends TemplateBlockWithEntity {

    public CamoBlock(Identifier identifier) {
        super(identifier, Material.WOOD);
        this.setHardness(0.2F);
        this.setResistance(2F);
    }

    @Override
    public int getTextureId(BlockView blockView, int x, int y, int z, int side) {
        CamoBlockTileEntity tileEntity = (CamoBlockTileEntity)blockView.method_1777(x,y,z);

        if(!tileEntity.cached){
            tileEntity.buildCache();
        }

        return tileEntity.textureIdCache[side];
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new CamoBlockTileEntity();
    }

    @Override
    public boolean isOpaque() { // Slight Performance Impact, fixes Glass, Leaves etc. causing x-ray glitch
        return false;
    }

//    @Override
//    public int getColorMultiplier(BlockView blockView, int x, int y, int z) { // Fixes Leaves Coloring
//        return BlockRegistry.INSTANCE.get(Namespace.MINECRAFT.id("leaves")).getColorMultiplier(blockView, x, y, z);
//    }
}
