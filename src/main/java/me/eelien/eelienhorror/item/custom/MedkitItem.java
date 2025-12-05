package me.eelien.eelienhorror.item.custom;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.world.food.FoodData;

public class MedkitItem extends Item {

    private static final float TARGET_PERCENTAGE = 0.85f; // 85%
    private static final int MAX_FOOD_LEVEL = 20;

    public MedkitItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!level.isClientSide) {

            boolean itemConsumed = false;

            float maxHealth = player.getMaxHealth();
            int targetHealth = (int) (maxHealth * TARGET_PERCENTAGE);
            float currentHealth = player.getHealth();
            float healAmount = targetHealth - currentHealth;

            if (healAmount > 0) {
                player.heal(healAmount);
                itemConsumed = true;
            }

            FoodData foodData = player.getFoodData();

            int targetFoodLevel = (int) (MAX_FOOD_LEVEL * TARGET_PERCENTAGE);
            float targetSaturation = MAX_FOOD_LEVEL * TARGET_PERCENTAGE;

            int currentFoodLevel = foodData.getFoodLevel();
            float currentSaturation = foodData.getSaturationLevel();

            if (currentFoodLevel < targetFoodLevel) {
                foodData.setFoodLevel(targetFoodLevel);
                itemConsumed = true;
            }

            if (currentSaturation < targetSaturation) {
                foodData.setSaturation(targetSaturation);
                itemConsumed = true;
            }

            if (itemConsumed) {
                if (player.getAbilities().instabuild) {
                    return InteractionResultHolder.success(itemstack);
                } else {
                    itemstack.shrink(1);
                }
            } else {
                return InteractionResultHolder.fail(itemstack);
            }
        }

        return InteractionResultHolder.consume(itemstack);
    }
}