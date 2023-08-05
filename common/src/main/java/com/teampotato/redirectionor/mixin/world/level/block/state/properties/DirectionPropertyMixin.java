package com.teampotato.redirectionor.mixin.world.level.block.state.properties;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DirectionProperty.class)
public abstract class DirectionPropertyMixin {
    @Redirect(method = "create(Ljava/lang/String;Ljava/util/function/Predicate;)Lnet/minecraft/world/level/block/state/properties/DirectionProperty;", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirection() {
        return Redirectionor.DIRECTIONS;
    }
}
