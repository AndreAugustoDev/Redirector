package com.teampotato.redirectionor.mixin.minecraft.client;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RenderShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {
    @Redirect(method = "handleKeybinds", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }

    @Redirect(method = "selfTest", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/RenderShape;MODEL:Lnet/minecraft/world/level/block/RenderShape;"))
    private RenderShape implModel() {
        return Redirectionor.MODEL;
    }
}
