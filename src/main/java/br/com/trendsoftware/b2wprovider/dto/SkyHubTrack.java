
package br.com.trendsoftware.b2wprovider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubTrack {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("carrier")
    @Expose
    private String carrier;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("url")
    @Expose
    private String url;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SkyHubTrack withCode(String code) {
        this.code = code;
        return this;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public SkyHubTrack withCarrier(String carrier) {
        this.carrier = carrier;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public SkyHubTrack withMethod(String method) {
        this.method = method;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public SkyHubTrack withUrl(String url) {
        this.url = url;
        return this;
    }

}
