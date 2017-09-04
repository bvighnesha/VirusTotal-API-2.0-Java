/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.examples;

import java.util.Map;
import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.FileScan;
import me.vighnesh.api.virustotal.dao.FileScanReport;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
public class FileReporter {

    public static void main(String[] args) {
        String fileId = "FILE MD5 or SHA-1, SHA-256, SCAN-ID";
        VirusTotalAPI virusTotal = VirusTotalAPI.configure("YOUR API KEY");
        FileScanReport fileReport = virusTotal.getFileReport(fileId);
        Map<String, FileScan> scans = fileReport.getScans();
        scans.keySet().stream().forEach((scan) -> {
            FileScan report = scans.get(scan);
            System.out.println("Scan Engine : " + scan);
            if (report.isDetected()) {
                System.out.println("Version : " + report.getVersion());
                System.out.println("Update : " + report.getUpdate());
                System.out.println("Malware : " + report.getMalware());
            } else {
                System.out.println("No Virus Detected");
            }
        });
    }
}
