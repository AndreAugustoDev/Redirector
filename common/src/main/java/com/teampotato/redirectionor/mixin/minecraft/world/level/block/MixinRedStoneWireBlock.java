package com.teampotato.redirectionor.mixin.minecraft.world.level.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = RedStoneWireBlock.class, priority = 10)
public abstract class MixinRedStoneWireBlock {
    @Shadow protected abstract void updatePowerStrength(Level p_55531_, BlockPos p_55532_, BlockState p_55533_);

    @Shadow protected abstract void updateNeighborsOfNeighboringWires(Level p_55638_, BlockPos p_55639_);

    @Redirect(method = {"updateIndirectNeighbourShapes", "canSurviveOn", "getSignal"}, at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp1() {
        return Redirectionor.UP;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (!pOldState.is(pState.getBlock()) && !pLevel.isClientSide) {
            this.updatePowerStrength(pLevel, pPos, pState);

            for(Direction direction : Redirectionor.VERTICAL) {
                pLevel.updateNeighborsAt(pPos.relative(direction), (RedStoneWireBlock)(Object)this);
            }

            this.updateNeighborsOfNeighboringWires(pLevel, pPos);
        }
    }
}