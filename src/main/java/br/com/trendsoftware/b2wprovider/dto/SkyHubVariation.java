
package br.com.trendsoftware.b2wprovider.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubVariation {

    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("qty")
    @Expose
    private Long qty;
    @SerializedName("ean")
    @Expose
    private String ean;
    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("specifications")
    @Expose
    private List<Specification> specifications = null;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public SkyHubVariation withSku(String sku) {
        this.sku = sku;
        return this;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public SkyHubVariation withQty(Long qty) {
        this.qty = qty;
        return this;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public SkyHubVariation withEan(String ean) {
        this.ean = ean;
        return this;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public SkyHubVariation withImages(List<String> images) {
        this.images = images;
        return this;
    }

    public List<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }

    public SkyHubVariation withSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
        return this;
    }

}
