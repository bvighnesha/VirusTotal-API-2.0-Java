/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.examples;

import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.CommentStatus;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
public class Comment {

    public static void main(String[] args) {
        VirusTotalAPI virusTotal = VirusTotalAPI.configure("YOUR API KEY");
        CommentStatus status = virusTotal.comment("SCAN ID", "Your Comment...");
        System.out.println("Verbose Message : " + status.getVerboseMsg());
        System.out.println("Response Code : " + status.getResponseCode());
    }
}
