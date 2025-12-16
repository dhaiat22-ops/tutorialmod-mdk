package net.david.tutorialmod.item;

import net.david.tutorialmod.TutorialMod;
import net.david.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab>ALEXANDRITE_ITEM_TAB = CREATIVE_MOD_TABS.register("alexandrite_items_tab",
    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
            .title(Component.translatable("creativetab.tutorialmod.alexandrite_items"))
            .displayItems((itemDisplayParameter, output) -> {
                output.accept(ModItems.ALEXANDRITE.get());
                output.accept(ModItems.RAW_ALEXANDRITE.get());

            }).build());

    public static final RegistryObject<CreativeModeTab>ALEXANDRITE_BLOCK_TAB = CREATIVE_MOD_TABS.register("alexandrite_block_tab",
    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
            .withTabsBefore(ALEXANDRITE_ITEM_TAB.getId())
            .title(Component.translatable("creativetab.tutorialmod.alexandrite_blocks"))
            .displayItems((itemDisplayParameter, output) -> {
                output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                output.accept(ModBlocks.ALEXANDRITE_ORE.get());
                output.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());



            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
