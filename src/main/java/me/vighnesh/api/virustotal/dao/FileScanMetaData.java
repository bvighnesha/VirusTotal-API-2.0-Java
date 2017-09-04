/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.dao;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author BVR
 */
public class FileScanMetaData {

    @SerializedName("scan_id")
    private String scanId;
    @SerializedName("sha1")
    private String SHA1;
    @SerializedName("resource")
    private String resource;
    @SerializedName("response_code")
    private int responseCode;
    @SerializedName("sha256")
    private String SHA256;
    @SerializedName("permalink")
    private String permalink;
    @SerializedName("md5")
    private String MD5;
    @SerializedName("verbose_msg")
    private String verboseMessage;
    @SerializedName("scan_date")
    private String scanDate;

    /**
     *
     * @return
     */
    public String getScanId() {
        return scanId;
    }

    /**
     *
     * @return
     */
    public String getSHA1() {
        return SHA1;
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
     * @return
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     *
     * @return
     */
    public String getSHA256() {
        return SHA256;
    }

    /**
     *
     * @return
     */
    public String getPermalink() {
        return permalink;
    }

    /**
     *
     * @return
     */
    public String getMD5() {
        return MD5;
    }

    /**
     *
     * @return
     */
    public String getVerboseMessage() {
        return verboseMessage;
    }

    /**
     *
     * @return
     */
    public String getScanDate() {
        return scanDate;
    }

}
