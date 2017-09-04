package me.vighnesh.api.virustotal.support;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author BVR
 */
public class MultipartEntity {

    private final static String boundary = "e2a540ab4e6c5ed79c01157c255a2b5007e157d7";
    private static final String LINE_FEED = "\r\n";
    private static final String charset = "UTF-8";
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintWriter writer;

    /**
     *
     */
    public MultipartEntity() {
        try {
            this.writer = new PrintWriter(new OutputStreamWriter(outputStream, charset), true);
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException();
        }
    }

    /**
     *
     * @param name
     * @param value
     */
    public void addHeader(String name, String value) {
        writer.append(name + ": " + value).append(LINE_FEED);
        writer.flush();
    }

    /**
     *
     * @param type
     * @param value
     */
    public void addTextBody(String type, String value) {
        writer.append("--" + boundary).append(LINE_FEED);
        writer.append("Content-Disposition: form-data; name=\"" + type + "\"")
                .append(LINE_FEED);
        writer.append("Content-Type: text/plain; charset=" + charset).append(
                LINE_FEED);
        writer.append(LINE_FEED);
        writer.append(value).append(LINE_FEED);
        writer.flush();
    }

    /**
     *
     * @param type
     * @param fileName
     * @param inputStream
     * @throws IOException
     */
    public void addBinaryBody(String type, String fileName, FileInputStream inputStream)
            throws IOException {

        writer.append("--" + boundary).append(LINE_FEED);
        writer.append("Content-Disposition: form-data; name=\"" + type + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
        writer.append("Content-Type: application/octet-stream").append(LINE_FEED);
        writer.append("Content-Transfer-Encoding: chunked").append(LINE_FEED);
        writer.append(LINE_FEED);
        writer.flush();

        byte[] buffer = new byte[1024 * 1024];
        int bytes;
        while ((bytes = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytes);
        }
        outputStream.flush();
        writer.flush();
    }

    /**
     *
     * @param type
     * @param file
     * @throws IOException
     */
    public void addBinaryBody(String type, File file)
            throws IOException {
        String fileName = file.getName();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            addBinaryBody(type, fileName, fileInputStream);
        }
    }

    /**
     *
     * @return @throws IOException
     */
    public InputStream getContent() throws IOException {
        writer.append(LINE_FEED).flush();
        writer.append("--" + boundary + "--").append(LINE_FEED);
        writer.close();

        outputStream.flush();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        outputStream.close();
        return inputStream;
    }
}
