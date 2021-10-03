/**
 * ENSF 409 - Assignment 8
 * Dylan Mah (30086580)
 * Version: 1.0
 * Since: 1.0
 */

package edu.ucalgary.ensf409;

/**
 * Class for a custom exception that is thrown when the specified file cannot be found
 */
public class ArgFileNotFoundException extends Exception{
    public ArgFileNotFoundException(){
        super("Argument file not found");
    }
}
