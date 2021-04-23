/**
 * ENSF 409 - Assignment 6
 * Dylan Mah (30086580)
 * Version 1.0
 * Since 1.0
 */

import java.util.ArrayList;
import java.util.regex.*;

// https://www.w3schools.com/java/java_regex.asp
// https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
// https://regex101.com

interface FormattedOutput{
    abstract String getFormatted();     // To be implemented...
}

enum Actions{
    END, ENABLE, START, TEST, DISABLE
}

enum Months{
    JAN{
        public String toString(){
            return "January";
        }

        public int toInt(){
            return 1;
        }

        public String toLog(){
            return "Jan";
        }
    },

    FEB{
        public String toString(){
            return "February";
        }

        public int toInt(){
            return 2;
        }

        public String toLog(){
            return "Feb";
        }
    },

    MAR{
        public String toString(){
            return "March";
        }

        public int toInt(){
            return 3;
        }

        public String toLog(){
            return "Mar";
        }
    },

    APR{
        public String toString(){
            return "April";
        }

        public int toInt(){
            return 4;
        }

        public String toLog(){
            return "Apr";
        }
    },

    MAY{
        public String toString(){
            return "May";
        }

        public int toInt(){
            return 5;
        }

        public String toLog(){
            return "May";
        }
    },

    JUN{
        public String toString(){
            return "June";
        }

        public int toInt(){
            return 6;
        }

        public String toLog(){
            return "Jun";
        }
    },

    JUL{
        public String toString(){
            return "July";
        }

        public int toInt(){
            return 7;
        }

        public String toLog(){
            return "Jul";
        }
    },

    AUG{
        public String toString(){
            return "August";
        }

        public int toInt(){
            return 8;
        }

        public String toLog(){
            return "Aug";
        }
    },

    SEP{
        public String toString(){
            return "September";
        }

        public int toInt(){
            return 9;
        }

        public String toLog(){
            return "Sep";
        }
    },

    OCT{
        public String toString(){
            return "October";
        }

        public int toInt(){
            return 10;
        }

        public String toLog(){
            return "Oct";
        }
    },

    NOV{
        public String toString(){
            return "November";
        }

        public int toInt(){
            return 11;
        }

        public String toLog(){
            return "Nov";
        }
    },

    DEC{
        public String toString(){
            return "December";
        }

        public int toInt(){
            return 12;
        }

        public String toLog(){
            return "Dec";
        }
    };


    public abstract String toString();      // toString prints the full name of the month
    public abstract int toInt();            // toInt converts the month to its numerical representation
    public abstract String toLog();         // toLog prints the short version of the month name
}

class IPv4 implements FormattedOutput{
    private final String IP;

    // Regex checks if String has ints between 0 and 255 and if they make the IP pattern
    private static final String REGEX="\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b(\\.\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b){3}";
    private static final Pattern PATTERN=Pattern.compile(REGEX);

    /**
     * Constructor for IPv4
     * @param ip: Value to set IP to
     */
    public IPv4(String ip){
        Matcher matcher=PATTERN.matcher(ip);

        if(!matcher.find()){
            // If match is NOT found...
            this.IP=null;
            return;                     // Return will skip the rest of the constructor
        }

        this.IP=matcher.group(0);       // Getting the part of the String that matches the regex
    }

    /**
     * Formatting a String that contains member variable IP
     * @return String showing values in class
     */
    public String getFormatted(){
        return "IPv4: " + this.IP;
    }

    /**
     * Getter method
     * @return Current value of IP
     */
    public String getIP(){
        return this.IP;
    }

    /**
     * Getter method for REGEX
     * @return Value of REGEX in class IPv4
     */
    public static String getRegex(){
        return REGEX;
    }
}

class DateTime implements FormattedOutput{
    private final int DAY;
    private final int MONTH;
    private final int YEAR;
    private final int HOUR;
    private final int MINUTE;
    private final int SECOND;

    // Regex looking for String within "[]" with a date separated by "/" or time separated by ":"
    private static final String REGEX="\\[([0-9]{1,2})/([a-zA-Z]{3})/([0-9]{4}):([0-9]{1,2}):([0-9]{2}):([0-9]{2})\\]";
    private static final Pattern PATTERN=Pattern.compile(REGEX);

