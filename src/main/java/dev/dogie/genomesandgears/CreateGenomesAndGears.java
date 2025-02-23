package dev.dogie.genomesandgears;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.simibubi.create.foundation.item.TooltipModifier;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dev.dogie.genomesandgears.item.SwabItem;
import dev.dogie.genomesandgears.item.UVElectronTubeItem;

public class CreateGenomesAndGears implements ModInitializer {
    public static final String ID = "genomesandgears";
    public static final String NAME = "Create: Genomes and Gears";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    // Declare the swab item and assign it to the custom creative tab.
    public static final Item SWAB = new SwabItem(new Item.Properties());
    public static final Item UVELECTRONTUBE = new UVElectronTubeItem(new Item.Properties());

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ID)
        .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);

    @Override
    public void onInitialize() {
        LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
        LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib from the client!",
                () -> () -> "{} is accessing Porting Lib from the server!"
        ), NAME);
        
        Item swab = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ID, "swab"), SWAB);
        // ItemDescription swabDescription = ItemDescription.create(swab, TooltipHelper.Palette.STANDARD_CREATE);
        Item uvelectrontube = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ID, "uv_electron_tube"), UVELECTRONTUBE);

        GenomesAndGearsCreativeTab.register();

        REGISTRATE.setTooltipModifierFactory(item -> {
            return new ItemDescription.Modifier(item, TooltipHelper.Palette.STANDARD_CREATE)
                .andThen(TooltipModifier.mapNull(KineticStats.create(item)));
        });

        REGISTRATE.item("swab", SwabItem::new)
            .lang("Swab")
            .register();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(ID, path);
    }
}
