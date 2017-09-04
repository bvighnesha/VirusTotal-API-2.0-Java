/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.examples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.URLScan;
import me.vighnesh.api.virustotal.dao.URLScanReport;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
public class URLsReporter {

    public static void main(String[] args) throws MalformedURLException {
        URL url1 = new URL("http://vighnesh.me");
        URL url2 = new URL("http://vighneswarrao.com");

        URL[] urls = new URL[]{url1, url2};

        VirusTotalAPI virusTotal = VirusTotalAPI.configure("YOUR API KEY");
        List<URLScanReport> urlReports = virusTotal.getURLsReport(urls);
        System.out.println("---URLS REPORT---");
        System.out.println("");
        urlReports.stream().map((urlReport) -> urlReport.getScans()).map((scans) -> {
            System.out.println("---URL REPORT---");
            return scans;
        }).map((scans) -> {
            System.out.println("");
            return scans;
        }).forEach((scans) -> {
            scans.keySet().stream().forEach((scan) -> {
                URLScan report = scans.get(scan);
                System.out.println(scan + "\t:" + report.getReport());
            });
        });
    }
}
