package br.com.trendsoftware.b2wprovider.dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListProductsB2wResponse {

    @SerializedName("products")
    @Expose
    private List<SkyHubItem> products = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("next")
    @Expose
    private String next;

    public List<SkyHubItem> getProducts() {
        return products;
    }

    public void setProducts(List<SkyHubItem> products) {
        this.products = products;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
