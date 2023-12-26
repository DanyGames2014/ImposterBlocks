package net.danygames2014.imposterblocks.block;

import net.danygames2014.imposterblocks.init.WrenchModeListener;
import net.danygames2014.imposterblocks.tileentity.CamoBlockTileEntity;
import net.danygames2014.uniwrench.api.WrenchMode;
import net.danygames2014.uniwrench.api.Wrenchable;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlockWithEntity;
import net.modificationstation.stationapi.api.util.Identifier;

public class CamoBlock extends TemplateBlockWithEntity implements Wrenchable {

    public CamoBlock(Identifier identifier) {
        super(identifier, Material.WOOD);
        this.setHardness(0.2F);
        this.setResistance(2F);
    }

    @Override
    public int getTextureId(BlockView blockView, int x, int y, int z, int side) {
        CamoBlockTileEntity tileEntity = (CamoBlockTileEntity) blockView.method_1777(x, y, z);

        if (!tileEntity.cached) {
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

    @Override
    public void wrenchRightClick(ItemStack stack, PlayerEntity player, boolean isSneaking, World world, int x, int y, int z, int side, WrenchMode wrenchMode) {
        CamoBlockTileEntity tileEntity = (CamoBlockTileEntity) world.method_1777(x, y, z);

        if (wrenchMode == WrenchModeListener.MODE_TEXTURE) {
            tileEntity.cycleTextureOnSide(side);
        } else if (wrenchMode == WrenchModeListener.MODE_DEBUG) {
            player.method_490("Side : " + side + " | Texture : " + tileEntity.textureIdentifier[side] + " | Meta : " + tileEntity.textureMeta[side] + " | Cache : " + tileEntity.textureIdCache[side]);
        }

        world.method_243(x, y, z); // Update The Block
    }

    //    @Override
//    public int getColorMultiplier(BlockView blockView, int x, int y, int z) { // Fixes Leaves Coloring
//        return BlockRegistry.INSTANCE.get(Namespace.MINECRAFT.id("leaves")).getColorMultiplier(blockView, x, y, z);
//    }
}
