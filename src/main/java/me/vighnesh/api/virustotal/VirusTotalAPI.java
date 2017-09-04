/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Inet4Address;
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
 * @author BVR vigneshb1210@gmail.com
 */
public interface VirusTotalAPI {

    /**
     *
     * @param apikey
     * @return
     */
    public static VirusTotalAPI configure(String apikey) {
        return VirusTotal.configure(apikey);
    }

    /**
     *
     * @param resource
     * @param comment
     * @return
     */
    public CommentStatus comment(String resource, String comment);

    /**
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public FileScanMetaData scanFile(File file) throws FileNotFoundException, IOException;

    /**
     *
     * @param fileName
     * @param inputStream
     * @return
     * @throws IOException
     */
    public FileScanMetaData scanFile(String fileName, FileInputStream inputStream) throws IOException;

    /**
     *
     * @param resource
     * @return
     */
    public FileScanMetaData reScanFile(String resource);

    /**
     *
     * @param resources
     * @return
     */
    public List<FileScanMetaData> reScanFiles(String[] resources);

    /**
     *
     * @param url
     * @return
     * @throws InvalidURLException
     * @throws IOException
     */
    public URLScanMetaData scanURL(java.net.URL url) throws InvalidURLException, IOException;

    /**
     *
     * @param urls
     * @return
     * @throws InvalidURLException
     */
    public List<URLScanMetaData> scanURLs(java.net.URL[] urls) throws InvalidURLException;

    /**
     *
     * @param resource
     * @return
     */
    public FileScanReport getFileReport(String resource);

    /**
     *
     * @param resources
     * @return
     */
    public List<FileScanReport> getFilesReport(String[] resources);

    /**
     *
     * @param url
     * @return
     */
    public URLScanReport getURLReport(java.net.URL url);

    /**
     *
     * @param url
     * @param scan
     * @return
     */
    public URLScanReport getURLReport(java.net.URL url, boolean scan);

    /**
     *
     * @param urls
     * @return
     */
    public List<URLScanReport> getURLsReport(java.net.URL[] urls);

    /**
     *
     * @param urls
     * @param scan
     * @return
     */
    public List<URLScanReport> getURLsReport(java.net.URL[] urls, boolean scan);

    /**
     *
     * @param scanId
     * @return
     */
    public URLScanReport getURLReport(String scanId);

    /**
     *
     * @param scanId
     * @param scan
     * @return
     */
    public URLScanReport getURLReport(String scanId, boolean scan);

    /**
     *
     * @param scanIds
     * @param scan
     * @return
     */
    public List<URLScanReport> getURLsReport(String[] scanIds, boolean scan);

    /**
     *
     * @param ipAddress
     * @return
     */
    public IPAddressReport getIPAddressReport(Inet4Address ipAddress);

    /**
     *
     * @param domain
     * @return
     */
    public DomainReport getDomainReport(String domain);

}
