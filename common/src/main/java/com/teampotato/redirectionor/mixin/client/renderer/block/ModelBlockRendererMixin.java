package com.teampotato.redirectionor.mixin.client.renderer.block;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ModelBlockRenderer.class)
public abstract class ModelBlockRendererMixin {
    @Redirect(method = {"tesselateWithoutAO", "tesselateWithAO", "calculateShape", "renderModel"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirectionValues() {
        return DirectionReferences.DIRECTIONS;
    }

    @Redirect(method = "calculateShape", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;get3DDataValue()I"))
    private int redirectDirectionGet3DDataValue(Direction instance) {
        return DirectionReferences.DataValueReferences.DATA_VALUE_MAP.get(instance);
    }
}