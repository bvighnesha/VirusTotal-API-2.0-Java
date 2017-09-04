/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal.net.http;

/**
 *
 * @author BVR
 */
public class ForbiddenException extends RuntimeException {

    /**
     *
     */
    public ForbiddenException() {
        super("you do not have the required privileges");
    }

    /**
     *
     * @param message
     */
    public ForbiddenException(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public ForbiddenException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

}
