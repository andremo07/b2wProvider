
package br.com.trendsoftware.b2wprovider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubOrderStatus {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("type")
    @Expose
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SkyHubOrderStatus withCode(String code) {
        this.code = code;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public SkyHubOrderStatus withLabel(String label) {
        this.label = label;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SkyHubOrderStatus withType(String type) {
        this.type = type;
        return this;
    }

}
