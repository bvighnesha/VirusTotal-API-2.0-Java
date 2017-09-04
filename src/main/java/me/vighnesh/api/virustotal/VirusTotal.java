package me.vighnesh.api.virustotal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.List;
import static java.util.Objects.isNull;
import java.util.logging.Logger;
import me.vighnesh.api.virustotal.dao.CommentStatus;
import me.vighnesh.api.virustotal.dao.DomainReport;
import me.vighnesh.api.virustotal.dao.FileScanMetaData;
import me.vighnesh.api.virustotal.dao.FileScanReport;
import me.vighnesh.api.virustotal.dao.IPAddressReport;
import me.vighnesh.api.virustotal.dao.URLScanMetaData;
import me.vighnesh.api.virustotal.dao.URLScanReport;


class VirusTotal implements VirusTotalAPI {

    static VirusTotal configure(String apikey) {
        if (!isNull(apikey) && !apikey.isEmpty()) {
            return new VirusTotal(apikey);
        } else {
            throw new NoSuchAPIKeyException("Valid API key is required");
        }
    }

    private final Engine engine;

    private VirusTotal(String apikey) {
        engine = Engine.configure(apikey);
    }

    @Override
    public CommentStatus comment(String resource, String comment) {
        return engine.comment(resource, comment);
    }

    @Override
    public FileScanMetaData scanFile(File file) throws FileNotFoundException, IOException {
        return engine.scanFile(file);
    }

    @Override
    public FileScanMetaData scanFile(String fileName, FileInputStream inputStream) throws IOException {
        return engine.scanFile(fileName, inputStream);
    }

    @Override
    public FileScanMetaData reScanFile(String resource) {
        return engine.reScanFile(resource);
    }

    @Override
    public List<FileScanMetaData> reScanFiles(String[] resources) {
        return engine.reScanFiles(resources);
    }

    @Override
    public URLScanMetaData scanURL(java.net.URL url) throws InvalidURLException, IOException {
        return engine.scanURL(url);
    }

    @Override
    public List<URLScanMetaData> scanURLs(java.net.URL[] urls) throws InvalidURLException {
        return engine.scanURLs(urls);
    }

    @Override
    public FileScanReport getFileReport(String resource) {
        return engine.getFileReport(resource);
    }

    @Override
    public List<FileScanReport> getFilesReport(String[] resources) {
        return engine.getFilesReport(resources);
    }

    @Override
    public URLScanReport getURLReport(java.net.URL url) {
        return engine.getURLReport(url);
    }

    @Override
    public URLScanReport getURLReport(java.net.URL url, boolean scan) {
        return engine.getURLReport(url, scan);
    }

    @Override
    public List<URLScanReport> getURLsReport(java.net.URL[] urls) {
        return engine.getURLsReport(urls);
    }

    @Override
    public List<URLScanReport> getURLsReport(java.net.URL[] urls, boolean scan) {
        return engine.getURLsReport(urls, scan);
    }

    @Override
    public URLScanReport getURLReport(String scanId) {
        return engine.getURLReport(scanId);
    }

    @Override
    public URLScanReport getURLReport(String scanId, boolean scan) {
        return engine.getURLReport(scanId, scan);
    }

    @Override
    public List<URLScanReport> getURLsReport(String[] scanIds, boolean scan) {
        return engine.getURLsReport(scanIds, scan);
    }

    @Override
    public IPAddressReport getIPAddressReport(Inet4Address ipAddress) {
        return engine.getIPAddressReport(ipAddress);
    }

    @Override
    public DomainReport getDomainReport(String domain) {
        return engine.getDomainReport(domain);
    }
    private static final Logger LOG = Logger.getLogger(VirusTotal.class.getName());


}
