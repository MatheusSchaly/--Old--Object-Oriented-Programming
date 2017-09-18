/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.aula06;

import java.time.format.DateTimeFormatter;

/**
 * Generic class to validate comparable data.
 *
 * @author Matheus Schaly
 * 
 * @param <Type> any class that implements Comparable
 */
public class ComparableValidator<Type extends Comparable> extends Validator {
    
    private static DateTimeFormatter dateFormat;
    
    public ComparableValidator() {
        dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    
    public ComparableValidator(DateTimeFormatter format) {
        dateFormat = format;
    }
    
    /**
     * Verifies if a value Comparable is within a specific range.
     * 
     * @param value the value to be validated
     * @param valueLabel the text reference to the value that will be used in the exception
     * @param min the minimum value to the range (inclusive)
     * @param max the maximum value to the range (inclusive)
     * 
     * @throws NullPointerException if the value is null
     * @throws IllegalArgumentException if the value is outside the range
     */
    public final void range(Type value, String valueLabel, Type min, Type max) {
        notNull(value, valueLabel);
        if (value.compareTo(min) == -1 || value.compareTo(max) == 1) {
            throw new OutOfRangeException(value.toString(),
                    value.getClass().getSimpleName() + "." + valueLabel, min.toString(), max.toString());
        }
    }
    
    
    
}
