package com.luna.hussein.modding.mixins;

import appeng.menu.slot.RestrictedInputSlot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import com.luna.hussein.modding.setup.ModItems;

@Mixin(value = RestrictedInputSlot.class)
public class MixinRestrictedInputSlot {

    @Inject(method = "mayPlace", at = @At("HEAD"), cancellable = true)
    private void mayPlace(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.is(ModItems.INFINITY_CARD.get()) || stack.is(ModItems.DIMENSION_CARD.get()) || stack.is(ModItems.TRUE_CARD.get())) {
            cir.setReturnValue(true);
        }
    }

}
