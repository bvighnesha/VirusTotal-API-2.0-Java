/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vighnesh.api.virustotal;

import java.net.MalformedURLException;

/**
 *
 * @author BVR
 */
public class InvalidURLException extends MalformedURLException {

    /**
     *
     */
    public InvalidURLException() {
    }

    /**
     *
     * @param msg
     */
    public InvalidURLException(String msg) {
        super(msg);
    }

}
