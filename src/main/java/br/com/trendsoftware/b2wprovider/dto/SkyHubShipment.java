
package br.com.trendsoftware.b2wprovider.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkyHubShipment {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("items")
    @Expose
    private List<SkyHubItem> items = null;
    @SerializedName("track")
    @Expose
    private SkyHubTrack track;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SkyHubShipment withCode(String code) {
        this.code = code;
        return this;
    }

    public List<SkyHubItem> getItems() {
        return items;
    }

    public void setItems(List<SkyHubItem> items) {
        this.items = items;
    }

    public SkyHubShipment withItems(List<SkyHubItem> items) {
        this.items = items;
        return this;
    }

    public SkyHubTrack getTrack() {
        return track;
    }

    public void setTrack(SkyHubTrack track) {
        this.track = track;
    }

    public SkyHubShipment withTrack(SkyHubTrack track) {
        this.track = track;
        return this;
    }

}
