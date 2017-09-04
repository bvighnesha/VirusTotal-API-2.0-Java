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
public class InvalidIPAddressException extends InvalidReportResourceException {

    /**
     *
     */
    public InvalidIPAddressException() {
    }

    /**
     *
     * @param message
     */
    public InvalidIPAddressException(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public InvalidIPAddressException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public InvalidIPAddressException(String message, Throwable cause) {
        super(message, cause);
    }

}
