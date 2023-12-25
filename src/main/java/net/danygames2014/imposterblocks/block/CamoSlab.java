package net.danygames2014.imposterblocks.block;

import net.modificationstation.stationapi.api.util.Identifier;

public class CamoSlab extends CamoBlock {

    public enum SlabType {
        TOP,
        BOTTOM,
        SIDE;
    }

    public CamoSlab(Identifier identifier, SlabType SlabType) {
        super(identifier);
        this.setOpacity(0);
        switch (SlabType){
            case TOP -> this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            case BOTTOM -> this.setBoundingBox(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            case SIDE -> this.setBoundingBox(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 1.0F);
        }
    }

    @Override
    public boolean isFullCube() {
        return false;
    }
}
