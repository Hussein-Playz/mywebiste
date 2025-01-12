package com.luna.hussein.modding.datagen;

import com.brandon3055.draconicevolution.datagen.*;
import com.luna.hussein.modding.setup.ModItems;
import com.luna.hussein.modding.HusseinPlayzYT;
import com.brandon3055.draconicevolution.api.modules.Module;
import com.brandon3055.draconicevolution.api.modules.ModuleRegistry;
import com.brandon3055.draconicevolution.init.DEContent;
import com.brandon3055.draconicevolution.init.DETags.Items;
import com.brandon3055.draconicevolution.integration.equipment.CuriosIntegration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import org.jetbrains.annotations.Nullable;

@EventBusSubscriber(
        bus = Bus.MOD
)
public class DataGenEventHandler {
    public DataGenEventHandler() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        if (event.includeClient()) {
              gen.addProvider(true, new RecipeGenerator(gen.getPackOutput()));
//            gen.addProvider(true, new LangGenerator(gen.getPackOutput()));
//            gen.addProvider(true, new BlockStateGenerator(gen, event.getExistingFileHelper()));
//            gen.addProvider(true, new ItemModelGenerator(gen, event.getExistingFileHelper()));
//            gen.addProvider(true, new MultiBlockGenerator(gen));
//            gen.addProvider(true, new DynamicTextures(gen, event.getExistingFileHelper()));
        }
//
        if (event.includeServer()) {
//            gen.addProvider(true, new RecipeGenerator(gen.getPackOutput()));
//            gen.addProvider(event.includeServer(), new LootTableProvider(event.getGenerator().getPackOutput(), Set.of(), List.of(new LootTableProvider.SubProviderEntry(BlockLootProvider::new, LootContextParamSets.BLOCK))));
//            BlockTagGenerator blockGenerator = new BlockTagGenerator(gen.getPackOutput(), event.getLookupProvider(), "draconicevolution", event.getExistingFileHelper());
//            gen.addProvider(true, blockGenerator);
//            gen.addProvider(true, new com.brandon3055.draconicevolution.datagen.DataGenEventHandler.ItemTagGenerator(gen.getPackOutput(), event.getLookupProvider(), blockGenerator.contentsGetter(), "draconicevolution", event.getExistingFileHelper()));
//            gen.addProvider(true, new DamageTypeGenerator(gen.getPackOutput(), event.getLookupProvider(), "draconicevolution", event.getExistingFileHelper()));
        }
//
//    }

//     class ItemTagGenerator extends ItemTagsProvider {
//        public ItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> pBlockTags, String modId, @Nullable ExistingFileHelper existingFileHelper) {
//            super(pOutput, pLookupProvider, pBlockTags, modId, existingFileHelper);
//        }
//
//        protected void addTags(HolderLookup.Provider pProvider) {
//            this.tag(Items.DUSTS_DRACONIUM).add((Item)DEContent.DUST_DRACONIUM.get());
//            this.tag(Items.DUSTS_DRACONIUM_AWAKENED).add((Item)DEContent.DUST_DRACONIUM_AWAKENED.get());
//            this.tag(net.minecraftforge.common.Tags.Items.DUSTS).addTags(new TagKey[]{Items.DUSTS_DRACONIUM_AWAKENED, Items.DUSTS_DRACONIUM});
//            this.tag(Items.NUGGETS_DRACONIUM).add((Item)DEContent.NUGGET_DRACONIUM.get());
//            this.tag(Items.NUGGETS_DRACONIUM_AWAKENED).add((Item)DEContent.NUGGET_DRACONIUM_AWAKENED.get());
//            this.tag(net.minecraftforge.common.Tags.Items.NUGGETS).addTags(new TagKey[]{Items.NUGGETS_DRACONIUM_AWAKENED, Items.NUGGETS_DRACONIUM});
//            this.tag(Items.INGOTS_DRACONIUM).add((Item)DEContent.INGOT_DRACONIUM.get());
//            this.tag(Items.INGOTS_DRACONIUM_AWAKENED).add((Item)DEContent.INGOT_DRACONIUM_AWAKENED.get());
//            this.tag(net.minecraftforge.common.Tags.Items.INGOTS).addTags(new TagKey[]{Items.INGOTS_DRACONIUM_AWAKENED, Items.INGOTS_DRACONIUM});
//            this.tag(Items.STORAGE_BLOCKS_DRACONIUM).add((Item)DEContent.ITEM_DRACONIUM_BLOCK.get());
//            this.tag(Items.STORAGE_BLOCKS_DRACONIUM_AWAKENED).add((Item)DEContent.ITEM_AWAKENED_DRACONIUM_BLOCK.get());
//            this.tag(net.minecraftforge.common.Tags.Items.STORAGE_BLOCKS).addTags(new TagKey[]{Items.STORAGE_BLOCKS_DRACONIUM, Items.STORAGE_BLOCKS_DRACONIUM_AWAKENED});
//            this.tag(Items.ORES_DRACONIUM).add(new Item[]{(Item)DEContent.ITEM_END_DRACONIUM_ORE.get(), (Item)DEContent.ITEM_NETHER_DRACONIUM_ORE.get(), (Item)DEContent.ITEM_OVERWORLD_DRACONIUM_ORE.get()});
//            this.tag(net.minecraftforge.common.Tags.Items.ORES).addTag(Items.ORES_DRACONIUM);
//
//            for(Module<?> module : ModuleRegistry.getRegistry().getValues()) {
//                this.tag(Items.MODULES).add(module.getItem());
//            }
//
//            if (ModList.get().isLoaded("curios")) {
//                CuriosIntegration.generateTags((x$0) -> this.tag(x$0));
//            }
//
//        }
    }
}


