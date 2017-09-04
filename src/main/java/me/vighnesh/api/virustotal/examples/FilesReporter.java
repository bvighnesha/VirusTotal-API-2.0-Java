/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.examples;

import java.util.List;
import me.vighnesh.api.virustotal.VirusTotalAPI;
import me.vighnesh.api.virustotal.dao.FileScan;
import me.vighnesh.api.virustotal.dao.FileScanReport;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
public class FilesReporter {

    public static void main(String[] args) {
        String fileId1 = "FILE MD5 or SHA-1, SHA-256, SCAN-ID";
        String fileId2 = "FILE MD5 or SHA-1, SHA-256, SCAN-ID";
        String[] fileIds = new String[]{fileId1, fileId2};
        VirusTotalAPI virusTotal = VirusTotalAPI.configure("YOUR API KEY");
        List<FileScanReport> filesReports = virusTotal.getFilesReport(fileIds);
        System.out.println("---SCAN REPORTS---");
        System.out.println("");
        filesReports.stream().map((fileReport) -> fileReport.getScans()).map((scans) -> {
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
            return scans;
        }).forEach((_item) -> {
            System.out.println("");
        });
    }
}
