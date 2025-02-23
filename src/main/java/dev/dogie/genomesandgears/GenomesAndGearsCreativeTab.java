package dev.dogie.genomesandgears;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Registry;

public class GenomesAndGearsCreativeTab {
    public static final CreativeModeTab GENOMES_AND_GEARS_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            new ResourceLocation(CreateGenomesAndGears.ID, "genomes_and_gears_tab"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(CreateGenomesAndGears.SWAB))
                    .title(Component.translatable("itemGroup.genomes_and_gears"))
                    .displayItems((context, entries) -> {
                        entries.accept(CreateGenomesAndGears.SWAB);
                        entries.accept(CreateGenomesAndGears.UVELECTRONTUBE);
                    })
                    .build()
    );

    public static void register() {
        // This method ensures the class is loaded and registered
    }
}
