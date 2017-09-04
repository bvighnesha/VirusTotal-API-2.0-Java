/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.examples;

import java.util.List;
import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.FileScanMetaData;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
public class FilesReScanner {

    public static void main(String[] args) {
        String fileId1 = "FILE MD5 or SHA-1, SHA-256, SCAN-ID";
        String fileId2 = "FILE MD% or SHA-1, SHA-256, SCAN-ID";
        String[] fileIds = new String[]{fileId1, fileId2};
        VirusTotalAPI virusTotal = VirusTotalAPI.configure("YOUR API KEY");
        List<FileScanMetaData> reScanFiles = virusTotal.reScanFiles(fileIds);
        reScanFiles.stream().map((reScanFile) -> {
            System.out.println("MD5 : " + reScanFile.getMD5());
            return reScanFile;
        }).map((reScanFile) -> {
            System.out.println("SH-1 : " + reScanFile.getSHA1());
            return reScanFile;
        }).map((reScanFile) -> {
            System.out.println("SHA-256 : " + reScanFile.getSHA256());
            return reScanFile;
        }).map((reScanFile) -> {
            System.out.println("Permalink : " + reScanFile.getPermalink());
            return reScanFile;
        }).map((reScanFile) -> {
            System.out.println("Resource : " + reScanFile.getResource());
            return reScanFile;
        }).map((reScanFile) -> {
            System.out.println("Scan Id : " + reScanFile.getScanId());
            return reScanFile;
        }).map((reScanFile) -> {
            System.out.println("Response Code : " + reScanFile.getResponseCode());
            return reScanFile;
        }).map((reScanFile) -> {
            System.out.println("Verbose Message : " + reScanFile.getVerboseMessage());
            return reScanFile;
        }).forEach((_item) -> {
            System.out.println("");
        });
    }
}
