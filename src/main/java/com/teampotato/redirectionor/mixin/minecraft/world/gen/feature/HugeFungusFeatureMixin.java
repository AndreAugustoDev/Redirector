package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.world.gen.feature.HugeFungusFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HugeFungusFeature.class)
public abstract class HugeFungusFeatureMixin {
    @Redirect(method = "tryPlaceWeepingVines", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;DOWN:Lnet/minecraft/util/Direction;"))
    private static Direction implDown() {
        return Redirectionor.DOWN;
    }
}
