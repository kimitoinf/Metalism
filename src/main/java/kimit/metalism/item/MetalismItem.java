package kimit.metalism.item;

import net.minecraft.item.Item;

public class MetalismItem extends Item
{
	public final String Identifier;

	public MetalismItem(Settings settings, String identifier)
	{
		super(settings);
		Identifier = identifier;
	}
}
