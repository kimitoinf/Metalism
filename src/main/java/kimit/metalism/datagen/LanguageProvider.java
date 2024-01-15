package kimit.metalism.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public class LanguageProvider extends FabricLanguageProvider
{
	public final Language Lang;

	protected LanguageProvider(FabricDataOutput dataOutput, Language lang)
	{
		super(dataOutput, lang.lang());
		Lang = lang;
	}

	@Override
	public void generateTranslations(TranslationBuilder builder)
	{
		try
		{
			for (Class<? extends Translations> loop : new Reflections().getSubTypesOf(Translations.class))
			{
				Translations object = loop.getDeclaredConstructor().newInstance();
				object.initTranslation();
			}
		}
		catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e)
		{
			throw new RuntimeException(e);
		}

		for (Translation loop : Translations.TRANSLATIONS)
			if (loop.getLang().equals(Lang))
				builder.add(loop.getIdentifier(), loop.getValue());
	}
}
