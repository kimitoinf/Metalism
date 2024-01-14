package kimit.metalism.datagen;

import net.minecraft.registry.RegistryKey;

public class IdentifierHelper
{
	public static <T> String get(RegistryKey<T> key, String namespce, String identifier)
	{
		return key.getValue().getPath() + "." + namespce + "." + identifier;
	}
}