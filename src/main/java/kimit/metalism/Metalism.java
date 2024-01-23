package kimit.metalism;

import kimit.metalism.block.MetalismBlock;
import kimit.metalism.item.MetalismItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
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
	public static final List<Item> ITEMS_WITHOUT_BLOCKS = new ArrayList<>();
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
				ITEMS_WITHOUT_BLOCKS.add(Registry.register(Registries.ITEM, new Identifier(IDENTIFIER, item.Identifier), item));
				ITEMS.add(item);
			}

			for (Class<? extends MetalismBlock> loop : new Reflections().getSubTypesOf(MetalismBlock.class))
			{
				MetalismBlock block = loop.getDeclaredConstructor().newInstance();
				BLOCKS.add(Registry.register(Registries.BLOCK, new Identifier(IDENTIFIER, block.Identifier), block));
				Registry.register(Registries.ITEM, new Identifier(IDENTIFIER, block.Identifier), block.getItem());
				ITEMS.add(block.getItem());
			}

			ItemGroup.Builder builder = FabricItemGroup.builder();
			List<ItemStack> list = new ArrayList<>();
			for (var loop : ITEMS)
			{
				if (loop instanceof MetalismItem && ((MetalismItem) loop).Identifier.equals("newtonium_ingot"))
					builder.icon(() -> new ItemStack(loop));
				list.add(new ItemStack(loop));
			}
			builder.entries((context, entries) -> entries.addAll(list));
			builder.displayName(Text.of("Metalism"));
			Registry.register(Registries.ITEM_GROUP, new Identifier(IDENTIFIER, "group"), builder.build());

			// ore generation
		}
		catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e)
		{
			LOGGER.error(e.getMessage());
		}
	}
}