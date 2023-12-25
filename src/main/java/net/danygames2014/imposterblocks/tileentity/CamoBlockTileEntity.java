package net.danygames2014.imposterblocks.tileentity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.modificationstation.stationapi.api.registry.BlockRegistry;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;

public class CamoBlockTileEntity extends BlockEntity {
    public Identifier[] textureIdentifier = {
            Namespace.MINECRAFT.id("wool"),
            Namespace.MINECRAFT.id("wool"),
            Namespace.MINECRAFT.id("wool"),
            Namespace.MINECRAFT.id("wool"),
            Namespace.MINECRAFT.id("wool"),
            Namespace.MINECRAFT.id("wool")
    };
    public int[] textureMeta = {0, 0, 0, 0, 0, 0};
    public int[] textureSide = {0, 1, 2, 3, 4, 5};

    // Cache
    public boolean cached = false;
    public int[] textureIdCache = {0, 0, 0, 0, 0, 0};

    public void buildCache(){
        BlockRegistry registry = BlockRegistry.INSTANCE;
        for (int i = 0; i < 6; i++) {
            textureIdCache[i] = registry.get(textureIdentifier[i]).getTexture(textureSide[i], textureMeta[i]);
        }
        cached = true;
    }

    public void setTextureBlock(Identifier identifier, int meta){
        for (int i = 0; i < 6; i++) {
            textureIdentifier[i] = identifier;
            textureMeta[i] = meta;
            textureSide[i] = i;
        }
        buildCache();
    }

    public void setTextureSide(Identifier identifier, int meta, int side){
        textureIdentifier[side] = identifier;
        textureMeta[side] = meta;
        textureSide[side] = side;
        buildCache();
    }

    public void cycleTextureOnSide(int side){
        textureSide[side] = textureSide[side]+1;
        if(textureSide[side] > 5){
            textureSide[side] = 0;
        }
        buildCache();
    }

    @Override
    public void writeNbt(NbtCompound nbtCompound) {
        nbtCompound.putString("textureIdentifier0", textureIdentifier[0].toString());
        nbtCompound.putString("textureIdentifier1", textureIdentifier[1].toString());
        nbtCompound.putString("textureIdentifier2", textureIdentifier[2].toString());
        nbtCompound.putString("textureIdentifier3", textureIdentifier[3].toString());
        nbtCompound.putString("textureIdentifier4", textureIdentifier[4].toString());
        nbtCompound.putString("textureIdentifier5", textureIdentifier[5].toString());

        nbtCompound.putInt("textureMeta0", textureMeta[0]);
        nbtCompound.putInt("textureMeta1", textureMeta[1]);
        nbtCompound.putInt("textureMeta2", textureMeta[2]);
        nbtCompound.putInt("textureMeta3", textureMeta[3]);
        nbtCompound.putInt("textureMeta4", textureMeta[4]);
        nbtCompound.putInt("textureMeta5", textureMeta[5]);

        nbtCompound.putInt("textureSide0", textureSide[0]);
        nbtCompound.putInt("textureSide1", textureSide[1]);
        nbtCompound.putInt("textureSide2", textureSide[2]);
        nbtCompound.putInt("textureSide3", textureSide[3]);
        nbtCompound.putInt("textureSide4", textureSide[4]);
        nbtCompound.putInt("textureSide5", textureSide[5]);
        super.writeNbt(nbtCompound);
    }

    @Override
    public void readNbt(NbtCompound nbtCompound) {
        textureIdentifier[0] = Identifier.of(nbtCompound.getString("textureIdentifier0"));
        textureIdentifier[1] = Identifier.of(nbtCompound.getString("textureIdentifier1"));
        textureIdentifier[2] = Identifier.of(nbtCompound.getString("textureIdentifier2"));
        textureIdentifier[3] = Identifier.of(nbtCompound.getString("textureIdentifier3"));
        textureIdentifier[4] = Identifier.of(nbtCompound.getString("textureIdentifier4"));
        textureIdentifier[5] = Identifier.of(nbtCompound.getString("textureIdentifier5"));

        textureMeta[0] = nbtCompound.getInt("textureMeta0");
        textureMeta[1] = nbtCompound.getInt("textureMeta1");
        textureMeta[2] = nbtCompound.getInt("textureMeta2");
        textureMeta[3] = nbtCompound.getInt("textureMeta3");
        textureMeta[4] = nbtCompound.getInt("textureMeta4");
        textureMeta[5] = nbtCompound.getInt("textureMeta5");

        textureSide[0] = nbtCompound.getInt("textureSide0");
        textureSide[1] = nbtCompound.getInt("textureSide1");
        textureSide[2] = nbtCompound.getInt("textureSide2");
        textureSide[3] = nbtCompound.getInt("textureSide3");
        textureSide[4] = nbtCompound.getInt("textureSide4");
        textureSide[5] = nbtCompound.getInt("textureSide5");
        super.readNbt(nbtCompound);
    }
}
