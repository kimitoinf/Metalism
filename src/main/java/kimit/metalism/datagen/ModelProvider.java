package kimit.metalism.datagen;

import kimit.metalism.Metalism;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

public class ModelProvider extends FabricModelProvider
{
	public ModelProvider(FabricDataOutput output)
	{
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator generator)
	{
		for (Block loop : Metalism.BLOCKS)
			generator.registerSimpleCubeAll(loop);
	}

	@Override
	public void generateItemModels(ItemModelGenerator generator)
	{
		for (Item loop : Metalism.ITEMS)
			generator.register(loop, Models.GENERATED);
	}
}
