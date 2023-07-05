package com.teampotato.redirectionor.mixin.minecraft.client.renderer.tileentity;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.tileentity.ChestTileEntityRenderer;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChestTileEntityRenderer.class)
public abstract class ChestTileEntityRendererMixin {

    @Redirect(method = "render(Lnet/minecraft/tileentity/TileEntity;FLcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/client/renderer/IRenderTypeBuffer;II)V", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"), remap = false)
    private Direction implSouth() {
        return Redirectionor.SOUTH;
    }
}
