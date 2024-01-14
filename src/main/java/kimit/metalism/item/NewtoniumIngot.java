package kimit.metalism.item;

import kimit.metalism.Metalism;
import kimit.metalism.datagen.IdentifierHelper;
import kimit.metalism.datagen.Language;
import kimit.metalism.datagen.Translation;
import kimit.metalism.datagen.TranslationInterface;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.RegistryKeys;

public class NewtoniumIngot extends MetalismItem implements TranslationInterface
{
	public static final String IDENTIFIER = "newtonium_ingot";

	static
	{
		TRANSLATIONS.add(new Translation(Language.EN_US, IdentifierHelper.get(RegistryKeys.ITEM, Metalism.IDENTIFIER, IDENTIFIER), "Newtonium Ingot"));
		TRANSLATIONS.add(new Translation(Language.KO_KR, IdentifierHelper.get(RegistryKeys.ITEM, Metalism.IDENTIFIER, IDENTIFIER), "뉴터늄 주괴"));
	}

	public NewtoniumIngot()
	{
		super(new FabricItemSettings(), IDENTIFIER);
	}
}
