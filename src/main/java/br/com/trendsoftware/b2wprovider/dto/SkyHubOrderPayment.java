
package br.com.trendsoftware.b2wprovider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubOrderPayment {

	@Expose
	private Double value;
	@SerializedName("status")
	@Expose
	private Object status;
	@SerializedName("parcels")
	@Expose
	private Integer parcels;
	@SerializedName("method")
	@Expose
	private String method;
	@SerializedName("description")
	@Expose
	private String description;

	public Double getValue() {
	return value;
	}

	public void setValue(Double value) {
	this.value = value;
	}

	public Object getStatus() {
	return status;
	}

	public void setStatus(Object status) {
	this.status = status;
	}

	public Integer getParcels() {
	return parcels;
	}

	public void setParcels(Integer parcels) {
	this.parcels = parcels;
	}

	public String getMethod() {
	return method;
	}

	public void setMethod(String method) {
	this.method = method;
	}

	public String getDescription() {
	return description;
	}

	public void setDescription(String description) {
	this.description = description;
	}
}
