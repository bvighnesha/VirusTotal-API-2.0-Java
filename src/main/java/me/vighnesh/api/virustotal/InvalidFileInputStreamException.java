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
public class InvalidFileInputStreamException extends InvalidFileException {

    /**
     *
     */
    public InvalidFileInputStreamException() {
    }

    /**
     *
     * @param message
     */
    public InvalidFileInputStreamException(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public InvalidFileInputStreamException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public InvalidFileInputStreamException(String message, Throwable cause) {
        super(message, cause);
    }

}
