
package com.luna.hussein.modding.datagen;

import appeng.core.definitions.AEItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import com.luna.hussein.modding.HusseinPlayzYT;
import com.luna.hussein.modding.setup.ModItems;
import codechicken.lib.datagen.recipe.FurnaceRecipeBuilder;
import codechicken.lib.datagen.recipe.RecipeProvider;
import codechicken.lib.datagen.recipe.ShapedRecipeBuilder;
import codechicken.lib.datagen.recipe.ShapelessRecipeBuilder;
import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.init.DEContent;
import com.brandon3055.draconicevolution.init.DEModules;
import com.brandon3055.draconicevolution.init.DETags;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.StrictNBTIngredient;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;
import java.util.function.Supplier;


import java.util.function.Consumer;

import static com.luna.hussein.modding.HusseinPlayzYT.MODID;


public class RecipeGenerator extends RecipeProvider {

    public RecipeGenerator(PackOutput pOutput) {
        super(pOutput, MODID);
    }

    @Override
    protected void registerRecipes() {
//        fusion_injecting();
        crafting_table();

        fusionRecipe(ModItems.NICE_FOOD)
                .catalyst(1, ModItems.TRUE_CARD)
                .energy(250000000)
                .techLevel(TechLevel.CHAOTIC)
                .ingredient(DEContent.CORE_AWAKENED)
                .ingredient(DEContent.CORE_AWAKENED)
                .ingredient(DEContent.CORE_DRACONIUM)
                .ingredient(DEContent.DRAGON_HEART)
                .ingredient(DEContent.CORE_CHAOTIC)
                .ingredient(DEContent.CORE_AWAKENED)
                .ingredient(DEContent.CORE_WYVERN)
                .ingredient(DEContent.CORE_DRACONIUM);
    }

    @Override
    public String getName() {
        return "Recipes";
    }


//    private void fusion_injecting() {
    // uncomment this to private void to add extra fusion recipes MAKE SURE TO UNCOMMENT fusion_injecting in the registerRecipes function the nice food item is there as a recipe for you :D btw this is my first mod if u see this and dont know me dont be mad at this shit lol
//    }
    private void crafting_table() {
        shapedRecipe(ModItems.INFINITY_CARD)
                .patternLine("ERE")
                .patternLine("RSR")
                .patternLine("NNN")
                .key('E', Items.ENDER_EYE)
                .key('R', AEItems.WIRELESS_BOOSTER.asItem())
                .key('N', Items.NETHERITE_INGOT)
                .key('S', Items.NETHER_STAR);
        shapedRecipe(ModItems.DIMENSION_CARD)
                .patternLine("RNR")
                .patternLine("NEN")
                .patternLine("RNR")
                .key('R', ModItems.INFINITY_CARD)
                .key('E', Items.ENDER_EYE)
                .key('N', Items.NETHER_STAR);
        shapedRecipe(ModItems.TRUE_CARD)
                .patternLine(" N ")
                .patternLine("RER")
                .patternLine(" R ")
                .key('R', AEItems.ITEM_CELL_64K)
                .key('E', ModItems.DIMENSION_CARD)
                .key('N', Items.DRAGON_EGG);
    }

    private void compress3x3(Supplier<? extends ItemLike> output, Supplier<? extends ItemLike> input) {
        shapedRecipe(output, "compress")
                .patternLine("###")
                .patternLine("###")
                .patternLine("###")
                .key('#', input);
    }

    private void compress3x3(Supplier<? extends ItemLike> output, TagKey<Item> input) {
        shapedRecipe(output, "compress")
                .patternLine("###")
                .patternLine("###")
                .patternLine("###")
                .key('#', input);
    }

    private void compress2x2(Supplier<? extends ItemLike> output, Supplier<? extends ItemLike> input) {
        shapedRecipe(output, "compress")
                .patternLine("###")
                .patternLine("###")
                .patternLine("###")
                .key('#', input);
    }

    private void deCompress(Supplier<? extends ItemLike> output, int count, Supplier<? extends ItemLike> from) {
        shapelessRecipe(output, count, "decompress")
                .addIngredient(from);
    }

    private void deCompress(Supplier<? extends ItemLike> output, int count, TagKey<Item> from) {
        shapelessRecipe(output, count, "decompress")
                .addIngredient(from);
    }

    private void deCompress(Supplier<? extends ItemLike> output, Supplier<? extends ItemLike> from) {
        deCompress(output, 9, from);
    }

    private void deCompress(Supplier<? extends ItemLike> output, TagKey<Item> from) {
        deCompress(output, 9, from);
    }

//    public String folder(String folder, IForgeRegistryEntry<?> key) {
//        return DraconicEvolution.MODID + ":" + folder + "/" + key.getRegistryName().getPath();
//    }
//
//    public String folder(String folder, String name) {
//        return DraconicEvolution.MODID + ":" + folder + "/" + name;
//    }
//
//    public InventoryChangeTrigger.TriggerInstance has(TagKey<Item> p_206407_) {
//        return inventoryTrigger(ItemPredicate.Builder.item().of(p_206407_).build());
//    }

    //    @Override
//    public void run(HashCache cache) {
//        super.run(cache);
//    }
//
    public static class NBTIngredient extends StrictNBTIngredient {
        public NBTIngredient(ItemStack stack) {
            super(stack);
        }
    }

    protected FusionRecipeBuilder fusionRecipe(Supplier<? extends ItemLike> result, ResourceLocation id) {
        return builder(FusionRecipeBuilder.builder(result.get(), 1, id));
    }

