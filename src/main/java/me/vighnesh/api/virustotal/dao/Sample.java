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
public class Sample {

    @SerializedName("date")
    private String date;
    @SerializedName("positives")
    private int positives;
    @SerializedName("total")
    private int total;
    @SerializedName("sha256")
    private String SHA256;

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
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
    public String getSHA256() {
        return SHA256;
    }

}
