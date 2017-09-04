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
public class NoSuchAPIKeyException extends RuntimeException {

    /**
     *
     */
    public NoSuchAPIKeyException() {
    }

    /**
     *
     * @param message
     */
    public NoSuchAPIKeyException(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public NoSuchAPIKeyException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public NoSuchAPIKeyException(String message, Throwable cause) {
        super(message, cause);
    }

}
