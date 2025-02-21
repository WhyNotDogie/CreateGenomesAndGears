package dev.dogie.genomesandgears;

import com.simibubi.create.Create;
import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dev.dogie.genomesandgears.item.SwabItem;

public class CreateGenomesAndGears implements ModInitializer {
    public static final String ID = "genomesandgears";
    public static final String NAME = "Create: Genomes and Gears";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    // Declare the swab item and assign it to the custom creative tab.
    public static final Item SWAB = new SwabItem(new Item.Properties());

    @Override
    public void onInitialize() {
        LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
        LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib from the client!",
                () -> () -> "{} is accessing Porting Lib from the server!"
        ), NAME);

        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ID, "swab"), SWAB);

        GenomesAndGearsCreativeTab.register();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(ID, path);
    }
}
