package com.luna.hussein.modding.setup;

import com.luna.hussein.modding.HusseinPlayzYT;
import com.luna.hussein.modding.item.NiceFood;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import com.luna.hussein.modding.item.DimensionCard;
import com.luna.hussein.modding.item.InfinityCard;
import com.luna.hussein.modding.item.TrueCard;
import com.brandon3055.draconicevolution.api.DraconicAPI;
import com.brandon3055.draconicevolution.api.crafting.IngredientStack;
import com.brandon3055.draconicevolution.client.ClientProxy;
import com.brandon3055.draconicevolution.client.DEParticles;
import com.brandon3055.draconicevolution.command.DECommands;
import com.brandon3055.draconicevolution.handlers.DEEventHandler;
import com.brandon3055.draconicevolution.handlers.DESounds;
import com.brandon3055.draconicevolution.handlers.LootEventHandler;
import com.brandon3055.draconicevolution.handlers.ModularArmorEventHandler;
import com.brandon3055.draconicevolution.handlers.ModuleEventHandler;
import com.brandon3055.draconicevolution.init.ClientInit;
import com.brandon3055.draconicevolution.init.DEContent;
import com.brandon3055.draconicevolution.init.DECreativeTabs;
import com.brandon3055.draconicevolution.init.DEModules;
import com.brandon3055.draconicevolution.init.DETags;
import com.brandon3055.draconicevolution.init.ModCapabilities;
import com.brandon3055.draconicevolution.integration.computers.ComputerCraftCompatEventHandler;
import com.brandon3055.draconicevolution.integration.equipment.EquipmentManager;
import com.brandon3055.draconicevolution.items.tools.Dislocator;
import com.brandon3055.draconicevolution.network.DraconicNetwork;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.brandonscore.blocks.BlockBCore;
import com.brandon3055.brandonscore.blocks.ItemBlockBCore;
import com.brandon3055.brandonscore.worldentity.WorldEntityHandler;
import com.brandon3055.brandonscore.worldentity.WorldEntityType;
import com.brandon3055.draconicevolution.api.crafting.FusionRecipe;
import com.brandon3055.draconicevolution.blocks.*;
import com.brandon3055.draconicevolution.blocks.energynet.EnergyCrystal;
import com.brandon3055.draconicevolution.blocks.energynet.tileentity.TileCrystalDirectIO;
import com.brandon3055.draconicevolution.blocks.energynet.tileentity.TileCrystalRelay;
import com.brandon3055.draconicevolution.blocks.energynet.tileentity.TileCrystalWirelessIO;
import com.brandon3055.draconicevolution.blocks.machines.*;
import com.brandon3055.draconicevolution.blocks.reactor.ReactorComponent;
import com.brandon3055.draconicevolution.blocks.reactor.ReactorCore;
import com.brandon3055.draconicevolution.blocks.reactor.tileentity.TileReactorCore;
import com.brandon3055.draconicevolution.blocks.reactor.tileentity.TileReactorInjector;
import com.brandon3055.draconicevolution.blocks.reactor.tileentity.TileReactorStabilizer;
import com.brandon3055.draconicevolution.blocks.tileentity.*;
import com.brandon3055.draconicevolution.blocks.tileentity.chest.TileDraconiumChest;
import com.brandon3055.draconicevolution.blocks.tileentity.flowgate.TileFluidGate;
import com.brandon3055.draconicevolution.blocks.tileentity.flowgate.TileFluxGate;
import com.brandon3055.draconicevolution.entity.GuardianCrystalEntity;
import com.brandon3055.draconicevolution.entity.guardian.DraconicGuardianEntity;
import com.brandon3055.draconicevolution.entity.guardian.GuardianFightManager;
import com.brandon3055.draconicevolution.entity.guardian.GuardianProjectileEntity;
import com.brandon3055.draconicevolution.entity.guardian.GuardianWither;
import com.brandon3055.draconicevolution.entity.projectile.DraconicArrowEntity;
import com.brandon3055.draconicevolution.inventory.*;
import com.brandon3055.draconicevolution.items.InfoTablet;
import com.brandon3055.draconicevolution.items.ItemCore;
import com.brandon3055.draconicevolution.items.MobSoul;
import com.brandon3055.draconicevolution.items.equipment.*;
import com.brandon3055.draconicevolution.items.tools.*;
import com.brandon3055.draconicevolution.magic.EnchantmentReaper;
import com.brandon3055.draconicevolution.world.ChaosIslandFeature;
import com.brandon3055.draconicevolution.world.EnderCometFeature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import static com.luna.hussein.modding.HusseinPlayzYT.MODID;

