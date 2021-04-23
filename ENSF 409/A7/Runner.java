package edu.ucalgary.ensf409;

public class Runner{
    // Executing code from StringProcessor.java
    public static void main(String[] args){
        StringProcessor sp1=new StringProcessor("Dylan");
        StringProcessor sp2=new StringProcessor("ZABE");
        StringProcessor sp3=new StringProcessor("ABCxyz");
        StringProcessor sp4=new StringProcessor("A44zp");

        System.out.println(sp1.secretCode(1));
        System.out.println(sp2.secretCode(3));
        System.out.println(sp3.secretCode(7));
        System.out.println(sp3.secretCode(26));
        System.out.println(sp4.secretCode(10));
    }
}

// javac edu/ucalgary/ensf409/Runner.java
// java edu/ucalgary/ensf409/Runner