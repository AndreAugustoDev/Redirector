package com.teampotato.redirectionor.mixin.minecraft.world.level.block.entity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.TheEndGatewayBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TheEndGatewayBlockEntity.class)
public abstract class MixinTheEndGatewayBlockEntity {
    @Redirect(method = "getParticleAmount", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] implValues() {
        return Redirectionor.DIRECTIONS;
    }
}