public class ModItems {

//    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

//    public static final DeferredRegister<BlockEntityType<?>> TILES_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);
//    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);
//
//    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
//    public static final DeferredRegister<WorldEntityType<?>> WORLD_ENTITY_TYPES = DeferredRegister.create(WorldEntityHandler.ENTITY_TYPE, MODID);

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIAL = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MODID);
//    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);

//    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MODID);
//    public static final RegistryObject<Item> INFINITY_CARD = Registration.ITEMS.register("infinity_card", InfinityCard::new);
//    public static final RegistryObject<Item> DIMENSION_CARD = Registration.ITEMS.register("dimension_card", DimensionCard::new);
//    public static final RegistryObject<Item> TRUE_CARD = Registration.ITEMS.register("true_card", TrueCard::new);
//    public static final RegistryObject<Item> NICE_FOOD = Registration.ITEMS.register("nice_food", NiceFood::new);
    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
//        BLOCKS.register(eventBus);
//        TILES_ENTITIES.register(eventBus);
//        MENU_TYPES.register(eventBus);
//        ENTITY_TYPES.register(eventBus);
//        WORLD_ENTITY_TYPES.register(eventBus);
//        RECIPE_SERIAL.register(eventBus);
//        ENCHANTMENTS.register(eventBus);
//        FEATURES.register(eventBus);
        ITEMS.register(eventBus);
        RECIPE_TYPES.register(eventBus);
    }
//    static void register() {
//
//    }

    //#################################################################
    // Items
    //#################################################################

    //@formatter:off
    //Components
//    public static RegistryObject<Item> INFINITY_CARD = ITEMS.register("infinity_card",() -> new Item(new Item.Properties()));
//    public static  RegistryObject<Item> DIMENSION_CARD = ITEMS.register("dimension_card",() -> new Item(new Item.Properties()));
//    public static  RegistryObject<Item> TRUE_CARD = ITEMS.register("true_card",() -> new Item(new Item.Properties()));
//    public static  RegistryObject<Item> NICE_FOOD = ITEMS.register("nice_food",() -> new Item(new Item.Properties()));
    static {
        INFINITY_CARD = ITEMS.register("infinity_card", InfinityCard::new);
        DIMENSION_CARD = ITEMS.register("dimension_card", DimensionCard::new);
        TRUE_CARD = ITEMS.register("true_card",TrueCard::new);
        NICE_FOOD = ITEMS.register("nice_food", NiceFood::new);
    }
    public static RegistryObject<Item> INFINITY_CARD;
    public static RegistryObject<Item> DIMENSION_CARD;
    public static RegistryObject<Item> TRUE_CARD;
    public static RegistryObject<Item> NICE_FOOD;

    //#################################################################
    // Recipe Types
    //#################################################################

    static {
        Registration.FUSION_RECIPE_SERIALIZER = RECIPE_SERIAL.register("fusion_crafting", FusionRecipe.Serializer::new);
        Registration.FUSION_RECIPE_TYPE = RECIPE_TYPES.register("fusion_crafting", () -> RecipeType.simple(new ResourceLocation(MODID, "fusion_crafting")));
    }
}
