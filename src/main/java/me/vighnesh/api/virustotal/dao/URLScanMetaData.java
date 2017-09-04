/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author BVR
 */
public class URLScanMetaData {

    @Expose
    private String permalink;
    @Expose
    private String resource;
    @Expose
    private String url;
    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("scan_date")
    @Expose
    private String scanDate;
    @SerializedName("scan_id")
    @Expose
    private String scanId;
    @SerializedName("verbose_msg")
    @Expose
    private String verboseMsg;

    /**
     *
     * @return
     */
    public String getPermalink() {
        return permalink;
    }

    /**
     *
     * @param permalink
     */
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    /**
     *
     * @return
     */
    public String getResource() {
        return resource;
    }

    /**
     *
     * @param resource
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     */
    public Integer getResponseCode() {
        return responseCode;
    }

    /**
     *
     * @param responseCode
     */
    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    /**
     *
     * @return
     */
    public String getScanDate() {
        return scanDate;
    }

    /**
     *
     * @param scanDate
     */
    public void setScanDate(String scanDate) {
        this.scanDate = scanDate;
    }

    /**
     *
     * @return
     */
    public String getScanId() {
        return scanId;
    }

    /**
     *
     * @param scanId
     */
    public void setScanId(String scanId) {
        this.scanId = scanId;
    }

    /**
     *
     * @return
     */
    public String getVerboseMsg() {
        return verboseMsg;
    }

    /**
     *
     * @param verboseMsg
     */
    public void setVerboseMsg(String verboseMsg) {
        this.verboseMsg = verboseMsg;
    }

}
