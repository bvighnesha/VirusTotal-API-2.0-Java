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
public class InvalidFileNameException extends InvalidFileException {

    /**
     *
     */
    public InvalidFileNameException() {
    }

    /**
     *
     * @param message
     */
    public InvalidFileNameException(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public InvalidFileNameException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public InvalidFileNameException(String message, Throwable cause) {
        super(message, cause);
    }

}
