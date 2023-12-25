package net.danygames2014.imposterblocks.mixin;

import net.danygames2014.imposterblocks.init.ItemListener;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public abstract class PlayerInventoryMixin {
    @Shadow public abstract ItemStack getSelectedItem();

    @Shadow public PlayerEntity player;

    @Inject(method = "method_692", at = @At("HEAD"), cancellable = true)
    public void wrenchScroll(int scrollDirection, CallbackInfo ci){
        if(this.getSelectedItem().itemId == ItemListener.wrenchItem.id){
            player.method_490(""+scrollDirection);
            ci.cancel();
        }
    }
}
