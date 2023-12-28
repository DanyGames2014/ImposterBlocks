package net.danygames2014.imposterblocks.block;

import net.danygames2014.uniwrench.api.WrenchMode;
import net.danygames2014.uniwrench.api.Wrenchable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.client.render.block.StationRendererBlockRenderManager;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.impl.entity.player.PlayerAPI;

import java.util.ArrayList;

public class CamoStairs extends CamoBlock implements Wrenchable {
    public CamoStairs(Identifier identifier) {
        super(identifier);
    }

    @Override
    public void wrenchRightClick(ItemStack stack, PlayerEntity player, boolean isSneaking, World world, int x, int y, int z, int side, WrenchMode wrenchMode) {
        int meta = world.getBlockMeta(x,y,z)+1;
        world.method_223(x, y, z, meta > 3 ? 0 : meta);
        world.method_243(x, y, z);
    }

    //IDK
    @Environment(value= EnvType.CLIENT)
    public int getRenderType() {
        return 10;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public void updateBoundingBox(BlockView blockView, int x, int y, int z) {
        this.setBoundingBox(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void addIntersectingBoundingBox(World world, int x, int y, int z, Box box, ArrayList boxes) {
        int n = world.getBlockMeta(x, y, z);

        if (n == 0) {
            this.setBoundingBox(0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 1.0f);
            super.addIntersectingBoundingBox(world, x, y, z, box, boxes);
            this.setBoundingBox(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            super.addIntersectingBoundingBox(world, x, y, z, box, boxes);
        } else if (n == 1) {
            this.setBoundingBox(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
            super.addIntersectingBoundingBox(world, x, y, z, box, boxes);
            this.setBoundingBox(0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
            super.addIntersectingBoundingBox(world, x, y, z, box, boxes);
        } else if (n == 2) {
            this.setBoundingBox(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f);
            super.addIntersectingBoundingBox(world, x, y, z, box, boxes);
            this.setBoundingBox(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
            super.addIntersectingBoundingBox(world, x, y, z, box, boxes);
        } else if (n == 3) {
            this.setBoundingBox(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
            super.addIntersectingBoundingBox(world, x, y, z, box, boxes);
            this.setBoundingBox(0.0f, 0.0f, 0.5f, 1.0f, 0.5f, 1.0f);
            super.addIntersectingBoundingBox(world, x, y, z, box, boxes);
        }

        this.setBoundingBox(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void onPlaced(World world, int x, int y, int z, int side) {
        System.out.println(side);
    }

    @Override
    public void onPlaced(World world, int x, int y, int z, LivingEntity placer) {
        switch (MathHelper.floor((double)(placer.yaw * 4.0f / 360.0f) + 0.5) & 3){
            case 0 -> world.method_223(x,y,z,2);
            case 1 -> world.method_223(x,y,z,1);
            case 2 -> world.method_223(x,y,z,3);
            case 3 -> world.method_223(x,y,z,0);
        }

        world.method_243(x, y, z);
    }
}
