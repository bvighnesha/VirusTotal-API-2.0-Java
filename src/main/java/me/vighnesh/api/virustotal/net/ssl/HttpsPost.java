/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.net.ssl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import me.vighnesh.api.virustotal.support.MultipartEntity;

/**
 *
 * @author BVR
 */
public class HttpsPost {

    private final HttpsURLConnection connection;

    /**
     *
     * @param requestURL
     * @param entity
     * @throws MalformedURLException
     * @throws IOException
     */
    public HttpsPost(String requestURL, MultipartEntity entity) throws MalformedURLException, IOException {
        String boundary = "e2a540ab4e6c5ed79c01157c255a2b5007e157d7";
        URL url = new URL(requestURL);
        connection = (HttpsURLConnection) url.openConnection();
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        process(entity, connection);
    }

    private void process(MultipartEntity entity, HttpsURLConnection connection) {
        try (InputStream content = entity.getContent()) {
            OutputStream outputStream = connection.getOutputStream();
            byte[] buffer = new byte[1024 * 1024];
            int bytes;
            while ((bytes = content.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytes);
            }
            outputStream.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     *
     * @return
     */
    public HttpsURLConnection getConnection() {
        return connection;
    }

}
