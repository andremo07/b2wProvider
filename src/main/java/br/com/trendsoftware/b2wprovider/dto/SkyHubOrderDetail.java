package br.com.trendsoftware.b2wprovider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubOrderDetail {
	
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("qty")
    @Expose
    private Long qty;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	
}
