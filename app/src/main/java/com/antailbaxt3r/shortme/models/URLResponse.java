package com.antailbaxt3r.shortme.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class URLResponse {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("shortUrl")
    @Expose
    private String shortUrl;
    @SerializedName("urlCode")
    @Expose
    private String urlCode;
    @SerializedName("redirectCount")
    @Expose
    private Integer redirectCount;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("error")
    @Expose
    private String error;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getUrlCode() {
        return urlCode;
    }

    public void setUrlCode(String urlCode) {
        this.urlCode = urlCode;
    }

    public Integer getRedirectCount() {
        return redirectCount;
    }

    public void setRedirectCount(Integer redirectCount) {
        this.redirectCount = redirectCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
