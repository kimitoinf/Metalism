package kimit.metalism;

import kimit.metalism.item.MetalismItem;
import net.fabricmc.api.ModInitializer;

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
		}
		catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e)
		{
			LOGGER.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}