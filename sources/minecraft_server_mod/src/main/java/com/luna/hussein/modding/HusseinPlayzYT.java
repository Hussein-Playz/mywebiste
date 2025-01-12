package com.luna.hussein.modding;

import com.brandon3055.brandonscore.CommonProxy;
import com.brandon3055.draconicevolution.api.DraconicAPI;
import com.brandon3055.draconicevolution.api.crafting.IngredientStack;
import com.brandon3055.draconicevolution.client.ClientProxy;
import com.brandon3055.draconicevolution.client.DEParticles;
import com.brandon3055.draconicevolution.command.DECommands;
import com.brandon3055.draconicevolution.handlers.*;
import com.brandon3055.draconicevolution.init.*;
import com.brandon3055.draconicevolution.integration.computers.ComputerCraftCompatEventHandler;
import com.brandon3055.draconicevolution.integration.equipment.EquipmentManager;
import com.brandon3055.draconicevolution.items.tools.Dislocator;
import com.brandon3055.draconicevolution.network.DraconicNetwork;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.OptionalMod;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.luna.hussein.modding.setup.Registration;
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
import appeng.api.ids.AECreativeTabIds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.luna.hussein.modding.setup.ModItems;
import com.luna.hussein.modding.setup.Registration;
import com.brandon3055.brandonscore.lib.CustomTabHandling;
import com.brandon3055.draconicevolution.api.modules.items.ModuleItem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.lang.reflect.Field;
import com.brandon3055.brandonscore.lib.CustomTabHandling;
import com.brandon3055.draconicevolution.api.modules.items.ModuleItem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod("hussein")
public class HusseinPlayzYT {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "hussein";

    public static CommonProxy proxy;
    public static final String ID = "hussein";

    public HusseinPlayzYT() {
        ModItems.init();
//        Registration.register();
          Registration.addModuleProvider("hussein");


        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(HusseinPlayzYT::registerTabs);

    }
//    public static void init() {
//        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
//        modBus.addListener(HusseinPlayzYT::registerTabs);
//    }

    private static void registerTabs(RegisterEvent event) {
        event.register(Registries.CREATIVE_MODE_TAB, (helper) -> {
            List<ItemStack> itemsIcons = new ArrayList();
            helper.register(new ResourceLocation("hussein", "items"), CreativeModeTab.builder().title(Component.translatable("itemGroup.hussein.items")).displayItems((params, output) -> {
                for(ResourceLocation key : ForgeRegistries.ITEMS.getKeys()) {
                    if (key.getNamespace().equals("hussein")) {
                        Item item = (Item)ForgeRegistries.ITEMS.getValue(key);
                        if (!(item instanceof CustomTabHandling) && item != null && !(item instanceof BlockItem) && !(item instanceof ModuleItem)) {
                            output.accept(item);
                            itemsIcons.add(new ItemStack(item));
                        }
                    }
                }

            }).withTabFactory((builder) -> new HusseinPlayzYT.CyclingTab(builder, itemsIcons)).build());
        });
    }

    private static class CyclingTab extends CreativeModeTab {
        private final List<ItemStack> stacks;

        public CyclingTab(CreativeModeTab.Builder builder, List<ItemStack> stacks) {
            super(builder);
            this.stacks = stacks;
        }

        public ItemStack getIconItem() {
            int idx = (int)(System.currentTimeMillis() / 1200L) % this.stacks.size();
            return (ItemStack)this.stacks.get(idx);
        }
    }
    }

