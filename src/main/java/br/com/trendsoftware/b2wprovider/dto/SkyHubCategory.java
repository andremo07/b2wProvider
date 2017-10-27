
package br.com.trendsoftware.b2wprovider.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubCategory {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SkyHubCategory withCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkyHubCategory withName(String name) {
        this.name = name;
        return this;
    }

}
