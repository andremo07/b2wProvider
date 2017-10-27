
package br.com.trendsoftware.b2wprovider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubOrderItem {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("qty")
    @Expose
    private Long qty;
    @SerializedName("original_price")
    @Expose
    private Double originalPrice;
    @SerializedName("special_price")
    @Expose
    private Double specialPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SkyHubOrderItem withId(String id) {
        this.id = id;
        return this;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public SkyHubOrderItem withProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkyHubOrderItem withName(String name) {
        this.name = name;
        return this;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public SkyHubOrderItem withQty(Long qty) {
        this.qty = qty;
        return this;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public SkyHubOrderItem withOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
        return this;
    }

    public Double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    public SkyHubOrderItem withSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
        return this;
    }

}
