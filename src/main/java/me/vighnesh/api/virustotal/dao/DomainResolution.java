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
public class DomainResolution {

    @SerializedName("last_resolved")
    private String lastResolved;
    @SerializedName("ip_address")
    private String ipAddress;

    /**
     *
     * @return
     */
    public String getLastResolved() {
        return lastResolved;
    }

    /**
     *
     * @return
     */
    public String getIpAddress() {
        return ipAddress;
    }

}
