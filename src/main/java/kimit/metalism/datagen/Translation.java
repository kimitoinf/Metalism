package kimit.metalism.datagen;

import java.util.Objects;

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

	@Override
	public int hashCode()
	{
		return Objects.hash(Lang, Identifier, Value);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Translation t)) return false;
		return t.getLang() == Lang && t.getIdentifier().equals(Identifier) && t.getValue().equals(Value);
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
