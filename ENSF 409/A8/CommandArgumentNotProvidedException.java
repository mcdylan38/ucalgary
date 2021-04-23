/**
 * ENSF 409 - Assignment 7
 * Dylan Mah (30086580)
 * Version: 1.0
 * Since: 1.0
 */

package edu.ucalgary.ensf409;

/**
 * Class for a custom exception that is thrown if no command line arguments are given
 */
public class CommandArgumentNotProvidedException extends Exception{
    public CommandArgumentNotProvidedException(){
        super("Must include valid command line argument");
    }
}
