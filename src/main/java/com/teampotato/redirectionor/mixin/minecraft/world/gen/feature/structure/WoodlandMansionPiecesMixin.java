package com.teampotato.redirectionor.mixin.minecraft.world.gen.feature.structure;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.gen.feature.structure.WoodlandMansionPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

public abstract class WoodlandMansionPiecesMixin {
    @Mixin(targets = "net.minecraft.world.gen.feature.structure.WoodlandMansionPieces$Grid")
    public abstract static class GridMixin {
        @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }

        @Redirect(method = "recursiveCorridor", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }
    }

    @Mixin(WoodlandMansionPieces.MansionTemplate.class)
    public abstract static class MansionTemplateMixin {
        @Redirect(method = "<init>(Lnet/minecraft/world/gen/feature/template/TemplateManager;Ljava/lang/String;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/Rotation;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;NONE:Lnet/minecraft/util/Mirror;"))
        private static Mirror implMirrorNone() {
            return Redirectionor.MIRROR_NONE;
        }

        @Redirect(method = "handleDataMarker", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
        private Direction implNorth() {
            return Redirectionor.NORTH;
        }

        @Redirect(method = "handleDataMarker", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
        private Direction implSouth() {
            return Redirectionor.SOUTH;
        }

        @Redirect(method = "handleDataMarker", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }

        @Redirect(method = "handleDataMarker", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }
    }

    @Mixin(targets = "net.minecraft.world.gen.feature.structure.WoodlandMansionPieces$Placer")
    public abstract static class PlacerMixin {
        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;NORTH:Lnet/minecraft/util/Direction;"))
        private Direction implNorth() {
            return Redirectionor.NORTH;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;SOUTH:Lnet/minecraft/util/Direction;"))
        private Direction implSouth() {
            return Redirectionor.SOUTH;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;WEST:Lnet/minecraft/util/Direction;"))
        private Direction implWest() {
            return Redirectionor.WEST;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;EAST:Lnet/minecraft/util/Direction;"))
        private Direction implEast() {
            return Redirectionor.EAST;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction;UP:Lnet/minecraft/util/Direction;"))
        private Direction implUp() {
            return Redirectionor.UP;
        }

        @Redirect(method = "addRoom1x1", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;NONE:Lnet/minecraft/util/Rotation;"))
        private Rotation implNone() {
            return Redirectionor.NONE;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;CLOCKWISE_90:Lnet/minecraft/util/Rotation;"))
        private Rotation implClockWise90() {
            return Redirectionor.CLOCKWISE_90;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;CLOCKWISE_180:Lnet/minecraft/util/Rotation;"))
        private Rotation implClockWise180() {
            return Redirectionor.CLOCKWISE_180;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Rotation;COUNTERCLOCKWISE_90:Lnet/minecraft/util/Rotation;"))
        private Rotation implCounterClockWise90() {
            return Redirectionor.COUNTERCLOCKWISE_90;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;NONE:Lnet/minecraft/util/Mirror;"))
        private Mirror implMirrorNone() {
            return Redirectionor.MIRROR_NONE;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;FRONT_BACK:Lnet/minecraft/util/Mirror;"))
        private Mirror implFrontBack() {
            return Redirectionor.FRONT_BACK;
        }

        @Redirect(method = "*", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Mirror;LEFT_RIGHT:Lnet/minecraft/util/Mirror;"))
        private Mirror implLeftRight() {
            return Redirectionor.LEFT_RIGHT;
        }
    }
}
