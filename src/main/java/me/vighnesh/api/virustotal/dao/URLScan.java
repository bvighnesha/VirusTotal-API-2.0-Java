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

/**
 *
 * @author BVR
 */
public class URLScan {

    @SerializedName("detected")
    @Expose
    private boolean malicious;
    @SerializedName("result")
    @Expose
    private String report;

    /**
     *
     * @return
     */
    public boolean isMalicious() {
        return malicious;
    }

    /**
     *
     * @return
     */
    public String getReport() {
        return report;
    }

}
