/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.examples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.URLScanMetaData;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
public class URLsScanner {

    public static void main(String[] args) throws MalformedURLException {
        URL url1 = new URL("http://vighnesh.me");
        URL url2 = new URL("http://vighneswarrao.com");

        URL[] urls = new URL[]{url1, url2};

        VirusTotalAPI virusTotal = VirusTotalAPI.configure("YOUR API KEY");
        List<URLScanMetaData> scanURLs = virusTotal.scanURLs(urls);
        System.out.println("---SCAN  META DATA---");
        System.out.println("");
        scanURLs.stream().map((scanURL) -> {
            System.out.println("URL : " + scanURL.getUrl());
            return scanURL;
        }).map((scanURL) -> {
            System.out.println("Resource : " + scanURL.getResource());
            return scanURL;
        }).map((scanURL) -> {
            System.out.println("Scan Date : " + scanURL.getScanDate());
            return scanURL;
        }).map((scanURL) -> {
            System.out.println("Scan Id : " + scanURL.getScanId());
            return scanURL;
        }).map((scanURL) -> {
            System.out.println("Response Code : " + scanURL.getResponseCode());
            return scanURL;
        }).map((scanURL) -> {
            System.out.println("Permalink : " + scanURL.getPermalink());
            return scanURL;
        }).map((scanURL) -> {
            System.out.println("VerboseMessage : " + scanURL.getVerboseMsg());
            return scanURL;
        }).forEach((_item) -> {
            System.out.println("");
        });
    }
}
