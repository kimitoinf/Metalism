package kimit.metalism.item;

import kimit.metalism.Metalism;
import kimit.metalism.datagen.IdentifierHelper;
import kimit.metalism.datagen.Language;
import kimit.metalism.datagen.Translation;
import kimit.metalism.datagen.Translations;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.RegistryKeys;

public class KepleriumIngot extends MetalismItem implements Translations
{
	public KepleriumIngot()
	{
		super(new FabricItemSettings(), "keplerium_ingot");
	}

	@Override
	public void initTranslation()
	{
		TRANSLATIONS.add(new Translation(Language.EN_US, IdentifierHelper.get(RegistryKeys.ITEM, Metalism.IDENTIFIER, Identifier), "Keplerium Ingot"));
		TRANSLATIONS.add(new Translation(Language.KO_KR, IdentifierHelper.get(RegistryKeys.ITEM, Metalism.IDENTIFIER, Identifier), "케플륨 주괴"));
	}
}
