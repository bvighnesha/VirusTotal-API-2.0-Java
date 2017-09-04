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
public class InvalidReportResourceException extends InvalidResourceEception {

    /**
     *
     */
    public InvalidReportResourceException() {
    }

    /**
     *
     * @param message
     */
    public InvalidReportResourceException(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public InvalidReportResourceException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public InvalidReportResourceException(String message, Throwable cause) {
        super(message, cause);
    }

}
