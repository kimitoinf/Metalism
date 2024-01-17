package kimit.metalism.block;

import kimit.metalism.Metalism;
import kimit.metalism.datagen.IdentifierHelper;
import kimit.metalism.datagen.Language;
import kimit.metalism.datagen.Translation;
import kimit.metalism.datagen.Translations;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.RegistryKeys;

public class NewtoniumOre extends MetalismBlock implements Translations
{
	public NewtoniumOre()
	{
		super(FabricBlockSettings.create(), "newtonium_ore");
		setItem(new BlockItem(this, new FabricItemSettings()));
	}

	@Override
	public void initTranslation()
	{
		TRANSLATIONS.add(new Translation(Language.EN_US, IdentifierHelper.get(RegistryKeys.BLOCK, Metalism.IDENTIFIER, Identifier), "Newtonium Ore"));
		TRANSLATIONS.add(new Translation(Language.KO_KR, IdentifierHelper.get(RegistryKeys.BLOCK, Metalism.IDENTIFIER, Identifier), "뉴터늄 광석"));
	}
}
