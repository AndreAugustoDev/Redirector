package com.teampotato.redirector.mixin.net.minecraft.world.level.levelgen.feature;

import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.Feature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Feature.class)
public abstract class FeatureMixin {
    @Redirect(method = "checkNeighbors", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirections() {
        return CommonValues.DIRECTIONS;
    }
}
