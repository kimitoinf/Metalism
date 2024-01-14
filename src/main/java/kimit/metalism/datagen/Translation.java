package kimit.metalism.datagen;

public class Translation
{
	private final Language Lang;
	private final String Identifier;
	private final String Value;

	public Translation(Language lang, String identifier, String value)
	{
		Lang = lang;
		Identifier = identifier;
		Value = value;
	}

	public Language getLang()
	{
		return Lang;
	}

	public String getIdentifier()
	{
		return Identifier;
	}

	public String getValue()
	{
		return Value;
	}
}
