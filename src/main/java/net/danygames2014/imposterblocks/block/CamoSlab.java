package net.danygames2014.imposterblocks.block;

import net.minecraft.block.Block;
import net.minecraft.world.BlockView;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.EnumProperty;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.StringIdentifiable;

import java.util.ArrayList;
import java.util.LinkedList;

public class CamoSlab extends CamoBlock {

    public enum SlabType {
        TOP,
        BOTTOM,
        SIDE;
    }

    public CamoSlab(Identifier identifier, SlabType SlabType) {
        super(identifier);
        this.setOpacity(255);
        switch (SlabType){
            case TOP -> this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            case BOTTOM -> this.setBoundingBox(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            case SIDE -> this.setBoundingBox(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
        }
    }
}
