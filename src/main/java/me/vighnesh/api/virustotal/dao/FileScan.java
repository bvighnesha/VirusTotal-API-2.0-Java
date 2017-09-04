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
public class FileScan {

    @SerializedName("detected")
    private boolean detected;
    @SerializedName("version")
    private String version;
    @SerializedName("result")
    private String malware;
    @SerializedName("update")
    private String update;

    /**
     *
     * @return
     */
    public boolean isDetected() {
        return detected;
    }

    /**
     *
     * @return
     */
    public String getVersion() {
        return version;
    }

    /**
     *
     * @return
     */
    public String getMalware() {
        return malware;
    }

    /**
     *
     * @return
     */
    public String getUpdate() {
        return update;
    }

}
