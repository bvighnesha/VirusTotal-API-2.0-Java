/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.net.http.util;

import java.io.UnsupportedEncodingException;
import static java.net.URLEncoder.encode;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/**
 *
 * @author BVR
 */
public class HttpUtility {

    /**
     *
     * @param parameters
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String prepareParameters(ConcurrentMap<String, String> parameters) throws UnsupportedEncodingException {
        StringBuilder requestParameters = new StringBuilder();
        Iterator<Map.Entry<String, String>> parameterIterator = parameters.entrySet().iterator();
        while (parameterIterator.hasNext()) {
            Map.Entry<String, String> parameter = parameterIterator.next();
            requestParameters.append(encode(parameter.getKey(), "UTF-8"));
            requestParameters.append("=").append(encode(parameter.getValue(), "UTF-8"));
            requestParameters.append("&");
        }
        requestParameters.deleteCharAt(requestParameters.lastIndexOf("&"));
        return requestParameters.toString();

    }

    private HttpUtility() {
    }
    private static final Logger LOG = Logger.getLogger(HttpUtility.class.getName());
}
