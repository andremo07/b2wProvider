
package br.com.trendsoftware.b2wprovider.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubCreateOrder {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("channel")
    @Expose
    private String channel;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("items")
    @Expose
    private List<SkyHubOrderDetail> items = null;
    @SerializedName("customer")
    @Expose
    private SkyHubCustomer customer;
    @SerializedName("billing_address")
    @Expose
    private SkyHubAddress billingAddress;
    @SerializedName("shipping_address")
    @Expose
    private SkyHubAddress shippingAddress;
    @SerializedName("shipping_method")
    @Expose
    private String shippingMethod;
    @SerializedName("estimated_delivery")
    @Expose
    private String estimatedDelivery;
    @SerializedName("shipping_cost")
    @Expose
    private Double shippingCost;
    @SerializedName("interest")
    @Expose
    private Double interest;
    @SerializedName("sync_status")
    @Expose
    private String syncStatus;
    @SerializedName("invoices")
    @Expose
    private List<String> invoices = null;
    @SerializedName("shipments")
    @Expose
    private List<String> shipments = null;
    @SerializedName("payments")
    @Expose
    private List<String> payments = null;
    
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SkyHubOrderDetail> getItems() {
        return items;
    }

    public void setItems(List<SkyHubOrderDetail> items) {
        this.items = items;
    }

    public SkyHubCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(SkyHubCustomer customer) {
        this.customer = customer;
    }

    public SkyHubAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(SkyHubAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public SkyHubAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(SkyHubAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(String estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

	public String getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}

	public List<String> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<String> invoices) {
		this.invoices = invoices;
	}

	public List<String> getShipments() {
		return shipments;
	}

	public void setShipments(List<String> shipments) {
		this.shipments = shipments;
	}

	public List<String> getPayments() {
		return payments;
	}

	public void setPayments(List<String> payments) {
		this.payments = payments;
	}
}