    /**
     * Constructor for DateTime
      * @param datetime: String containing values to set DAY, MONTH, YEAR, HOUR, MINUTE and SECOND to
     */
    public DateTime(String datetime){
        Matcher matcher=PATTERN.matcher(datetime);

        if(!matcher.find()){
            // If match is NOT found...
            this.DAY=0;
            this.MONTH=0;
            this.YEAR=0;
            this.HOUR=0;
            this.MINUTE=0;
            this.SECOND=0;
            return;             // Return skips the rest of the code in this function
        }

        int monthValue=0;

        // Loop to find the month represented by the substring and convert it to an int
        for(Months monthList : Months.values()){
            if(monthList.toLog().equals(matcher.group(2))){
                monthValue=monthList.toInt();
                break;                                          // Exit loop when month is found
            }
        }

        // Group method extracts the substring that matches part of the regex
        this.DAY=Integer.parseInt(matcher.group(1));
        this.MONTH=monthValue;
        this.YEAR=Integer.parseInt(matcher.group(3));
        this.HOUR=Integer.parseInt(matcher.group(4));
        this.MINUTE=Integer.parseInt(matcher.group(5));
        this.SECOND=Integer.parseInt(matcher.group(6));
    }

    /**
     * Formatting a String that contains member variables DAY, MONTH, YEAR, HOUR, MINUTE and SECOND
     * @return String that shows values of member variables
     */
    public String getFormatted(){
        // Call to function monthToString converts the this.MONTH from an number to its full name
        return "Day: " + this.DAY + ", Month: " + monthToString() + ", Year: " + this.YEAR
                + ", Hour: " + this.HOUR + ", Minute: " + this.MINUTE + ", Second: " + this.SECOND;
    }

    /**
     * Method to convert member variable MONTH from an int to a String
     * @return String containing name corresponding to numerical value of MONTH
     */
    public String monthToString(){
        String monthLong="";

        // Loop to find the month represented by the member variable month
        for(Months monthList : Months.values()){        // Getting the values from the enum Months
            if(monthList.toInt()==(this.MONTH)){
                monthLong=monthList.toString();
                break;                                  // Exit loop when month is found
            }
        }

        return monthLong;
    }

    /**
     * Getter method for DAY
     * @return Current value of DAY
     */
    public int getDay(){
        return this.DAY;
    }

    /**
     * Getter method for MONTH
     * @return Current value of MONTH
     */
    public int getMonth(){
        return this.MONTH;
    }

    /**
     * Getter method for YEAR
     * @return Current value of YEAR
     */
    public int getYear(){
        return this.YEAR;
    }

    /**
     * Getter method for HOUR
     * @return Current value of HOUR
     */
    public int getHour(){
        return this.HOUR;
    }

    /**
     * Getter method for MINUTE
     * @return Current value of MINUTE
     */
    public int getMinute(){
        return this.MINUTE;
    }

    /**
     * Getter method for SECOND
     * @return Current value of SECOND
     */
    public int getSecond(){
        return this.SECOND;
    }

    /**
     * Getter method for REGEX
     * @return Value of REGEX in class DateTime
     */
    public static String getRegex(){
        return REGEX;
    }
}

class Action implements FormattedOutput{
    private final String ACTION;

    // Regex checks for words in all uppercase (check for if action is part of enum is in constructor)
    private static final String REGEX="\\b[A-Z]+\\b";
    private static final Pattern PATTERN=Pattern.compile(REGEX);

    /**
     * Constructor for Action
     * @param action: Value to set ACTION to
     */
    public Action(String action){
        Matcher matcher=PATTERN.matcher(action);
        String actionValue=null;                                    // this.ACTION will be null if argument action is not part of enum

        if(!matcher.find()){
            this.ACTION=null;
            return;                 // Return skips the rest of the code in this function
        }

        for(Actions todo : Actions.values()){                       // Getting the values from the enum Actions
            if(String.valueOf(todo).equals(matcher.group(0))){      // Check if action (entire String) is in enum
                actionValue=matcher.group(0);
                break;                                              // Exit loop if action is part of enum
            }
        }

        this.ACTION=actionValue;
    }

    /**
     *  Formatting a String that contains member variable ACTION
     * @return String that shows the values of member variable
     */
    public String getFormatted(){
        return "Action: " + this.ACTION;
    }

    /**
     * Getter for ACTION
     * @return Current value of ACTION
     */
    public String getAction(){
        return this.ACTION;
    }

    /**
     * Getter method for REGEX
     * @return Value of REGEX in class Action
     */
    public static String getRegex(){
        return REGEX;
    }
}

class Device implements FormattedOutput{
    private final String DEVICE;

    // Regex checks for string in all lowercase
    private static final String REGEX="([A-Z]+)\\s([a-zA-Z\\s]+)\\s([(])";
    private static final Pattern PATTERN=Pattern.compile(REGEX);

