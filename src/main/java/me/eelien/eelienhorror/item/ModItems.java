package me.eelien.eelienhorror.item;

import me.eelien.eelienhorror.EElienHorror;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EElienHorror.MODID);

    public static final DeferredItem<Item> MEDKIT = ITEMS.register("medkit",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
