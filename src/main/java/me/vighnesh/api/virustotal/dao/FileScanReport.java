/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.dao;

import com.google.gson.annotations.SerializedName;
import static java.util.Collections.unmodifiableMap;
import java.util.Map;

/**
 *
 * @author BVR
 */
public class FileScanReport {

    @SerializedName("scans")
    private Map<String, FileScan> scans;
    @SerializedName("scan_id")
    private String scanId;
    @SerializedName("sha1")
    private String SHA1;
    @SerializedName("resource")
    private String resource;
    @SerializedName("response_code")
    private Integer responseCode;
    @SerializedName("scan_date")
    private String scanDate;
    @SerializedName("permalink")
    private String permalink;
    @SerializedName("verbose_msg")
    private String verboseMessage;
    @SerializedName("total")
    private Integer total;
    @SerializedName("positives")
    private Integer positives;
    @SerializedName("sha256")
    private String SHA256;
    @SerializedName("md5")
    private String MD5;

    /**
     *
     * @return
     */
    public Map<String, FileScan> getScans() {
        return unmodifiableMap(scans);
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
    public Integer getResponseCode() {
        return responseCode;
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
     * @return
     */
    public String getPermalink() {
        return permalink;
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
    public Integer getTotal() {
        return total;
    }

    /**
     *
     * @return
     */
    public Integer getPositives() {
        return positives;
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
    public String getMD5() {
        return MD5;
    }

}
