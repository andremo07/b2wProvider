package br.com.trendsoftware.b2wprovider.dto;

public enum Marketplaces {

	TREND_STORE("TrendStore"),
	B2W("B2W"),
	MERCADO_LIVRE("MercadoLivre"),
	MAGENTO("Magento"),
	CNOVA("Cnova"),
	AMAZON("Amazon");

	private String name;

	private Marketplaces(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static boolean contains(String name)
	{
		for (Marketplaces c : Marketplaces.values())
			if (c.name.equals(name))
				return true;
		return false;
	}

	public static Marketplaces lookup(String nmMarketplace) 
	{
		for ( Marketplaces name : Marketplaces.values() )
			if ( nmMarketplace.equals(name.getName()) )
				return name;
		return null;
	}

}
