package com.teampotato.redirectionor.mixin.minecraft.world.item.context;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.DirectionalPlaceContext;
import org.spongepowered.asm.mixin.*;

@Mixin(value = DirectionalPlaceContext.class, priority = 10)
public abstract class MixinDirectionalPlaceContext {
    @Shadow @Final private Direction direction;

    @Unique private static Direction[] DEFAULT_RETURN = new Direction[]{Redirectionor.DOWN, Redirectionor.NORTH, Redirectionor.EAST, Redirectionor.SOUTH, Redirectionor.WEST, Redirectionor.UP};
    @Unique private static Direction[] UP_RETURN = new Direction[]{   Redirectionor.DOWN, Redirectionor.UP,    Redirectionor.NORTH, Redirectionor.EAST, Redirectionor.SOUTH, Redirectionor.WEST};
    @Unique private static Direction[] NORTH_RETURN = new Direction[]{Redirectionor.DOWN, Redirectionor.NORTH, Redirectionor.EAST,  Redirectionor.WEST, Redirectionor.UP,    Redirectionor.SOUTH};
    @Unique private static Direction[] SOUTH_RETURN = new Direction[]{Redirectionor.DOWN, Redirectionor.SOUTH, Redirectionor.EAST,  Redirectionor.WEST, Redirectionor.UP,    Redirectionor.NORTH};
    @Unique private static Direction[] WEST_RETURN = new Direction[]{ Redirectionor.DOWN, Redirectionor.WEST,  Redirectionor.SOUTH, Redirectionor.UP,   Redirectionor.NORTH, Redirectionor.EAST};
    @Unique private static Direction[] EAST_RETURN = new Direction[]{ Redirectionor.DOWN, Redirectionor.EAST,  Redirectionor.SOUTH, Redirectionor.UP,   Redirectionor.NORTH, Redirectionor.WEST};

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Direction[] getNearestLookingDirections() {
         switch (this.direction) {
             default :
                 return DEFAULT_RETURN;

             case UP :
                 return UP_RETURN;

            case NORTH :
                return NORTH_RETURN;

            case SOUTH :
                return SOUTH_RETURN;

            case WEST:
                return WEST_RETURN;

            case EAST :
                return EAST_RETURN;

        }
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Direction getHorizontalDirection() {
        return this.direction.getAxis() == Redirectionor.Y ? Redirectionor.NORTH : this.direction;
    }

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public Direction getNearestLookingDirection() {
        return Redirectionor.DOWN;
    }
}
