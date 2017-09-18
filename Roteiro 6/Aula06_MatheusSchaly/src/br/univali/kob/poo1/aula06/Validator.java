/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.aula06;

/**
 * Base for validators hierarchy. In this version, was implmented 
 * only the default behavior to verify is a value is null
 * 
 * @author Matheus Schaly
 */
public class Validator {
    
    /**
     * Verifies if a value is null.
     * 
     * @param value the value to be validated
     * @param valueLabel the text reference to the value that will be used in the excpetion
     * 
     * @throws NullPointerException if the value is null
     */
    public final void notNull(Object value, String valueLabel) {
        if (value == null) {
            throw new NullPointerException(valueLabel + " cannot be null");
        }
    }
    
    
}
