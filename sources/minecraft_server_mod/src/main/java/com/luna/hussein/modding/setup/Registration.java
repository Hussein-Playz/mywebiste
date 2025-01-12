package com.luna.hussein.modding.setup;

import com.brandon3055.draconicevolution.api.crafting.FusionRecipe;
import com.brandon3055.draconicevolution.api.crafting.IFusionRecipe;
import com.brandon3055.draconicevolution.init.DEModules;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.RegistryObject;
import com.luna.hussein.modding.HusseinPlayzYT;

public class Registration {
    public static RegistryObject<FusionRecipe.Serializer> FUSION_RECIPE_SERIALIZER;
    public static RegistryObject<RecipeType<IFusionRecipe>> FUSION_RECIPE_TYPE;
    public static Block CRAFTING_CORE;
    public static ResourceLocation INGREDIENT_STACK_TYPE = new ResourceLocation("hussein:ingredient_stack");

    public Registration() {
    }

    public static void addModuleProvider(String modid) {
        DEModules.MODULE_PROVIDING_MODS.add(modid);
    }
}
