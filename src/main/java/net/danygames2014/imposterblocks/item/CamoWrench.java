package net.danygames2014.imposterblocks.item;

import net.danygames2014.imposterblocks.ImposterBlocks;
import net.danygames2014.imposterblocks.block.CamoSlab;
import net.danygames2014.imposterblocks.init.BlockListener;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.state.property.EnumProperty;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class CamoWrench extends TemplateItem {
    public CamoWrench(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        if (world.getBlockState(x, y, z).isIn(ImposterBlocks.camoBlockTag)) {
            System.out.print("CAMO");

            if (world.getBlockId(x,y,z) == BlockListener.camoBlockId) {
                System.out.println(" BLOCK");

            } else if (world.getBlockId(x,y,z) == BlockListener.camoSlabId) {
                world.setBlockState(x,y,z,world.getBlockState(x,y,z).cycle(CamoSlab.SLAB_TYPE));
                System.out.println(" SLAB");

            } else{
                System.out.println(" UNKNOWN");
            }

            world.method_243(x,y,z);

            return true;
        }
        return false;
    }
}
