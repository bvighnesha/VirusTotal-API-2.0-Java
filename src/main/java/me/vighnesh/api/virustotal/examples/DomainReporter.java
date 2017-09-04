/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.examples;

import java.util.Arrays;
import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.DomainReport;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
public class DomainReporter {

    public static void main(String[] args) {
        String domain = "vighnesh.me";
        VirusTotalAPI virusTotal = VirusTotalAPI.configure("YOUR API KEY");
        DomainReport domainReport = virusTotal.getDomainReport(domain);
        System.out.println("---DOMAIN REPORT---");
        System.out.println("Response Code : " + domainReport.getResponseCode());
        System.out.println("Verbose Message : " + domainReport.getVerboseMessage());
        System.out.println("Detected Communicating Samples : " + Arrays.toString(domainReport.getDetectedCommunicatingSamples()));
        System.out.println("Detected Downloaded Samples : " + Arrays.toString(domainReport.getDetectedDownloadedSamples()));
        System.out.println("Resolutions : " + Arrays.toString(domainReport.getResolutions()));
        System.out.println("Undetected Communicating Samples : " + Arrays.toString(domainReport.getUndetectedCommunicatingSamples()));
        System.out.println("Undetected Downloading Samples : " + Arrays.toString(domainReport.getUndetectedDownloadedSamples()));
    }
}
