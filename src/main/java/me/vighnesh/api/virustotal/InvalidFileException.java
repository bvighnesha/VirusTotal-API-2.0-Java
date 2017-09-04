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
public class InvalidFileException extends RuntimeException {

    /**
     *
     */
    public InvalidFileException() {
    }

    /**
     *
     * @param message
     */
    public InvalidFileException(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public InvalidFileException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public InvalidFileException(String message, Throwable cause) {
        super(message, cause);
    }

}
