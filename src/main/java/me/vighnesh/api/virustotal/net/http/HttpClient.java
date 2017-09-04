/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.net.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static java.net.HttpURLConnection.HTTP_NO_CONTENT;
import static java.net.HttpURLConnection.HTTP_OK;
import javax.net.ssl.HttpsURLConnection;
import me.vighnesh.api.virustotal.net.ssl.HttpsGet;
import me.vighnesh.api.virustotal.net.ssl.HttpsPost;

/**
 *
 * @author BVR
 */
public class HttpClient {

    /**
     *
     * @param httpPost
     * @return
     * @throws IOException
     */
    public String execute(HttpsPost httpPost) throws IOException {
        HttpsURLConnection connection = httpPost.getConnection();
        return execute(connection);
    }

    /**
     *
     * @param httpsGet
     * @return
     * @throws IOException
     */
    public String execute(HttpsGet httpsGet) throws IOException {
        HttpsURLConnection connection = httpsGet.getConnection();
        return execute(connection);
    }

    private String execute(HttpsURLConnection connection) throws IOException {
        int status = connection.getResponseCode();
        if (status == HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "UTF-8"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }
            connection.disconnect();
            return response.toString();
        } else {
            if (status == HTTP_NO_CONTENT) {
                throw new PublicAPIRequestRateLimitExceededException();
            } else if (status == HTTP_FORBIDDEN) {
                throw new ForbiddenException();
            } else {
                throw new RuntimeException();
            }
        }
    }
}
