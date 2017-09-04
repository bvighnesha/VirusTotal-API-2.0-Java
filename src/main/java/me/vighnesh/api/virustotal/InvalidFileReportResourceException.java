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
public class InvalidFileReportResourceException extends InvalidReportResourceException {

    /**
     *
     */
    public InvalidFileReportResourceException() {
    }

    /**
     *
     * @param message
     */
    public InvalidFileReportResourceException(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public InvalidFileReportResourceException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public InvalidFileReportResourceException(String message, Throwable cause) {
        super(message, cause);
    }

}
