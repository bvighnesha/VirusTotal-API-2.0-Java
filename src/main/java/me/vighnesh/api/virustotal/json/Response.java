/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.json;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.vighnesh.api.virustotal.dao.CommentStatus;
import me.vighnesh.api.virustotal.dao.DomainReport;
import me.vighnesh.api.virustotal.dao.FileScanMetaData;
import me.vighnesh.api.virustotal.dao.FileScanReport;
import me.vighnesh.api.virustotal.dao.IPAddressReport;
import me.vighnesh.api.virustotal.dao.URLScanMetaData;
import me.vighnesh.api.virustotal.dao.URLScanReport;

/**
 *
 * @author BVR
 */
public class Response {

    private final Gson gson = new Gson();

    public CommentStatus parseCommentStatus(String response) {
        return gson.fromJson(response, CommentStatus.class);
    }

    public List<FileScanMetaData> parseFileScanMetadata(String response, boolean isMultiResponse) {
        if (isMultiResponse) {
            return Arrays.asList(gson.fromJson(response, FileScanMetaData[].class));
        } else {
            List<FileScanMetaData> list = new ArrayList<>();
            list.add(gson.fromJson(response, FileScanMetaData.class));
            return list;
        }
    }

    public List<URLScanMetaData> urlsScanMetadata(String response, boolean isMultiResponse) {
        if (isMultiResponse) {
            return Arrays.asList(gson.fromJson(response, URLScanMetaData[].class));
        } else {
            List<URLScanMetaData> list = new ArrayList<>();
            list.add(gson.fromJson(response, URLScanMetaData.class));
            return list;
        }
    }

    public List<FileScanReport> parseFileReports(String response, boolean isMultiResponse) {
        if (isMultiResponse) {
            return Arrays.asList(gson.fromJson(response, FileScanReport[].class));
        } else {
            List<FileScanReport> list = new ArrayList<>();
            list.add(gson.fromJson(response, FileScanReport.class));
            return list;
        }
    }

    public List<URLScanReport> parseURLReports(String response, boolean isMultiresponse) {
        if (isMultiresponse) {
            return Arrays.asList(gson.fromJson(response, URLScanReport[].class));
        } else {
            List<URLScanReport> list = new ArrayList<>();
            list.add(gson.fromJson(response, URLScanReport.class));
            return list;
        }
    }

    public IPAddressReport parseIPAddressReport(String response) {
        return gson.fromJson(response, IPAddressReport.class);
    }

    public DomainReport parseDomainReport(String response) {
        return gson.fromJson(response, DomainReport.class);
    }
}
