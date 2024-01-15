package kimit.metalism.datagen;

import java.util.HashSet;
import java.util.Set;

public interface Translations
{
	Set<Translation> TRANSLATIONS = new HashSet<>();

	void initTranslation();
}
