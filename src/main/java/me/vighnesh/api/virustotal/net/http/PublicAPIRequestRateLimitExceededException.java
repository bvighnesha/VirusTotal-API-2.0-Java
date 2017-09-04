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
public class PublicAPIRequestRateLimitExceededException extends RuntimeException {

    /**
     *
     */
    public PublicAPIRequestRateLimitExceededException() {
        super("you exceed the public API request rate limit");
    }

    /**
     *
     * @param message
     */
    public PublicAPIRequestRateLimitExceededException(String message) {
        super(message);
    }

    /**
     *
     * @param cause
     */
    public PublicAPIRequestRateLimitExceededException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public PublicAPIRequestRateLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }

}
