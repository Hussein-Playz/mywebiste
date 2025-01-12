package com.luna.hussein.modding.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import com.brandon3055.draconicevolution.api.modules.lib.ModuleContext;
import java.util.Map;
import net.minecraft.network.chat.Component;
import com.brandon3055.draconicevolution.api.modules.data.AutoFeedData;
import com.brandon3055.draconicevolution.api.modules.lib.ModuleContext;
import com.brandon3055.draconicevolution.init.DEContent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;

public class NiceFood extends Item {
    public NiceFood() {
        super(new Item.Properties()
                .stacksTo(1) // Only one per stack
                .food(new FoodProperties.Builder()
                        .nutrition(10)
                        .saturationMod(2.4f)
                        .alwaysEat()
                        .build())
        );
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player player) {
            for (ItemStack itemStack : player.getInventory().items) {
                if (itemStack.hasTag() && itemStack.getTag().contains("food_storage")) {
                    CompoundTag tag = itemStack.getOrCreateTag();
                    double currentStorage = tag.getDouble("food_storage");
                    double nutritionValue = 10;
                    tag.putDouble("food_storage", currentStorage + nutritionValue);
                    return stack;
                }
            }
        }
        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public boolean canBeDepleted() {
        return false;
    }
}


