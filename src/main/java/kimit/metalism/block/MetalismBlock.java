package kimit.metalism.block;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class MetalismBlock extends Block
{
	public final String Identifier;
	private Item BlockItem;

	public MetalismBlock(Settings settings, String identifier)
	{
		super(settings);
		Identifier = identifier;
	}

	public void initBlockItem(Item item)
	{
		BlockItem = item;
	}

	public Item getBlockItem()
	{
		return BlockItem;
	}

	public static class Item extends BlockItem
	{
		public Item(Block block, Settings settings)
		{
			super(block, settings);
		}
	}
}
