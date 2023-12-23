package net.danygames2014.imposterblocks.mixin;

import net.danygames2014.imposterblocks.block.CamoBlock;
import net.danygames2014.imposterblocks.init.BlockListener;
import net.danygames2014.imposterblocks.tileentity.CamoBlockTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public class BlockItemMixin {

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    public void useOnCamoBlock(ItemStack itemStack, PlayerEntity player, World world, int x, int y, int z, int side, CallbackInfoReturnable<Boolean> cir){
        if (world.getBlockId(x, y, z) == BlockListener.camoBlockId) {
           if ((itemStack.getItem() != BlockListener.camoBlock.asItem()) && (((BlockItem)itemStack.getItem()).getBlock().isFullCube())) {
                CamoBlockTileEntity tileEntity = (CamoBlockTileEntity)world.method_1777(x,y,z);
                tileEntity.blockTexture = BlockRegistry.INSTANCE.getId(((BlockItem)itemStack.getItem()).getBlock());
                tileEntity.blockTextureMeta = itemStack.getDamage();
                tileEntity.block = null;

                world.method_243(x,y,z);
                cir.cancel();
           }
        }
    }
}
