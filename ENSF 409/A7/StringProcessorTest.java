package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringProcessorTest {
    private StringProcessor sp1=new StringProcessor("Dylan");
    private StringProcessor sp2=new StringProcessor("ZABE");
    private StringProcessor sp3=new StringProcessor("ABCxyz");

    @Test
    public void addTogetherMirror1() {
        String toTest=sp1.addTogetherMirror("Mah");
        assertEquals("hamnalyd", toTest);
    }

    @Test
    public void addTogetherMirror2() {
        String toTest=sp2.addTogetherMirror("OFF");
        assertEquals("ffoebaz", toTest);
    }

    @Test
    public void idProcessing1() {
        String toTest=StringProcessor.idProcessing("Dylan", "Mah","Pedro", 2019);
        assertEquals("DMP2019", toTest);
    }

    @Test
    public void idProcessing2() {
        String toTest=StringProcessor.idProcessing("Peter", "O'Reilly", "Snake", 2009);
        assertEquals("POS2009", toTest);
    }

    @Test
    public void idProcessing3() {
        String toTest=StringProcessor.idProcessing("Phil", "Smith-Johnson", "Garang", 2010);
        assertEquals("PSG2010", toTest);
    }

    @Test
    public void idProcessing4() {
        String toTest=StringProcessor.idProcessing("Alan", "Io Po", "Line", 2015);
        assertEquals("AIL2015", toTest);
    }

    @Test
    public void idProcessing5() {
        // This test should fail (first name doesn't start with a capital)

        String toTest=StringProcessor.idProcessing("mom", "DAD", "PUP", 2020);
        assertEquals("MDP2020", toTest);
    }

    @Test
    public void idProcessing6() {
        // This test should fail (Pet name too short)

        String toTest=StringProcessor.idProcessing("Ben", "Dover", "G", 2020);
        assertEquals("BDG2020", toTest);
    }

    @Test
    public void idProcessing7() {
        // This test should fail (Pet name has invalid character)

        String toTest=StringProcessor.idProcessing("Barry", "Bongo", "PIPE!!!", 1990);
        assertEquals("BBP1990", toTest);
    }

    @Test
    public void idProcessing8() {
        String toTest=StringProcessor.idProcessing("Pants", "P.P-P'P P", "POGGERS", 1001);
        assertEquals("PPP1001", toTest);
    }

    @Test
    public void idProcessing9() {
        // This test should fail (Too many punctuations)

        String toTest=StringProcessor.idProcessing("My", "Boi", "LEE--ROY", 2000);
        assertEquals("MBL2000", toTest);
    }

    @Test
    public void secretCode1() {
        String toTest=sp1.secretCode(1);
        assertEquals("Ezmbo", toTest);
    }

    @Test
    public void secretCode2() {
        String toTest=sp2.secretCode(3);
        assertEquals("CDEH", toTest);
    }

    @Test
    public void secretCode3() {
        String toTest=sp3.secretCode(4);
        assertEquals("EFGbcd", toTest);
    }
}

// javac edu/ucalgary/ensf409/StringProcessor.java
// javac -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar edu/ucalgary/ensf409/StringProcessorTest.java
// java -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.StringProcessorTest