    /**
     * Constructor for Device
     * @param device: String that contains some substring that DEVICE will be set to
     */
    public Device(String device){
        Matcher matcher=PATTERN.matcher(device);
        if(!matcher.find()){
            // If match is NOT found...
            this.DEVICE=null;
            return;                 // Return skips the rest of the code in this function
        }

        boolean validAction=false;

        for(Actions todo : Actions.values()){                       // Getting the values from the enum Actions
            if(String.valueOf(todo).equals(matcher.group(1))){      // Check if action (substring 1) is part of enum
                validAction=true;
                break;                                              // Exit loop if argument action is part of enum
            }
        }

        if(!validAction){
            // If action is NOT part of the enum...
            this.DEVICE=null;
            return;                 // Return skips the rest of the code in this function
        }

        this.DEVICE=matcher.group(2);   // Second matched group will be the device (1st = action, 3rd = "(" )
    }

    /**
     * Formatting a String to contain member variable DEVICE
     * @return String that shows value of member variable
     */
    public String getFormatted(){
        return "Device: " + this.DEVICE;
    }

    /**
     * Getter method for DEVICE
     * @return Current value of DEVICE
     */
    public String getDevice(){
        return this.DEVICE;
    }

    /**
     * Getter method for REGEX
     * @return Value of REGEX in class
     */
    public static String getRegex(){
        return REGEX;
    }
}

class Location implements FormattedOutput{
    private final String ROOM;
    private final String BUILDING;

    // Regex looks for String inside in the format "(String1 - String2)
    private static final String REGEX="\\(([a-zA-Z\\s]*)\\s-\\s([a-zA-Z\\s]*)\\)";
    private static final Pattern PATTERN=Pattern.compile(REGEX);

    /**
     * Constructor for Location
     * @param location: String that contains substrings that ROOM and BUILDING will be set to
     */
    public Location(String location){
        Matcher matcher=PATTERN.matcher(location);

        if(!matcher.find()){
            // If match is NOT found...
            this.ROOM=null;
            this.BUILDING=null;
            return;                     // Return skips the rest of the code in this function
        }

        this.ROOM=matcher.group(1);         // First matched group will be the room
        this.BUILDING=matcher.group(2);     // Second matched group will be the building
    }

    /**
     * Formatting String that contains member variables ROOM and BUILDING
     * @return String that shows values of member variables
     */
    public String getFormatted(){
        return "Room: " + this.ROOM + ", Building: " + this.BUILDING;
    }

    /**
     * Getter method for ROOM
     * @return Current value of ROOM
     */
    public String getRoom(){
        return this.ROOM;
    }

    /**
     * Getter method for BUILDING
     * @return Current value of ROOM
     */
    public String getBuilding(){
        return this.BUILDING;
    }

    /**
     * Getter method for REGEX
     * @return Value of REGEX in class
     */
    public static String getRegex(){
        return REGEX;
    }
}

class ParseLogfile{
    private ArrayList<ParseLine> log=new ArrayList<>();

    /**
     * Constructor for ParseLogfile
     * @param array: Array that contains log lines that log will be set to
     */
    public ParseLogfile(String[] array){
        // Loop to store values from array in a String and create new ParseLine objects using String
        for(String store : array){
            ParseLine newLogLine=new ParseLine(store);
            log.add(newLogLine);
        }
    }

    /**
     * Retrieves a specific line within log
     * @param index: Line to retrieve
     * @return Line at specified index
     */
    public ParseLine getLine(int index){
        return log.get(index);
    }

    /**
     * Getter method for log
     * @return Current value of log
     */
    public ArrayList<ParseLine> getLog(){
        return this.log;
    }
}

class ParseLine{
    private final String LOGLINE;
    private final Location LOCATION;
    private final Device DEVICE;
    private final Action ACTION;
    private final DateTime DATETIME;
    private final IPv4 IPV4;

    /**
     * Constructor for ParseLine
     * @param line: String that contains values for IPV4, LOCATION, DEVICE, ACTION and DATETIME. LOGLINE will be set to this String.
     */
    public ParseLine(String line){
        this.LOGLINE=line;

        // Error handling for objects is handled by their constructors
        this.IPV4=new IPv4(line);
        this.LOCATION=new Location(line);
        this.DEVICE=new Device(line);
        this.ACTION=new Action(line);
        this.DATETIME=new DateTime(line);
    }

    /**
     * Getter method for IPV4
     * @return Current value of IPv4
     */
    public IPv4 getIPv4(){
        return this.IPV4;
    }

    /**
     * Getter method for LOGLINE
     * @return Current value of LOGLINE
     */
    public String getLogLine(){
        return this.LOGLINE;
    }

    /**
     * Getter method for LOCATION
     * @return Current value of LOCATION
     */
    public Location getLocation(){
        return this.LOCATION;
    }

    /**
     * Getter method for DEVICE
     * @return Current value of DEVICE
     */
    public Device getDevice(){
        return this.DEVICE;
    }

