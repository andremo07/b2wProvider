package br.com.trendsoftware.b2wprovider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubOrderList {
		
    @SerializedName("orders")
    @Expose
    private List<SkyHubOrder> orders = null;

	public List<SkyHubOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<SkyHubOrder> orders) {
		this.orders = orders;
	}
	
}
