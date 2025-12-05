package me.eelien.eelienhorror.util;

import me.eelien.eelienhorror.EElienHorror;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        // Add block tags here in the future if needed

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(EElienHorror.MODID, name));
        }
    }

    public static class Items {


        public static final TagKey<Item> COOKED_MEAT = createTag("cooked_meat");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(EElienHorror.MODID, name));
        }
    }
}
