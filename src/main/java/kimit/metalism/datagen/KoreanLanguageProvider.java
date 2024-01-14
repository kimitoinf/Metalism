package kimit.metalism.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;

public class KoreanLanguageProvider extends LanguageProvider
{
	protected KoreanLanguageProvider(FabricDataOutput dataOutput)
	{
		super(dataOutput, Language.KO_KR);
	}
}
