/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exception;

/**
 *
 * @author kanishk
 */
public class FlightException extends Exception {
   
    public FlightException(String message)
    {
        super(message);
        
    }
    
    public FlightException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
