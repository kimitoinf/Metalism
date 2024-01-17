package kimit.metalism;

import kimit.metalism.block.MetalismBlock;
import kimit.metalism.item.MetalismItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Metalism implements ModInitializer
{
	public static final String IDENTIFIER = "metalism";
    public static final Logger LOGGER = LoggerFactory.getLogger(IDENTIFIER);
	public static final List<Item> ITEMS = new ArrayList<>();
	public static final List<Block> BLOCKS = new ArrayList<>();

	@Override
	public void onInitialize()
	{
		LOGGER.info("Metalism.");

		try
		{
			for (Class<? extends MetalismItem> loop : new Reflections().getSubTypesOf(MetalismItem.class))
			{
				MetalismItem item = loop.getDeclaredConstructor().newInstance();
				ITEMS.add(Registry.register(Registries.ITEM, new Identifier(IDENTIFIER, item.Identifier), item));
			}

			for (Class<? extends MetalismBlock> loop : new Reflections().getSubTypesOf(MetalismBlock.class))
			{
				MetalismBlock block = loop.getDeclaredConstructor().newInstance();
				BLOCKS.add(Registry.register(Registries.BLOCK, new Identifier(IDENTIFIER, block.Identifier), block));
				Registry.register(Registries.ITEM, new Identifier(IDENTIFIER, block.Identifier), block.getItem());
			}

			// ore generation
		}
		catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e)
		{
			LOGGER.error(e.getMessage());
		}
	}
}