package me.vighnesh.api.virustotal.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author BVR
 */
public class CommentStatus {

    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("verbose_msg")
    @Expose
    private String verboseMsg;

    /**
     *
     * @return
     */
    public Integer getResponseCode() {
        return responseCode;
    }

    /**
     *
     * @param responseCode
     */
    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    /**
     *
     * @return
     */
    public String getVerboseMsg() {
        return verboseMsg;
    }

    /**
     *
     * @param verboseMsg
     */
    public void setVerboseMsg(String verboseMsg) {
        this.verboseMsg = verboseMsg;
    }

}
