/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.examples;

import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.FileScanMetaData;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
public class FileReScanner {

    public static void main(String[] args) {
        VirusTotalAPI virusTotal = VirusTotalAPI.configure("YOUR API KEY");
        FileScanMetaData reScanFile = virusTotal.reScanFile("FILE MD5 or SHA-1, SHA-256, SCAN-ID");
        System.out.println("MD5 : " + reScanFile.getMD5());
        System.out.println("SH-1 : " + reScanFile.getSHA1());
        System.out.println("SHA-256 : " + reScanFile.getSHA256());
        System.out.println("Permalink : " + reScanFile.getPermalink());
        System.out.println("Resource : " + reScanFile.getResource());
        System.out.println("Scan Id : " + reScanFile.getScanId());
        System.out.println("Response Code : " + reScanFile.getResponseCode());
        System.out.println("Verbose Message : " + reScanFile.getVerboseMessage());
    }
}
