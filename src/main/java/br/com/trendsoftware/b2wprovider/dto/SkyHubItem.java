
package br.com.trendsoftware.b2wprovider.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubItem {

	@SerializedName("sku")
	@Expose
	private String sku;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("status")
	@Expose
	private String status;
	@SerializedName("qty")
	@Expose
	private Long qty;
	@SerializedName("price")
	@Expose
	private Double price;
	@SerializedName("promotional_price")
	@Expose
	private Double promotionalPrice;
	@SerializedName("cost")
	@Expose
	private Double cost;
	@SerializedName("weight")
	@Expose
	private Double weight;
	@SerializedName("height")
	@Expose
	private Double height;
	@SerializedName("width")
	@Expose
	private Double width;
	@SerializedName("length")
	@Expose
	private Double length;
	@SerializedName("brand")
	@Expose
	private String brand;
	@SerializedName("ean")
	@Expose
	private String ean;
	@SerializedName("nbm")
	@Expose
	private String nbm;
	@SerializedName("categories")
	@Expose
	private List<SkyHubCategory> categories = null;
	@SerializedName("images")
	@Expose
	private List<String> images = null;
	@SerializedName("specifications")
	@Expose
	private List<Specification> specifications = null;
	@SerializedName("variations")
	@Expose
	private List<SkyHubVariation> variations = null;
	@SerializedName("variation_attributes")
	@Expose
	private List<String> variationAttributes = null;
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPromotionalPrice() {
		return promotionalPrice;
	}
	public void setPromotionalPrice(Double promotionalPrice) {
		this.promotionalPrice = promotionalPrice;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getEan() {
		return ean;
	}
	public void setEan(String ean) {
		this.ean = ean;
	}
	public String getNbm() {
		return nbm;
	}
	public void setNbm(String nbm) {
		this.nbm = nbm;
	}
	public List<SkyHubCategory> getCategories() {
		return categories;
	}
	public void setCategories(List<SkyHubCategory> categories) {
		this.categories = categories;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public List<Specification> getSpecifications() {
		return specifications;
	}
	public void setSpecifications(List<Specification> specifications) {
		this.specifications = specifications;
	}
	public List<SkyHubVariation> getVariations() {
		return variations;
	}
	public void setVariations(List<SkyHubVariation> variations) {
		this.variations = variations;
	}
	public List<String> getVariationAttributes() {
		return variationAttributes;
	}
	public void setVariationAttributes(List<String> variationAttributes) {
		this.variationAttributes = variationAttributes;
	}
	
}
