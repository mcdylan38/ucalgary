/**
 * ENSF 409 - Assignment 9 (Exercise 20.3)
 * Dylan Mah (30086580)
 * Version: 1.0
 * Since: 1.0
 */

// All databased-related try/catch statements should use the SQLException
// No required behavior for catch statements
// All resources must be released (closed)
// Method documentation must explain if/how each method uses the database

package edu.ucalgary.ensf409;

import java.sql.*;

public class Registration{
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;
    private Connection connection;
    private ResultSet results;

    // Constructor
    Registration(String url, String username, String password){
        this.DBURL=url;
        this.USERNAME=username;
        this.PASSWORD=password;
    }

    // Return value of DBURL
    public String getDburl(){
        return this.DBURL;
    }

    // Return value of USERNAME
    public String getUsername(){
        return this.USERNAME;
    }

    // Return value of PASSWORD
    public String getPassword(){
        return this.PASSWORD;
    }

    // Establish a connection to the database specified by DBURL
    public void initializeConnection(){
        try{
            // Try to open a connection to the database given by DBURL and log into it using USERNAME and PASSWORD
            this.connection=DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Get all first and last names from the specified table (competitor, teacher)
    public String selectAllNames(String table){
        StringBuilder names=new StringBuilder();

        try{
            // Try to access the database and get columns from the specified table by creating a normal statement
            // and execute the statement. If this fails, the error will be caught.
            Statement getNames=this.connection.createStatement();
            this.results=getNames.executeQuery("SELECT * FROM " + table);
            int length=0;       // Variable to check how many entries in specified table

            while(this.results.next()){
                // While the table has filled rows, get LName and FName from those rows
                if(length > 0){
                    // If not on the first line of the table, add a new line
                    names.append("\n");
                }

                // Getting values of LName and FName from the specified table and storing them in the String to return
                names.append(this.results.getString("LName"));
                names.append(", ");
                names.append(this.results.getString("FName"));
                length++;
            }

            // Close getNames statement to release resources
            getNames.close();
        }

        catch(SQLException e){
            e.printStackTrace();
        }

        return names.toString();    // Need to convert StringBuilder to String type
    }

    // Show the names of all studios
    public String showStudios(){
        StringBuilder studios=new StringBuilder();

        try{
            // Try to access the studio table and get the columns from it by creating a normal statement
            // and execute it. If this fails, the error will be caught.
            Statement getStudios=this.connection.createStatement();
            this.results=getStudios.executeQuery("SELECT * FROM studio");
            int length=0;       // Variable to check how many entries in specified table

            while(this.results.next()){
                // While the table has filled rows, get Name from that row
                if(length > 0){
                    // If not on the first line of the table, add a new line
                    studios.append("\n");
                }

                // Getting the value of Name from the studio table and storing it in the String to return
                studios.append(this.results.getString("Name"));
                length++;
            }

            // Close getStudios statement to release resources
            getStudios.close();
        }

        catch(SQLException e){
            e.printStackTrace();
        }

        return studios.toString();  // Need to convert StringBuilder to String type
    }

    // Add a new entry to the competitor table
    public void insertNewCompetitor(String cID, String lName, String fName, int age, String instrument, String tID) throws IllegalArgumentException{
        if(age < 5 || age > 18){
            // If the age is not between 5 and 18 (both inclusive)...
            throw new IllegalArgumentException("Invalid age");
        }

        try{
            // Try to access teacher table to check if tID exists already. This is done by creating a prepared
            // statement that executes a query, which is stored in a ResultSet. If the ResultSet is NOT updated, the
            // tID does NOT exist. If this fails, the error will be caught.
            String teacherExists="SELECT * FROM teacher WHERE TeacherID = ?";
            PreparedStatement findTeacher=this.connection.prepareStatement(teacherExists);
            findTeacher.setString(1, tID);      // Load tID into query
            this.results=findTeacher.executeQuery();        // Look for tID in teacher table

            if(!this.results.next()){
                // If tID doesn't exist in Teacher table...
                findTeacher.close();        // End query
                closeSQL();                 // Release resources from database
                throw new IllegalArgumentException("Teacher does not exist");
            }

            // Try to access competitor table to add a row that will be a new competitor by creating a prepared
            // statement that executes a query. The values for the query are updated using set methods. If this fails,
            // the error will be caught.
            String newCompetitor="INSERT INTO competitor (CompetitorID, LName, FName, Age, Instrument, TeacherID) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertCompetitor=this.connection.prepareStatement(newCompetitor);
            insertCompetitor.setString(1, cID);
            insertCompetitor.setString(2, lName);
            insertCompetitor.setString(3, fName);
            insertCompetitor.setInt(4, age);
            insertCompetitor.setString(5, instrument);
            insertCompetitor.setString(6, tID);
            // Update database table
            insertCompetitor.executeUpdate();
            // Close insertCompetitor prepared statement to release resources
            insertCompetitor.close();
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Add a new entry to the teacher table. If the specified studio name doesn't exist in the studio table, add that too.
    public void registerNewTeacher(String tID, String lName, String fName, String tPhone, String sName, String sPhone, String sAddress) throws IllegalArgumentException{
        // Note: when adding a new teacher, need to check if studio exists first because the foreign key (StudioName)
        // must be updated before the primary key (TeacherID)

        try{
            // Try to access teacher table to see if tID already exists by creating a prepared statement that executes
            // a query, that is stored in a ResultSet. If the ResultSet is updated, the tID already exists. If this
            // fails, the error will be caught.
            String teacherExists="SELECT * FROM teacher where TeacherID = ?";
            PreparedStatement findTeacher=this.connection.prepareStatement(teacherExists);
            findTeacher.setString(1, tID);      // Load tID into query
            this.results=findTeacher.executeQuery();        // Look for tID in teacher table

            if(this.results.next()){
                // If tID is found in teacher table...
                findTeacher.close();        // End query
                closeSQL();                 // Close connection to database
                throw new IllegalArgumentException("TeacherID is already registered");
            }

            // Try to access studio table to see if the studio already exists by creating a prepared statement that
            // executes a query, that is stored in a ResultSet. The query value is updated using a set method. If this
            // fails, the error will be caught.
            String studioExists="SELECT * FROM studio where Name = ?";
            PreparedStatement findStudio=this.connection.prepareStatement(studioExists);
            findStudio.setString(1, sName);     // Load sName into query
            this.results=findStudio.executeQuery();         // Look for sName in studio table

            if(!this.results.next()) {
                // If sName does NOT exist in the studio table (i.e. ResultSet is empty), add it to the table
                String newStudio="INSERT INTO studio (Name, Phone, Address) VALUES (?, ?, ?)";
                PreparedStatement insertStudio=this.connection.prepareStatement(newStudio);
                insertStudio.setString(1, sName);
                insertStudio.setString(2, sPhone);
                insertStudio.setString(3, sAddress);
                // Update database table
                insertStudio.executeUpdate();
                // Close insertStudios prepared statement to release resources
                insertStudio.close();
            }

            // Try to access teacher table to add a row that will be a new teacher by creating a prepared statement
            // that executes a query. The values for the query are updated using set methods. If this fails, the error
            // will be caught.
            String newTeacher="INSERT INTO teacher (TeacherID, LName, FName, Phone, StudioName) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertTeacher=this.connection.prepareStatement(newTeacher);
            insertTeacher.setString(1, tID);
            insertTeacher.setString(2, lName);
            insertTeacher.setString(3, fName);
            insertTeacher.setString(4, tPhone);
            insertTeacher.setString(5, sName);
            // Update database table
            insertTeacher.executeUpdate();
            // Close insertTeacher prepared statement to release resources
            insertTeacher.close();
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Delete an entry from the competitor table
    public void deleteCompetitor(String id){
        try{
            // Try to delete a competitor from the competitor table by creating a prepared statement that executes a
            // query. The query value is updated using a set method. If this fails, the error will be caught.
            String findCompetitor="DELETE FROM competitor where CompetitorID = ?";
            PreparedStatement deleteCompetitor=this.connection.prepareStatement(findCompetitor);
            deleteCompetitor.setString(1, id);
            // Update database table
            deleteCompetitor.executeUpdate();
            // Close deleteCompetitor prepared statement to release resources
            deleteCompetitor.close();
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Delete an entry from the teacher table
    public void deleteTeacher(String id){
        try{
            // Try to delete a teacher from the teacher table by creating a prepared statement that executes a
            // query. The query value is updated using a set method. If this fails, the error will be caught.
            String findTeacher="DELETE FROM teacher where TeacherID = ?";
            PreparedStatement deleteTeacher=this.connection.prepareStatement(findTeacher);
            deleteTeacher.setString(1, id);
            // Update database table
            deleteTeacher.executeUpdate();
            // Close deleteTeacher prepared statement to release resources
            deleteTeacher.close();
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Release SQL resources (close Connection and close ResultSet)
    private void closeSQL(){
        try{
            // Try to close Connection to database and release memory in ResultSet. If this fails, the error will be
            // caught.
            this.results.close();
            this.connection.close();
        }

        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        // Note: need to add an extra System.out.println() because the select methods have no new lines before or after
        // table entries

        Registration myJDBC=new Registration("jdbc:mysql://localhost/competition","Dylan","ensf409");
        myJDBC.initializeConnection();

        myJDBC.insertNewCompetitor("123", "Smyth", "Ali", 15, "Oboe", "0023");
        System.out.println("After adding Ali Smyth: \n" + myJDBC.selectAllNames("competitor"));
        System.out.println();
        myJDBC.deleteCompetitor("123");
        System.out.println("After deleting Ali Smyth: \n" + myJDBC.selectAllNames("competitor"));
        System.out.println();
        /*
        Example:
        Williams, Sophie
        Warren, Harper
        */

        myJDBC.registerNewTeacher("0987", "Marasco", "Emily", "403-222-5656", "Marasco Music", "587-222-5656", "123 Main Street NW");
        System.out.println("After adding Emily Marasco: \n" + myJDBC.selectAllNames("teacher"));
        System.out.println();
        myJDBC.deleteTeacher("0987");
        System.out.println("After deleting Emily Marasco: \n" + myJDBC.selectAllNames("teacher"));
        System.out.println();
        /*
        Example:
        Estrada, Ethan
        Lee, Jasmine
        */

        System.out.println("Studio names: \n" + myJDBC.showStudios());
        /*
        Example:
        Harmony Inc.
        Melody Time
        Music Mastery
        */

        // These two entries should cause errors
        //myJDBC.insertNewCompetitor("444", "Martin", "Foo", 17, "Trumpet", "1234");    // tID doens't exist
        //myJDBC.registerNewTeacher("9202", "Martin", "Foo", "403-823-9445", "Music Mastery", "403-298-5785", "25 Heron Way NW");   // tID already exists

        myJDBC.closeSQL();      // Close connection to database if no errors are encountered
    }
}

// Add database in MySQL through: "source C:\Users\coolp\IdeaProjects\ENSF409\lecture20\src\competition.sql"
// javac -cp ;mysql-connector-java-8.0.23.jar; edu/ucalgary/ensf409/Registration.java
// java -cp ;mysql-connector-java-8.0.23.jar; edu.ucalgary.ensf409.Registration