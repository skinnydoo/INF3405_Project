/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_inf3405;

import java.util.regex.Pattern;

/**
 *
 * @author Simel
 */
public interface InputValidator {
    
    /**
     *
     */
    String IPREGEX = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + 
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + 
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + 
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    
    /**
     *
     */
    Pattern IP_PATTERN = Pattern.compile(IPREGEX);    
    
    void validatePortNumber();
    void checkFieldsFull();    
    
    /**
     * Validate IP address with regular expression
     * @param ip IP address to validate
     * @return true if IP is valid, false otherwise
     */
    default boolean validateIP(String ip) {
        
        return IP_PATTERN.matcher(ip).matches();
    }
    
    

}
