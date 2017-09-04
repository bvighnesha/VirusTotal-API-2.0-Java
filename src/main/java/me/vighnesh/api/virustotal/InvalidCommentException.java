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
public class InvalidCommentException extends RuntimeException {

    /**
     *
     */
    public InvalidCommentException() {
    }

    /**
     *
     * @param message
     */
    public InvalidCommentException(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public InvalidCommentException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public InvalidCommentException(String message, Throwable cause) {
        super(message, cause);
    }

}
