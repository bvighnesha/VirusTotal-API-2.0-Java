/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.examples;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Arrays;
import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.IPAddressReport;
import me.vighnesh.api.virustotal.dao.IPAddressResolution;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
public class IpAddressReporter {

    public static void main(String[] args) throws UnknownHostException {
        String ip = "188.40.238.250";
        VirusTotalAPI virusTotal = VirusTotalAPI.configure("YOUR API KEY");
        IPAddressReport ipAddressReport = virusTotal.getIPAddressReport((Inet4Address) Inet4Address.getByName(ip));
        IPAddressResolution[] resolutions = ipAddressReport.getResolutions();
        System.out.println("---IP ADDRESS REPORT---");
        System.out.println("");
        for (IPAddressResolution resolution : resolutions) {
            System.out.println("Hostname : " + resolution.getHostName());
            System.out.println("Resolved : " + resolution.getLastResolved());
        }

        System.out.println("Verbose Message : " + ipAddressReport.getVerboseMessage());
        System.out.println("Response Code : " + ipAddressReport.getResponseCode());
        System.out.println("Detected Communicating Samples : " + Arrays.toString(ipAddressReport.getDetectedCommunicatingSamples()));
        System.out.println("Detected Downloading Samples : " + Arrays.toString(ipAddressReport.getDetectedDownloadedSamples()));
        System.out.println("Undetected Communicating Samples : " + Arrays.toString(ipAddressReport.getUndetectedCommunicatingSamples()));
        System.out.println("Undetected Communicating Samples : " + Arrays.toString(ipAddressReport.getUndetectedDownloadedSamples()));
        System.out.println("Detected URLS : " + Arrays.toString(ipAddressReport.getDetectedUrls()));
    }
}
