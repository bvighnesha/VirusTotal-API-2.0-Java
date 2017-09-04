package me.vighnesh.api.virustotal.net.ssl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author BVR
 */
public class HttpsGet {

    private final HttpsURLConnection connection;

    /**
     *
     * @param requestURL
     * @param queryString
     * @throws MalformedURLException
     * @throws IOException
     */
    public HttpsGet(String requestURL, String queryString) throws MalformedURLException, IOException {
        URL url = new URL(requestURL + "?" + queryString);
        connection = (HttpsURLConnection) url.openConnection();
        connection.setUseCaches(false);
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
    }

    /**
     *
     * @return
     */
    public HttpsURLConnection getConnection() {
        return connection;
    }

}
