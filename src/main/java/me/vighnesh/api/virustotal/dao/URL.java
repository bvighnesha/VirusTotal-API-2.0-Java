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
public class URL {

    @SerializedName("url")
    private String url;
    @SerializedName("positives")
    private int positives;
    @SerializedName("total")
    private int total;
    @SerializedName("scan_date")
    private String scanDate;

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
    public int getPositives() {
        return positives;
    }

    /**
     *
     * @return
     */
    public int getTotal() {
        return total;
    }

    /**
     *
     * @return
     */
    public String getScanDate() {
        return scanDate;
    }

}
