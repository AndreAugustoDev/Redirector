package com.teampotato.redirectionor.mixin.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.AttachedStemBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AttachedStemBlock.class)
public abstract class AttachedStemBlockMixin {
    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
    private Direction implNorth() {
        return Redirectionor.NORTH;
    }
}