    /**
     * Getter method for ACTION
     * @return Current value of ACTION
     */
    public Action getAction(){
        return this.ACTION;
    }

    /**
     * Getter method for DATETIME
     * @return Current value of DATETIME
     */
    public DateTime getDateTime(){
        return this.DATETIME;
    }
}

public class MyOutput{
    public static void main(String[] args){
        /*
        IPv4 i=new IPv4("100.45.8.205");

        DateTime dt1=new DateTime("[5/Apr/2023:15:46:06]");     // Correct format
        System.out.println(dt1.getDay() + "/" + dt1.getMonth() + "/" + dt1.getYear() + "   " + dt1.getHour() + ":" + dt1.getMinute() + ":" + dt1.getSecond());
        System.out.println(dt1.getFormatted());

        DateTime dt2=new DateTime("[10/Sep/2018:09:07:59]");
        System.out.println(dt2.getFormatted() + "\n");

        Action a1=new Action("START");      // Valid action
        System.out.println(a1.getAction());

        Action a2=new Action("BEGIN");      // Invalid action
        System.out.println(a2.getAction() + "\n");

        Device d1=new Device("water");      // Wrong format
        System.out.println(d1.getDevice());

        Device d2=new Device("END fire alarm (");      // Correct format
        System.out.println(d2.getDevice());

        Device d3=new Device("STOP Security Cameras (");        // Invalid action, but correct format
        System.out.println(d3.getDevice() + "\n");

        Location l1=new Location("(Cubicles - Downtown Offices)");       // Correct format
        System.out.println(l1.getRoom() + "  " + l1.getBuilding());

        Location l2=new Location("Bathroom - Building F");
        System.out.println(l2.getRoom() + "  " + l2.getBuilding());
        */


        String[] exampleLog = exampleLog();

        var logfile = new ParseLogfile(exampleLog);
        var line = logfile.getLine(0);
        System.out.println("Log line 0: " + line.getLogLine());

        var ip = line.getIPv4();
        System.out.println("IPv4: "+ip.getIP());

        var dt = line.getDateTime();
        System.out.println("Day: "+dt.getDay());
        System.out.println("Month: "+dt.getMonth());
        System.out.println("Month (named): "+dt.monthToString());
        System.out.println("Year: "+dt.getYear());
        System.out.println("Hour: "+dt.getHour());
        System.out.println("Minute: "+dt.getMinute());
        System.out.println("Second: "+dt.getSecond());

        var act = line.getAction();
        System.out.println("Action: "+act.getAction());

        var dev = line.getDevice();
        System.out.println("Device: "+dev.getDevice());

        var loc = line.getLocation();
        System.out.println("Room: "+loc.getRoom());
        System.out.println("Building: "+loc.getBuilding());

        System.out.println();
        line = logfile.getLine(6);
        System.out.println("Log line 6: " + line.getLogLine());
        System.out.println(line.getIPv4().getFormatted());
        System.out.println(line.getDateTime().getFormatted());
        System.out.println(line.getAction().getFormatted());
        System.out.println(line.getDevice().getFormatted());
        System.out.println(line.getLocation().getFormatted());

        System.out.println("\nExample of toLog() output: " + Months.AUG.toLog());
        System.out.println("\nExample regex (for DateTime): "+dt.getRegex());
    }

    // Contains example data
    public static String[] exampleLog(){
        String[] log={
                "81.220.24.207 - - [2/Mar/2020:10:05:44] \"END sprinkler (Visitor entrance - Building A)\"",
                "81.220.24.207 - - [2/Mar/2020:10:05:26] \"ENABLE cooling system (Secured room - Building A)\"",
                "81.220.24.207 - - [2/Mar/2020:10:05:39] \"START heating system (Hall - Central)\"",
                "81.220.24.207 - - [2/Mar/2020:10:05:52] \"ENABLE door lock (Visitor entrance - Building B)\"",
                "81.220.24.207 - - [2/Mar/2020:10:05:21] \"TEST cooling system (Entrance - Building B)\"",
                "66.249.73.135 - - [17/May/2020:01:05:17] \"TEST fan (Secured room - Airport location)\"",
                "46.105.14.53 - - [17/May/2020:11:05:42] \"TEST cooling system (Secured room - Airport location)\"",
                "218.30.103.62 - - [17/May/2020:11:05:11] \"START sprinkler (Secured room - Airport location)\"",
                "218.30.103.62 - - [17/May/2020:11:05:46] \"DISABLE fan (Control room - Central)\"",
                "218.30.103.62 - - [17/May/2020:11:05:45] \"START door lock (Secured room - Building A)\"",
                "66.249.73.135 - - [27/Jun/2020:11:05:31] \"TEST sprinkler (Hall - Building B)\""
        };

        return log;
    }
}       // end of main class
