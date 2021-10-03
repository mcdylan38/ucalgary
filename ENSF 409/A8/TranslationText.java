/**
 * ENSF 409 - Assignment 8
 * Dylan Mah (30086580)
 * Version: 1.0
 * Since: 1.0
 */

package edu.ucalgary.ensf409;

import java.io.Serializable;

/* TranslationText
 * Serializable representation of the data file. Has the serialVersionUID of 19.
 * No method in this class throws an exception.
 */
public class TranslationText implements Serializable {
    private final String sentence;
    private final String[] months;
    private final String[] days;
    static final long serialVersionUID=19;

    /* Constructor
     * Accepts a String array of months, a String array of days, and a String
     * containing a sentence with formatting.
     */
    TranslationText(String[] months, String[] days, String sentence){
        this.months=months;
        this.days=days;
        this.sentence=sentence;
    }

    public String getSentence(){
        return this.sentence;
    }

    public String[] getMonths(){
        return this.months;
    }

    public String[] getDays(){
        return this.days;
    }

    /* getMonth()
     * Accepts an integer 0-11 corresponding to an index in the months array,
     * and returns the value at that index.
     */
    public String getMonth(int index){
        return this.months[index];
    }

    /* getDay()
     * Accepts an integer 0-30 corresponding to an index in the day array,
     * and returns the value at that index.
     */
    public String getDay(int index){
        return this.days[index];
    }
}
