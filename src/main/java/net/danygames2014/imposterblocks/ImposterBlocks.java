package net.danygames2014.imposterblocks;

import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.registry.ItemRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.util.Identifier;

public class ImposterBlocks {
    public static TagKey<Item> camoBlockItemTag = TagKey.of(ItemRegistry.INSTANCE.getKey(), Identifier.of("imposterblocks:camo_blocks"));
}
