/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.FileScanMetaData;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
public class FileScannerWithFileInputStream {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream("FILE YOU WANT TO SCAN");
        VirusTotalAPI virusTotal = VirusTotalAPI.configure("YOUR API KEY");
        FileScanMetaData scanFile = virusTotal.scanFile("File Name", fileInputStream);
        System.out.println("---SCAN META DATA---");
        System.out.println("");
        System.out.println("MD5 : " + scanFile.getMD5());
        System.out.println("SH-1 : " + scanFile.getSHA1());
        System.out.println("SHA-256 : " + scanFile.getSHA256());
        System.out.println("Permalink : " + scanFile.getPermalink());
        System.out.println("Resource : " + scanFile.getResource());
        System.out.println("Scan Id : " + scanFile.getScanId());
        System.out.println("Response Code : " + scanFile.getResponseCode());
        System.out.println("Verbose Message : " + scanFile.getVerboseMessage());
    }
}
