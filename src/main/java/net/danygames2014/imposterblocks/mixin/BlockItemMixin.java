package net.danygames2014.imposterblocks.mixin;

import net.danygames2014.imposterblocks.ImposterBlocks;
import net.danygames2014.imposterblocks.block.CamoBlock;
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
    @SuppressWarnings("CancellableInjectionUsage")
    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    public void useOnCamoBlock(ItemStack itemStack, PlayerEntity player, World world, int x, int y, int z, int side, CallbackInfoReturnable<Boolean> cir) {
        if (world.getBlockState(x, y, z).getBlock() instanceof CamoBlock) {
            if (!(itemStack.isIn(ImposterBlocks.camoBlockItemTag)) && (((BlockItem) itemStack.getItem()).getBlock().isFullCube())) {
                CamoBlockTileEntity tileEntity = (CamoBlockTileEntity) world.getBlockEntity(x, y, z);

                // Player is not sneaking - set entire block
                if (!player.isSneaking()) {
                    tileEntity.setTextureBlock(BlockRegistry.INSTANCE.getId(((BlockItem) itemStack.getItem()).getBlock()), itemStack.getDamage());
                    // Player is sneaking - set single side
                } else {
                    tileEntity.setTextureSide(BlockRegistry.INSTANCE.getId(((BlockItem) itemStack.getItem()).getBlock()), itemStack.getDamage(), side);
                }

                tileEntity.buildCache();
                world.blockUpdateEvent(x, y, z);
                cir.cancel();
            }
        }
    }
}
