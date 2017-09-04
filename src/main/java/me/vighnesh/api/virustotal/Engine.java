package me.vighnesh.api.virustotal;

/**
 *
 * @author BVR vigneshb1210@gmail.com
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;
import static java.util.Objects.isNull;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import me.vighnesh.api.virustotal.dao.CommentStatus;
import me.vighnesh.api.virustotal.dao.DomainReport;
import me.vighnesh.api.virustotal.dao.FileScanMetaData;
import me.vighnesh.api.virustotal.dao.FileScanReport;
import me.vighnesh.api.virustotal.dao.IPAddressReport;
import me.vighnesh.api.virustotal.dao.URLScanMetaData;
import me.vighnesh.api.virustotal.dao.URLScanReport;
import me.vighnesh.api.virustotal.json.Response;
import me.vighnesh.api.virustotal.net.http.HttpClient;
import static me.vighnesh.api.virustotal.net.http.util.HttpUtility.prepareParameters;
import me.vighnesh.api.virustotal.net.ssl.HttpsGet;
import me.vighnesh.api.virustotal.net.ssl.HttpsPost;
import me.vighnesh.api.virustotal.support.MultipartEntity;

class Engine {

    private static final String FILE_SCAN_URL = "https://www.virustotal.com/vtapi/v2/file/scan";
    private static final String FILE_REPORT_URL = "https://www.virustotal.com/vtapi/v2/file/report";
    private static final String FILE_RE_SCAN_URL = "https://www.virustotal.com/vtapi/v2/file/rescan";
    private static final String URL_SCAN_URL = "https://www.virustotal.com/vtapi/v2/url/scan";
    private static final String URL_REPORT_URL = "https://www.virustotal.com/vtapi/v2/url/report";
    private static final String IP_ADDRESS_REPORT_URL = "https://www.virustotal.com/vtapi/v2/ip-address/report";
    private static final String DOMAIN_REPORT_URL = "https://www.virustotal.com/vtapi/v2/domain/report";
    private static final String COMMENT_URL = "https://www.virustotal.com/vtapi/v2/comments/put";

    static Engine configure(String apikey) {
        return new Engine(apikey);
    }

    private final String apikey;
    private final HttpClient httpClient = new HttpClient();
    private final Response responseGson = new Response();

    private Engine(String apikey) {
        this.apikey = apikey;
    }

    CommentStatus comment(String resource, String comment) {
        if (isNull(resource) || resource.isEmpty()) {
            throw new InvalidResourceEception("A valid resource is required");
        }
        if (!isNull(comment) && !comment.isEmpty()) {
            MultipartEntity multipartEntity = new MultipartEntity();
            multipartEntity.addHeader("Transfer-Encoding", "chunked");
            multipartEntity.addTextBody("apikey", apikey);
            multipartEntity.addTextBody("comment", comment);
            multipartEntity.addTextBody("resource", resource);
            try {
                HttpsPost httpsPost = new HttpsPost(COMMENT_URL, multipartEntity);
                String response = httpClient.execute(httpsPost);
                return responseGson.parseCommentStatus(response);
            } catch (IOException ie) {
                throw new RuntimeException(ie);
            }
        } else {
            throw new InvalidCommentException("Comment should be non-null and non-empty");
        }
    }

    FileScanMetaData scanFile(File file) throws FileNotFoundException, IOException {
        if (!isNull(file) && file.canExecute()) {
            String fileName = file.getName();
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                return scanFile(fileName, fileInputStream);
            }
        } else {
            throw new InvalidFileException("A valid java.io.File is required");
        }
    }

    FileScanMetaData scanFile(String fileName, FileInputStream inputStream) throws IOException {
        if (isNull(fileName) || fileName.isEmpty()) {
            throw new InvalidFileNameException("valid file name is required");
        } else {
        }
        if (!isNull(inputStream)) {
            MultipartEntity multipartEntity = new MultipartEntity();
            multipartEntity.addHeader("Transfer-Encoding", "chunked");
            multipartEntity.addTextBody("apikey", apikey);
            multipartEntity.addBinaryBody("file", fileName, inputStream);
            HttpsPost httpsPost = new HttpsPost(FILE_SCAN_URL, multipartEntity);
            String response = httpClient.execute(httpsPost);
            return responseGson.parseFileScanMetadata(response, false).get(0);
        } else {
            throw new InvalidFileInputStreamException("valid java.io.FileInputStream is required");
        }
    }

    FileScanMetaData reScanFile(String resource) {
        if (!isNull(resource) && !resource.isEmpty()) {
            String response = getReports("resource", resource, FILE_RE_SCAN_URL, true, false);
            return responseGson.parseFileScanMetadata(response, false).get(0);
        } else {
            throw new InvalidResourceEception("A valid resource is required");
        }
    }

    List<FileScanMetaData> reScanFiles(String[] resources) {
        if (!isNull(resources) && resources.length > 0) {
            String resourceString = Arrays.toString(resources);
            String resource = resourceString.substring(1, resourceString.length() - 1);
            String response = getReports("resource", resource, FILE_RE_SCAN_URL, true, false);
            if (resources.length > 1) {
                return responseGson.parseFileScanMetadata(response, true);
            } else {
                return responseGson.parseFileScanMetadata(response, false);
            }
        } else {
            throw new InvalidResourceEception("atleast one resource is required");
        }
    }

    private String scanURLs(String urls) {
        MultipartEntity multipartEntity = new MultipartEntity();
        multipartEntity.addHeader("Transfer-Encoding", "chunked");
        multipartEntity.addTextBody("apikey", apikey);
        multipartEntity.addTextBody("url", urls);
        try {
            HttpsPost https = new HttpsPost(URL_SCAN_URL, multipartEntity);
            String response = httpClient.execute(https);
            return response;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    URLScanMetaData scanURL(java.net.URL url) throws InvalidURLException, IOException {
        String urlString = url.toString();
        if (!isNull(url) && !urlString.isEmpty()) {
            String response = scanURLs(urlString);
            return responseGson.urlsScanMetadata(response, false).get(0);
        } else {
            throw new InvalidURLException("Invalid URL");
        }
    }

    List<URLScanMetaData> scanURLs(java.net.URL[] urls) throws InvalidURLException {
        if (!isNull(urls) && urls.length > 0) {
            String urlsString = Arrays.toString(urls);
            String urls1 = urlsString.substring(1, urlsString.length() - 1);
            if (urls.length > 1) {
                String urls2 = urls1.replaceAll(",", "\r\n");
                String response = scanURLs(urls2);
                return responseGson.urlsScanMetadata(response, true);
            } else {
                String response = scanURLs(urls1);
                return responseGson.urlsScanMetadata(response, false);
            }
        } else {
            throw new InvalidURLException("Invalid URL");
        }
    }

    private String getReports(String type, String resource, String reportURL, boolean isPost, boolean doURLScan) {
        MultipartEntity multipartEntity = new MultipartEntity();
        multipartEntity.addHeader("Transfer-Encoding", "chunked");
        if (isPost) {
            multipartEntity.addTextBody("apikey", apikey);
            multipartEntity.addTextBody(type, resource);
            if (doURLScan) {
                multipartEntity.addTextBody("scan", "1");
            }
            try {
                HttpsPost httpsPost = new HttpsPost(reportURL, multipartEntity);
                return httpClient.execute(httpsPost);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            ConcurrentHashMap parameters = new ConcurrentHashMap();
            parameters.put("apikey", apikey);
            parameters.put(type, resource);
            try {
                HttpsGet httpsGet = new HttpsGet(reportURL, prepareParameters(parameters));
                return httpClient.execute(httpsGet);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    FileScanReport getFileReport(String resource) {
        if (!isNull(resource) && !resource.isEmpty()) {
            String response = getReports("resource", resource, FILE_REPORT_URL, true, false);
            return responseGson.parseFileReports(response, false).get(0);
        } else {
            throw new InvalidFileReportResourceException("valid file report resource is required");
        }
    }

    List<FileScanReport> getFilesReport(String[] resources) {
        if (!isNull(resources) && resources.length > 0) {
            String resourceString = Arrays.toString(resources);
            String resource = resourceString.substring(1, resourceString.length() - 1);
            String response = getReports("resource", resource, FILE_REPORT_URL, true, false);
            if (resources.length > 1) {
                return responseGson.parseFileReports(response, true);
            } else {
                return responseGson.parseFileReports(response, false);
            }
        } else {
            throw new InvalidFileReportResourceException("valid file report resource is required");
        }
    }

    URLScanReport getURLReport(java.net.URL url) {
        if (!isNull(url) && !url.toString().isEmpty()) {
            String resource = url.toString();
            String response = getReports("resource", resource, URL_REPORT_URL, true, false);
            return responseGson.parseURLReports(response, false).get(0);
        } else {
            throw new InvalidURLReportResourceException("Invalid URL");
        }
    }

    URLScanReport getURLReport(java.net.URL url, boolean scan) {
        if (!isNull(url) && !url.toString().isEmpty()) {
            String resource = url.toString();
            String response = getReports("resource", resource, URL_REPORT_URL, true, scan);
            return responseGson.parseURLReports(response, false).get(0);
        } else {
            throw new InvalidURLReportResourceException("Invalid URL");
        }
    }

    List<URLScanReport> getURLsReport(java.net.URL[] urls) {
        if (!isNull(urls) && urls.length > 0) {
            String resourceString = Arrays.toString(urls);
            String resource = resourceString.substring(1, resourceString.length() - 1);
            if (urls.length > 1) {
                String resources = resource.replaceAll(",", "\r\n");
                String response = getReports("resource", resources, URL_REPORT_URL, true, false);
                return responseGson.parseURLReports(response, true);
            } else {
                String response = getReports("resource", resource, URL_REPORT_URL, true, false);
                return responseGson.parseURLReports(response, false);
            }
        } else {
            throw new InvalidURLReportResourceException("Invalid URLs");
        }
    }

    List<URLScanReport> getURLsReport(java.net.URL[] urls, boolean scan) {
        if (!isNull(urls) && urls.length > 0) {
            String resourceString = Arrays.toString(urls);
            String resource = resourceString.substring(1, resourceString.length() - 1);
            if (urls.length > 1) {
                String resources = resource.replaceAll(",", "\r\n");
                String response = getReports("resource", resources, URL_REPORT_URL, true, scan);
                return responseGson.parseURLReports(response, true);
            } else {
                String response = getReports("resource", resource, URL_REPORT_URL, true, scan);
                return responseGson.parseURLReports(response, false);
            }
        } else {
            throw new InvalidURLReportResourceException("Invalid URLs");
        }
    }

    URLScanReport getURLReport(String scanId) {
        if (!isNull(scanId) && !scanId.isEmpty()) {
            String response = getReports("resource", scanId, URL_REPORT_URL, true, false);
            return responseGson.parseURLReports(response, false).get(0);
        } else {
            throw new InvalidURLReportResourceException("Invalid URL");
        }
    }

    URLScanReport getURLReport(String scanId, boolean scan) {
        if (!isNull(scanId) && !scanId.isEmpty()) {
            String response = getReports("resource", scanId, URL_REPORT_URL, true, scan);
            return responseGson.parseURLReports(response, false).get(0);
        } else {
            throw new InvalidURLReportResourceException("Invalid URL");
        }
    }

    List<URLScanReport> getURLsReport(String[] scanIds, boolean scan) {
        if (!isNull(scanIds) && scanIds.length > 0) {
            String resourceString = Arrays.toString(scanIds);
            String resources = resourceString.substring(1, resourceString.length() - 1);
            if (scanIds.length > 1) {
                String response = getReports("resource", resources, URL_REPORT_URL, true, scan);
                return responseGson.parseURLReports(response, true);
            } else {
                String response = getReports("resource", resources, URL_REPORT_URL, true, scan);
                return responseGson.parseURLReports(response, false);
            }
        } else {
            throw new InvalidURLReportResourceException("Invalid URLs");
        }
    }

    IPAddressReport getIPAddressReport(Inet4Address ipAddress) {
        if (!isNull(ipAddress) && !ipAddress.getHostAddress().isEmpty()) {
            String ip = ipAddress.getHostAddress();
            String response = getReports("ip", ip, IP_ADDRESS_REPORT_URL, false, false);
            return responseGson.parseIPAddressReport(response);
        } else {
            throw new InvalidIPAddressException("Invalid ip address");
        }
    }

    DomainReport getDomainReport(String domain) {
        if (!isNull(domain) && !domain.isEmpty()) {
            String response = getReports("domain", domain, DOMAIN_REPORT_URL, false, false);
            return responseGson.parseDomainReport(response);
        } else {
            throw new InvalidDomainException("Invalid Domain");
        }
    }
    private static final Logger LOG = Logger.getLogger(Engine.class.getName());

}