    protected FusionRecipeBuilder fusionRecipe(ItemLike result) {
        return builder(FusionRecipeBuilder.builder(result));
    }

    protected FusionRecipeBuilder fusionRecipe(ItemLike result, int count) {
        return builder(FusionRecipeBuilder.builder(new ItemStack(result, count)));
    }

    protected FusionRecipeBuilder fusionRecipe(Supplier<? extends ItemLike> result) {
        return builder(FusionRecipeBuilder.builder(result.get(), 1));
    }

    protected FusionRecipeBuilder fusionRecipe(Supplier<? extends ItemLike> result, String folder) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.get().asItem());
        return builder(FusionRecipeBuilder.builder(result.get(), 1, new ResourceLocation(id.getNamespace(), folder + "/" + id.getPath())));
    }

    protected FusionRecipeBuilder fusionRecipe(Supplier<? extends ItemLike> result, String folder, Function<String, String> customPath) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.get().asItem());
        return builder(FusionRecipeBuilder.builder(result.get(), 1, new ResourceLocation(id.getNamespace(), folder + "/" + customPath.apply(id.getPath()))));
    }

    protected FusionRecipeBuilder fusionRecipe(Supplier<? extends ItemLike> result, int count, String folder) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.get().asItem());
        return builder(FusionRecipeBuilder.builder(result.get(), count, new ResourceLocation(id.getNamespace(), folder + "/" + id.getPath())));
    }

    protected FusionRecipeBuilder fusionRecipe(Supplier<? extends ItemLike> result, int count) {
        return builder(FusionRecipeBuilder.builder(new ItemStack(result.get(), count)));
    }

    protected FusionRecipeBuilder fusionRecipe(ItemStack result) {
        return builder(FusionRecipeBuilder.builder(result, ForgeRegistries.ITEMS.getKey(result.getItem())));
    }

    protected FusionRecipeBuilder fusionRecipe(ItemStack result, ResourceLocation id) {
        return builder(FusionRecipeBuilder.builder(result, id));
    }

    protected FurnaceRecipeBuilder smelting(Supplier<? extends ItemLike> result, String folder) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.get().asItem());
        return builder(FurnaceRecipeBuilder.smelting(result.get(), 1, new ResourceLocation(id.getNamespace(), folder + "/" + id.getPath())));
    }

    protected FurnaceRecipeBuilder smelting(Supplier<? extends ItemLike> result, String folder, Function<String, String> customPath) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.get().asItem());
        return builder(FurnaceRecipeBuilder.smelting(result.get(), 1, new ResourceLocation(id.getNamespace(), folder + "/" + customPath.apply(id.getPath()))));
    }

    protected ShapedRecipeBuilder shapedRecipe(Supplier<? extends ItemLike> result, String folder) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.get().asItem());
        return builder(ShapedRecipeBuilder.builder(result.get(), 1, new ResourceLocation(id.getNamespace(), folder + "/" + id.getPath())));
    }

    protected ShapedRecipeBuilder shapedRecipe(ItemLike result, String folder) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.asItem());
        return builder(ShapedRecipeBuilder.builder(result, 1, new ResourceLocation(id.getNamespace(), folder + "/" + id.getPath())));
    }

    protected ShapedRecipeBuilder shapedRecipe(Supplier<? extends ItemLike> result, int count, String folder) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.get().asItem());
        return builder(ShapedRecipeBuilder.builder(result.get(), count, new ResourceLocation(id.getNamespace(), folder + "/" + id.getPath())));
    }

    protected ShapedRecipeBuilder shapedRecipe(Supplier<? extends ItemLike> result, int count, String folder, Function<String, String> customPath) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.get().asItem());
        return builder(ShapedRecipeBuilder.builder(result.get(), count, new ResourceLocation(id.getNamespace(), folder + "/" + customPath.apply(id.getPath()))));
    }

    protected ShapelessRecipeBuilder shapelessRecipe(Supplier<? extends ItemLike> result, String folder) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.get().asItem());
        return builder(ShapelessRecipeBuilder.builder(new ItemStack(result.get(), 1), new ResourceLocation(id.getNamespace(), folder + "/" + id.getPath())));
    }

    protected ShapelessRecipeBuilder shapelessRecipe(Supplier<? extends ItemLike> result, String folder, Function<String, String> customPath) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.get().asItem());
        return builder(ShapelessRecipeBuilder.builder(new ItemStack(result.get(), 1), new ResourceLocation(id.getNamespace(), folder + "/" + customPath.apply(id.getPath()))));
    }

    protected ShapelessRecipeBuilder shapelessRecipe(Supplier<? extends ItemLike> result, int count, String folder) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.get().asItem());
        return builder(ShapelessRecipeBuilder.builder(new ItemStack(result.get(), count), new ResourceLocation(id.getNamespace(), folder + "/" + id.getPath())));
    }

    protected ShapelessRecipeBuilder shapelessRecipe(ItemLike result, int count, ResourceLocation id) {
        return builder(ShapelessRecipeBuilder.builder(new ItemStack(result, count), id));
    }

    protected ShapelessRecipeBuilder shapelessRecipe(ItemLike result, int count, String folder, Function<String, String> customPath) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.asItem());
        return builder(ShapelessRecipeBuilder.builder(new ItemStack(result, count), new ResourceLocation(id.getNamespace(), folder + "/" + customPath.apply(id.getPath()))));
    }
}