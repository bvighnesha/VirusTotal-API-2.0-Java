/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.dao;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import static java.util.Collections.unmodifiableMap;
import java.util.Map;

/**
 *
 * @author BVR
 */
public class URLScanReport {

    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("verbose_msg")
    @Expose
    private String verboseMsg;
    @Expose
    private String resource;
    @Expose
    private String url;
    @SerializedName("scan_id")
    @Expose
    private String scanId;
    @SerializedName("scan_date")
    @Expose
    private String scanDate;
    @Expose
    private String permalink;
    @Expose
    private Integer positives;
    @Expose
    private Integer total;
    @Expose
    private Map<String, URLScan> scans;
    @SerializedName("filescan_id")
    @Expose
    private String filescanId;

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
    public String getVerboseMsg() {
        return verboseMsg;
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
    public String getUrl() {
        return url;
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
    public Integer getPositives() {
        return positives;
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
    public Map<String, URLScan> getScans() {
        return unmodifiableMap(scans);
    }

    /**
     *
     * @return
     */
    public String getFilescanId() {
        return filescanId;
    }
}
