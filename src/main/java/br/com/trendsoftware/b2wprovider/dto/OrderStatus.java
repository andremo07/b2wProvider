package br.com.trendsoftware.b2wprovider.dto;

public enum OrderStatus {

	APPROVED("payment_received"),
	PENDING("book_product"),
	CANCELED("order_canceled"),
	SHIPPED("order_shipped"),
	COMPLETED("completed");
	

	private String name;

	private OrderStatus(String name) {
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
		for (OrderStatus c : OrderStatus.values())
			if (c.name.equals(name))
				return true;
		return false;
	}

	public static OrderStatus lookup(String nmMarketplace) 
	{
		for ( OrderStatus name : OrderStatus.values() )
			if ( nmMarketplace.equals(name.getName()) )
				return name;
		return null;
	}

}
