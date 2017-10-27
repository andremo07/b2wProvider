
package br.com.trendsoftware.b2wprovider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubOrderAddress {

    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("neighborhood")
    @Expose
    private String neighborhood;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("secondary_phone")
    @Expose
    private Object secondaryPhone;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public SkyHubOrderAddress withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public SkyHubOrderAddress withStreet(String street) {
        this.street = street;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public SkyHubOrderAddress withNumber(String number) {
        this.number = number;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public SkyHubOrderAddress withDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public SkyHubOrderAddress withNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public SkyHubOrderAddress withCity(String city) {
        this.city = city;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public SkyHubOrderAddress withRegion(String region) {
        this.region = region;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public SkyHubOrderAddress withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public SkyHubOrderAddress withPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SkyHubOrderAddress withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Object getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(Object secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public SkyHubOrderAddress withSecondaryPhone(Object secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
        return this;
    }

}
