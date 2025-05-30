package net.danygames2014.imposterblocks;

import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.ItemRegistry;
import net.modificationstation.stationapi.api.tag.TagKey;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Null;
import org.apache.logging.log4j.Logger;

public class ImposterBlocks {
    @Entrypoint.Logger
    public static Logger LOGGER;
    
    public static TagKey<Item> camoBlockItemTag = TagKey.of(ItemRegistry.INSTANCE.getKey(), Identifier.of("imposterblocks:camo_blocks"));
}
