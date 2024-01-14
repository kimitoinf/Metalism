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
			for (Class<? extends TranslationInterface> loop : new Reflections().getSubTypesOf(TranslationInterface.class))
				for (Translation loop2 : loop.getDeclaredConstructor().newInstance().TRANSLATIONS)
					if (loop2.getLang().equals(Lang))
						builder.add(loop2.getIdentifier(), loop2.getValue());
		}
		catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e)
		{
			throw new RuntimeException(e);
		}
	}
}
