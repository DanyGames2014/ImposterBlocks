package net.danygames2014.imposterblocks.block;

import net.danygames2014.imposterblocks.init.BlockListener;
import net.danygames2014.imposterblocks.tileentity.CamoBlockTileEntity;
import net.danygames2014.uniwrench.api.WrenchMode;
import net.danygames2014.uniwrench.api.Wrenchable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class CamoSlab extends CamoBlock implements Wrenchable {

    public enum SlabType {
        TOP,
        BOTTOM,
        SIDE_1,
        SIDE_2,
        SIDE_3,
        SIDE_4
    }

    private SlabType type;

    public CamoSlab(Identifier identifier, SlabType SlabType) {
        super(identifier);
        this.setOpacity(0);
        this.type = SlabType;
        switch (SlabType) {
            case TOP -> this.setBoundingBox(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            case BOTTOM -> this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            case SIDE_1 -> this.setBoundingBox(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
            case SIDE_2 -> this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
            case SIDE_3 -> this.setBoundingBox(0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            case SIDE_4 -> this.setBoundingBox(0.0F, 0.0F, 0.5F, 1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    public void onSteppedOn(World world, int x, int y, int z, Entity entity) {
        if (entity instanceof PlayerEntity) {
            CamoBlockTileEntity tileEntity = (CamoBlockTileEntity) world.method_1777(x, y, z);
            int chompiness = 0;

            for (int i = 0; i < 6; i++) {
                if (tileEntity.textureIdentifier[i].path.equals("carved_pumpkin") && tileEntity.textureSide[i] == 3) {
                    chompiness += 1;
                }
            }

            if (chompiness > 0) {
                entity.damage(null, chompiness * 2);
                ((PlayerEntity) entity).method_490("CHOMP!");
            }
        }
    }

    @Override
    public void wrenchRightClick(ItemStack stack, PlayerEntity player, boolean isSneaking, World world, int x, int y, int z, int side, WrenchMode wrenchMode) {
        super.wrenchRightClick(stack, player, isSneaking, world, x, y, z, side, wrenchMode);

        CamoBlockTileEntity tileEntity = (CamoBlockTileEntity) world.method_1777(x, y, z);

        if (wrenchMode == WrenchMode.MODE_ROTATE) {
            switch (type) {
                case BOTTOM -> world.setBlock(x, y, z, BlockListener.camoSlabTop.id);
                case TOP -> world.setBlock(x, y, z, BlockListener.camoSlabSide1.id);
                case SIDE_1 -> world.setBlock(x, y, z, BlockListener.camoSlabSide2.id);
                case SIDE_2 -> world.setBlock(x, y, z, BlockListener.camoSlabSide3.id);
                case SIDE_3 -> world.setBlock(x, y, z, BlockListener.camoSlabSide4.id);
                case SIDE_4 -> world.setBlock(x, y, z, BlockListener.camoSlabBottom.id);
            }
        }

        tileEntity.method_1073();
        world.method_157(x, y, z, tileEntity);

        world.method_243(x, y, z); // Update The Block
    }

    @Override
    public boolean isFullCube() {
        return false;
    }
}
