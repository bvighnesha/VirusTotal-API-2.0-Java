/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.examples;

import java.io.IOException;
import java.net.URL;
import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.URLScanMetaData;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
public class URLScanner {

    public static void main(String[] args) throws IOException {
        String url = "http://vighnesh.me";
        VirusTotalAPI virusTotal = VirusTotalAPI.configure("YOUR API KEY");
        URLScanMetaData scanURL = virusTotal.scanURL(new URL(url));
        System.out.println("---SCAN META DATA---");
        System.out.println("");
        System.out.println("URL : " + scanURL.getUrl());
        System.out.println("Resource : " + scanURL.getResource());
        System.out.println("Scan Date : " + scanURL.getScanDate());
        System.out.println("Scan Id : " + scanURL.getScanId());
        System.out.println("Response Code : " + scanURL.getResponseCode());
        System.out.println("Permalink : " + scanURL.getPermalink());
        System.out.println("VerboseMessage : " + scanURL.getVerboseMsg());
    }
}
