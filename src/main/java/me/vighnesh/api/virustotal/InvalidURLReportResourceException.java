/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal;

/**
 *
 * @author BVR
 */
public class InvalidURLReportResourceException extends InvalidReportResourceException {

    /**
     *
     */
    public InvalidURLReportResourceException() {
    }

    /**
     *
     * @param message
     */
    public InvalidURLReportResourceException(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public InvalidURLReportResourceException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public InvalidURLReportResourceException(String message, Throwable cause) {
        super(message, cause);
    }

}
