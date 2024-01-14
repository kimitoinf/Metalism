package kimit.metalism.datagen;

public enum Language
{
	EN_US("en_us"),
	KO_KR("ko_kr");

	private final String Lang;

	Language(String lang)
	{
		Lang = lang;
	}

	public String lang()
	{
		return Lang;
	}
}
