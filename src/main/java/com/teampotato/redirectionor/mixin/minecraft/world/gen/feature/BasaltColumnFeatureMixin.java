package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.BasaltColumnFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BasaltColumnFeature.class)
public abstract class BasaltColumnFeatureMixin {
    @Redirect(method = "findSurface", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown1() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "canPlaceAt", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown2() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "placeColumn", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private Direction implUp1() {
        return Redirectionor.UP;
    }

    @Redirect(method = "canPlaceAt", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private static Direction implUp2() {
        return Redirectionor.UP;
    }

    @Redirect(method = "findAir", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
    private static Direction implUp3() {
        return Redirectionor.UP;
    }
}