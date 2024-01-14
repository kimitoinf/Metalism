package kimit.metalism.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MetalismDataGenerator implements DataGeneratorEntrypoint
{
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator)
	{
		FabricDataGenerator.Pack pack = generator.createPack();
		pack.addProvider(EnglishLanguageProvider::new);
		pack.addProvider(KoreanLanguageProvider::new);
		pack.addProvider(ModelProvider::new);
	}
}
