package me.eelien.eelienhorror.item;

import me.eelien.eelienhorror.EElienHorror;
import me.eelien.eelienhorror.item.custom.MedkitItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem; // Import this for the RegistryObject<Item> type
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EElienHorror.MODID);

    public static final DeferredItem<MedkitItem> MEDKIT = ITEMS.register("medkit",
            () -> new MedkitItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}