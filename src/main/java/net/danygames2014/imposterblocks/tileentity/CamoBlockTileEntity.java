package net.danygames2014.imposterblocks.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;

public class CamoBlockTileEntity extends BlockEntity {
    public Identifier blockTexture = Namespace.MINECRAFT.id("wool");
    public int blockTextureMeta = 0;
    public Block block = null;

    @Override
    public void writeNbt(NbtCompound nbtCompound) {
        nbtCompound.putString("blockIdentifier", blockTexture.toString());
        nbtCompound.putInt("blockMeta", blockTextureMeta);
        super.writeNbt(nbtCompound);
    }

    @Override
    public void readNbt(NbtCompound nbtCompound) {
        blockTexture = Identifier.of(nbtCompound.getString("blockIdentifier"));
        blockTextureMeta = nbtCompound.getInt("blockMeta");
        super.readNbt(nbtCompound);
    }
}
