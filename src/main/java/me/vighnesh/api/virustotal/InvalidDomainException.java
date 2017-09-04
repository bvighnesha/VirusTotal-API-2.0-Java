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
public class InvalidDomainException extends InvalidReportResourceException{

    /**
     *
     */
    public InvalidDomainException() {
    }

    /**
     *
     * @param message
     */
    public InvalidDomainException(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public InvalidDomainException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public InvalidDomainException(String message, Throwable cause) {
        super(message, cause);
    }
   
}
