package kimit.metalism.block;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class MetalismBlock extends Block
{
	public final String Identifier;
	protected BlockItem Item;

	public MetalismBlock(Settings settings, String identifier)
	{
		super(settings);
		Identifier = identifier;
	}

	protected void setItem(BlockItem item)
	{
		Item = item;
	}

	public BlockItem getItem()
	{
		return Item;
	}
}
