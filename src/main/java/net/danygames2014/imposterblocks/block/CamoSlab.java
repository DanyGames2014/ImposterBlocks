package net.danygames2014.imposterblocks.block;

import net.minecraft.block.Block;
import net.minecraft.world.BlockView;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.EnumProperty;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.StringIdentifiable;

public class CamoSlab extends CamoBlock {

    public enum SlabType implements StringIdentifiable {
        TOP,
        BOTTOM;

        @Override
        public String asString() {
            return name().toLowerCase();
        }
    }

    public static final EnumProperty<SlabType> SLAB_TYPE = EnumProperty.of("slab_type", SlabType.class);

    public CamoSlab(Identifier identifier) {
        super(identifier);
        this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        this.setOpacity(255);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(SLAB_TYPE);
    }
}
