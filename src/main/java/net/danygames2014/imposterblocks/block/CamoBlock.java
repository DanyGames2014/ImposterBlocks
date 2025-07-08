package net.danygames2014.imposterblocks.block;

import net.danygames2014.imposterblocks.init.WrenchModeListener;
import net.danygames2014.imposterblocks.tileentity.CamoBlockTileEntity;
import net.danygames2014.uniwrench.api.WrenchMode;
import net.danygames2014.uniwrench.api.Wrenchable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
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
        CamoBlockTileEntity blockEntity = (CamoBlockTileEntity) blockView.getBlockEntity(x, y, z);

        if (!blockEntity.cached) {
            blockEntity.buildCache();
        }

        return blockEntity.textureIdCache[side];
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new CamoBlockTileEntity();
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean wrenchRightClick(ItemStack stack, PlayerEntity player, boolean isSneaking, World world, int x, int y, int z, int side, WrenchMode wrenchMode) {
        CamoBlockTileEntity blockEntity = (CamoBlockTileEntity) world.getBlockEntity(x, y, z);

        if (wrenchMode == WrenchModeListener.MODE_TEXTURE) {
            blockEntity.cycleTextureOnSide(side);
        } else if (wrenchMode == WrenchModeListener.MODE_DEBUG) {
            player.sendMessage("Side : " + side + " | Texture : " + blockEntity.textureIdentifier[side] + " | Meta : " + blockEntity.textureMeta[side] + " | Cache : " + blockEntity.textureIdCache[side]);
        }

        world.blockUpdateEvent(x, y, z); // Update The Block

        return true;
    }

//    @Override
//    public int getColorMultiplier(BlockView blockView, int x, int y, int z) { // Fixes Leaves Coloring
//        return BlockRegistry.INSTANCE.get(Namespace.MINECRAFT.id("leaves")).getColorMultiplier(blockView, x, y, z);
//    }
}
