
package br.com.trendsoftware.b2wprovider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubOrder {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("channel")
    @Expose
    private String channel;
    @SerializedName("placed_at")
    public String placedAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("total_ordered")
    @Expose
    private Double totalOrdered;
    @SerializedName("interest")
    @Expose
    private Double interest;
    @SerializedName("discount")
    @Expose
    private Double discount;
    @SerializedName("shipping_cost")
    @Expose
    private Double shippingCost;
    @SerializedName("shipping_method")
    @Expose
    private String shippingMethod;
    @SerializedName("estimated_delivery")
    @Expose
    private String estimatedDelivery;
    @SerializedName("estimated_delivery_shift")
    @Expose
    private Object estimatedDeliveryShift;
    @SerializedName("shipping_address")
    @Expose
    private SkyHubOrderAddress shippingAddress;
    @SerializedName("billing_address")
    @Expose
    private SkyHubOrderAddress billingAddress;
    @SerializedName("customer")
    @Expose
    private SkyHubOrderCustomer customer;
    @SerializedName("items")
    @Expose
    private List<SkyHubOrderItem> items = null;
    @SerializedName("status")
    @Expose
    private SkyHubOrderStatus status;
    @SerializedName("sync_status")
    @Expose
    private String syncStatus;
    @SerializedName("invoices")
    @Expose
    private List<Object> invoices = null;
    @SerializedName("shipments")
    @Expose
    private List<Object> shipments = null;
    @SerializedName("payments")
    @Expose
    private List<Object> payments = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SkyHubOrder withCode(String code) {
        this.code = code;
        return this;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public SkyHubOrder withChannel(String channel) {
        this.channel = channel;
        return this;
    }

    public String getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(String placedAt) {
        this.placedAt = placedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public SkyHubOrder withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Double getTotalOrdered() {
        return totalOrdered;
    }

    public void setTotalOrdered(Double totalOrdered) {
        this.totalOrdered = totalOrdered;
    }

    public SkyHubOrder withTotalOrdered(Double totalOrdered) {
        this.totalOrdered = totalOrdered;
        return this;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public SkyHubOrder withInterest(Double interest) {
        this.interest = interest;
        return this;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public SkyHubOrder withDiscount(Double discount) {
        this.discount = discount;
        return this;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public SkyHubOrder withShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
        return this;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public SkyHubOrder withShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
        return this;
    }

    public String getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(String estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public SkyHubOrder withEstimatedDelivery(String estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
        return this;
    }

    public Object getEstimatedDeliveryShift() {
        return estimatedDeliveryShift;
    }

    public void setEstimatedDeliveryShift(Object estimatedDeliveryShift) {
        this.estimatedDeliveryShift = estimatedDeliveryShift;
    }

    public SkyHubOrder withEstimatedDeliveryShift(Object estimatedDeliveryShift) {
        this.estimatedDeliveryShift = estimatedDeliveryShift;
        return this;
    }

    public SkyHubOrderAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(SkyHubOrderAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public SkyHubOrder withShippingAddress(SkyHubOrderAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public SkyHubOrderAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(SkyHubOrderAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public SkyHubOrder withBillingAddress(SkyHubOrderAddress billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public SkyHubOrderCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(SkyHubOrderCustomer customer) {
        this.customer = customer;
    }

    public SkyHubOrder withCustomer(SkyHubOrderCustomer customer) {
        this.customer = customer;
        return this;
    }

    public List<SkyHubOrderItem> getItems() {
        return items;
    }

    public void setItems(List<SkyHubOrderItem> items) {
        this.items = items;
    }

    public SkyHubOrder withItems(List<SkyHubOrderItem> items) {
        this.items = items;
        return this;
    }

    public SkyHubOrderStatus getStatus() {
        return status;
    }

    public void setStatus(SkyHubOrderStatus status) {
        this.status = status;
    }

    public SkyHubOrder withStatus(SkyHubOrderStatus status) {
        this.status = status;
        return this;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public SkyHubOrder withSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
        return this;
    }

    public List<Object> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Object> invoices) {
        this.invoices = invoices;
    }

    public SkyHubOrder withInvoices(List<Object> invoices) {
        this.invoices = invoices;
        return this;
    }

    public List<Object> getShipments() {
        return shipments;
    }

    public void setShipments(List<Object> shipments) {
        this.shipments = shipments;
    }

    public SkyHubOrder withShipments(List<Object> shipments) {
        this.shipments = shipments;
        return this;
    }

    public List<Object> getPayments() {
        return payments;
    }

    public void setPayments(List<Object> payments) {
        this.payments = payments;
    }

    public SkyHubOrder withPayments(List<Object> payments) {
        this.payments = payments;
        return this;
    }

}
