package net.danygames2014.imposterblocks.item;

import net.danygames2014.imposterblocks.ImposterBlocks;
import net.danygames2014.imposterblocks.block.CamoSlab;
import net.danygames2014.imposterblocks.init.BlockListener;
import net.danygames2014.imposterblocks.tileentity.CamoBlockTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class CamoWrench extends TemplateItem {
    public CamoWrench(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity player, World world, int x, int y, int z, int side) {
        if (world.getBlockState(x, y, z).isIn(ImposterBlocks.camoBlockTag)) {
            System.out.print("CAMO");
            CamoBlockTileEntity tileEntity = (CamoBlockTileEntity) world.method_1777(x,y,z);

            // Player Not Sneaking - Rotation Mode
            if (!player.method_1373()){
                if (world.getBlockId(x,y,z) == BlockListener.camoBlock.id) {
                    System.out.println(" BLOCK");

                } else if (world.getBlockState(x,y,z).getBlock() instanceof CamoSlab) {
                    int id = world.getBlockId(x,y,z);

                    if (id == BlockListener.camoSlabTop.id) {
                        System.out.println(" SLAB TOP");
                        world.setBlock(x,y,z,BlockListener.camoSlabBottom.id);

                    } else if (id == BlockListener.camoSlabBottom.id) {
                        System.out.println(" SLAB BOTTOM");
                        world.setBlock(x,y,z,BlockListener.camoSlabSide.id);

                    } else if (id == BlockListener.camoSlabSide.id) {
                        System.out.println(" SLAB SIDE");
                        world.setBlock(x,y,z,BlockListener.camoSlabTop.id);
                    }

                    tileEntity.method_1073();
                    world.method_157(x,y,z,tileEntity);

                }  else{
                    System.out.println(" UNKNOWN");
                }

            // Player Sneaking - Texture Mode
            } else {
                player.method_490("Side : " + side + " | Texture : " + tileEntity.textureIdentifier[side] + " | Meta : " + tileEntity.textureMeta[side] + " | Cache : " + tileEntity.textureIdCache[side]);
                tileEntity.cycleTextureOnSide(side);
            }

            world.method_243(x,y,z); // Update The Block

            return true;
        }

        return false;
    }
}
