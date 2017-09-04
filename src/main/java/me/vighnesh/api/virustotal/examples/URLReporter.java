/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.examples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.URLScan;
import me.vighnesh.api.virustotal.dao.URLScanReport;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
public class URLReporter {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://eicar.org");
        VirusTotalAPI virusTotal = VirusTotalAPI.configure("YOUR API KEY");
        URLScanReport urlReport = virusTotal.getURLReport(url);
        System.out.println("---SCAN META DATA---");
        System.out.println("");
        System.out.println("Response Code : " + urlReport.getResponseCode());
        System.out.println("Resource : " + urlReport.getResource());
        System.out.println("Scan ID : " + urlReport.getScanId());
        System.out.println("Permalink : " + urlReport.getPermalink());
        System.out.println("Scan Date : " + urlReport.getScanDate());
        System.out.println("Positives : " + urlReport.getPositives());
        System.out.println("Total : " + urlReport.getTotal());
        System.out.println("File Scan Id : " + urlReport.getFilescanId());

        Map<String, URLScan> scans = urlReport.getScans();
        System.out.println("---URL REPORT---");
        System.out.println("");
        scans.keySet().stream().forEach((String scan) -> {
            URLScan report = scans.get(scan);
            System.out.println(scan + "\t:" + report.getReport());
        });
    }
}
