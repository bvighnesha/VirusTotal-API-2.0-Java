/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.dao;

import com.google.gson.annotations.SerializedName;
import static java.lang.System.arraycopy;

/**
 *
 * @author BVR
 */
public class DomainReport {

    @SerializedName("undetected_downloaded_samples")
    private Sample[] undetectedDownloadedSamples;
    @SerializedName("detected_downloaded_samples")
    private Sample[] detectedDownloadedSamples;
    @SerializedName("resolutions")
    private DomainResolution[] resolutions;
    @SerializedName("detected_communicating_samples")
    private Sample[] detectedCommunicatingSamples;
    @SerializedName("undetected_communicating_samples")
    private Sample[] undetectedCommunicatingSamples;
    @SerializedName("detected_urls")
    private URL[] detectedUrls;
    @SerializedName("response_code")
    private int responseCode;
    @SerializedName("verbose_msg")
    private String verboseMessage;

    /**
     *
     * @return
     */
    public Sample[] getUndetectedDownloadedSamples() {
        return undetectedDownloadedSamples.clone();
    }

    /**
     *
     * @param undetectedDownloadedSamples
     */
    public void setUndetectedDownloadedSamples(Sample[] undetectedDownloadedSamples) {
        arraycopy(undetectedDownloadedSamples, 0, this.undetectedCommunicatingSamples, 0, undetectedDownloadedSamples.length);
    }

    /**
     *
     * @return
     */
    public Sample[] getDetectedDownloadedSamples() {
        return detectedDownloadedSamples.clone();
    }

    /**
     *
     * @param detectedDownloadedSamples
     */
    public void setDetectedDownloadedSamples(Sample[] detectedDownloadedSamples) {
        arraycopy(detectedDownloadedSamples, 0, this.detectedDownloadedSamples, 0, detectedDownloadedSamples.length);
    }

    /**
     *
     * @return
     */
    public DomainResolution[] getResolutions() {
        return resolutions.clone();
    }

    /**
     *
     * @param resolutions
     */
    public void setResolutions(DomainResolution[] resolutions) {
        arraycopy(resolutions, 0, this.resolutions, 0, resolutions.length);
    }

    /**
     *
     * @return
     */
    public Sample[] getDetectedCommunicatingSamples() {
        return detectedCommunicatingSamples.clone();
    }

    /**
     *
     * @param detectedCommunicatingSamples
     */
    public void setDetectedCommunicatingSamples(Sample[] detectedCommunicatingSamples) {
        arraycopy(detectedCommunicatingSamples, 0, this.detectedCommunicatingSamples, 0, detectedCommunicatingSamples.length);
    }

    /**
     *
     * @return
     */
    public Sample[] getUndetectedCommunicatingSamples() {
        return undetectedCommunicatingSamples.clone();
    }

    /**
     *
     * @param undetectedCommunicatingSamples
     */
    public void setUndetectedCommunicatingSamples(Sample[] undetectedCommunicatingSamples) {
        arraycopy(undetectedCommunicatingSamples, 0, this.undetectedCommunicatingSamples, 0, undetectedCommunicatingSamples.length);
    }

    /**
     *
     * @return
     */
    public URL[] getDetectedUrls() {
        return detectedUrls.clone();
    }

    /**
     *
     * @param detectedUrls
     */
    public void setDetectedUrls(URL[] detectedUrls) {
        arraycopy(detectedUrls, 0, this.detectedUrls, 0, detectedUrls.length);
    }

    /**
     *
     * @return
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     *
     * @param responseCode
     */
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    /**
     *
     * @return
     */
    public String getVerboseMessage() {
        return verboseMessage;
    }

    /**
     *
     * @param verboseMessage
     */
    public void setVerboseMessage(String verboseMessage) {
        this.verboseMessage = verboseMessage;
    }
}
