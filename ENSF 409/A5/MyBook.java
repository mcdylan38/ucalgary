/**
* Author: Dylan Mah (30086580)
* Version: 1.0
* Since: 1.0
*/

/**
 * Implementation of the UML diagram outlined in Exercise 12.4
 */

abstract class Book{
    private String isbn;
    private int publicationYear;
    private int pages;

    /**
     * Default constructor for Book
     */
    public Book(){}

    /**
     * Constructor for Book
     * @param isbn: Value to set isbn to
     * @param pages: Value to set pages to
     */
    public Book(String isbn, int pages){
        this.isbn=isbn;
        this.pages=pages;
    }

    /**
     * Getter method for isbn
     * @return Current value of isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Setter method for isbn
     * @param isbn: Value to set isbn to
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Getter method for publicationYear
     * @return Current value of publicationYear
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Setter method for publicationYear
     * @param publicationYear: Value to set publicationYear to
     */
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * Getter method for pages
     * @return Current value of pages
     */
    public int getPages() {
        return pages;
    }

    /**
     * Setter method for pages
     * @param pages: Value to set pages to
     */
    public void setPages(int pages) {
        this.pages = pages;
    }
}

abstract class Hardcover extends Book{
    /**
     * Inherited constructor from parent class Book
     * @param isbn: Value to set isbn to
     * @param pages: Value to set pages to
     */
    Hardcover(String isbn, int pages){
        super(isbn, pages);
    }

    /**
     * Default constructor for Hardcover
     */
    Hardcover(){}

    /**
     * Create binding for a hardcover book
     */
    public abstract void binding();
}

abstract class Paperback extends Book{
    /**
     * Inherited constructor from parent class Book
     * @param isbn: Value to set isbn to
     * @param pages: Value to set pages to
     */
    Paperback(String isbn, int pages){
        super(isbn, pages);
    }

    /**
     * Default constructor for Paperback
     */
    Paperback(){}

    /**
     * Creates cover art for a paperback book
     * @return String that says which method is called from which class
     */
    public String coverArt(){
        return "Method coverArt called from Paperback";
    }
}

class Classic extends Hardcover{
    private int origPubYear=1860;
    private Author[] theAuthor=new Author[10];
    private Publisher[] bookPublisher=new Publisher[10];

    /**
     * Inherited constructor from class Hardcover
     * @param isbn: Value to set isbn to
     * @param pages: Value to set pages to
     */
    Classic(String isbn, int pages){
        super(isbn, pages);
    }

    /**
     * Inherited method from class Hardcover, creates binding for a hardcover book
     */
    public void binding(){}

    /**
     * Creates notes about a classic
     * @return String that says which method is called from which class
     */
    public String createNotes(){
        return "Method createNotes called from Classic";
    }

    /**
     * Getter method of OrigPubYear
     * @return Current value of OrigPubYear
     */
    public int getOrigPubYear(){
        return origPubYear;
    }

    /**
     * Setter method for origPubYear
     * @param origPubYear: Value to set origPubYear to
     */
    public void setOrigPubYear(int origPubYear){
        this.origPubYear=origPubYear;
    }

    /**
     * Getter method for theAuthor
     * @return Current value of theAuthor
     */
    public Author[] getTheAuthor(){
        return this.theAuthor;
    }

    /**
     * Setter method for theAuthor
     * @param theAuthor: Value to set theAuthor to
     */
    public void setTheAuthor(Author[] theAuthor){
        this.theAuthor=theAuthor;
    }

    /**
     * Getter method for bookPublisher
     * @return Current value of bookPublisher
     */
    public Publisher[] getBookPublisher(){
        return this.bookPublisher;
    }

    /**
     * Setter method for bookPublisher
     * @param bookPublisher: Value to set bookPublisher to
     */
    public void setBookPublisher(Publisher[] bookPublisher){
        this.bookPublisher=bookPublisher;
    }
}

class Category{
    private Category subCategory;
    private Category superCategory;
    private String category;

    /**
     * Sorting books into categories
     * @return String to say which method is called from which class
     */
    public String sort(){
        return "Method sort called from Category";
    }

    /**
     * Refines - reflexive association constructor
     * @param subCategory: Value to set subCategory to
     * @param superCategory: Value to set superCategory to
     */
    Category(Category subCategory, Category superCategory){
        this.subCategory=subCategory;
        this.superCategory=superCategory;
    }

    /**
     * Getter method for subCategory
     * @return Current value of subCategory
     */
    public Category getSubCategory(){
        return this.subCategory;
    }

    /**
     * Setter method for subCategory
     * @param subCategory: Value to set subCategory to
     */
    public void setSubCategory(Category subCategory){
        this.subCategory=subCategory;
    }

    /**
     * Getter method for superCategory
     * @return Current value of superCategory
     */
    public Category getSuperCategory(){
        return this.superCategory;
    }

    /**
     * Setter method for superCategory
     * @param superCategory: Value to set superCategory to
     */
    public void setSuperCategory(Category superCategory){
        this.superCategory=superCategory;
    }

    /**
     * Getter method for category
     * @return Current value of category
     */
    public String getCategory(){
        return category;
    }

    /**
     * Setter method for category
     * @param category: Value to set category to
     */
    public void setCategory(String category){
        this.category=category;
    }
}

class Nonfiction extends Paperback{
    private Category deweyClassification;

    /**
     * Inherited constructor from parent class Paperback
     * @param isbn: Value to set isbn to
     * @param pages: Value to set pages to
     */
    Nonfiction(String isbn, int pages){
        super(isbn, pages);
    }

    /**
     * Setting the topic for a nonfiction paperback book
     * @return String to say which method is called from which class
     */
    public String topic(){
        return "Method topic called from Nonfiction";
    }

    /**
     * Getter method for deweyClassification
     * @return Current value of deweyClassification
     */
    public Category getDeweyClassification(){
        return deweyClassification;
    }

    /**
     * Setter method for deweyClassification
     * @param deweyClassification: Value to set deweyClassification to
     */
    public void setDeweyClassification(Category deweyClassification){
        this.deweyClassification=deweyClassification;
    }
}

abstract class Fiction extends Paperback{
    public abstract String coverArt();

    /**
     * Inherited constructor from parent class Paperback
     * @param isbn: Value to set isbn to
     * @param pages: Value to set pages to
     */
    Fiction(String isbn, int pages){
        super(isbn, pages);
    }

    /**
     * Default constructor for Fiction
     */
    Fiction(){}

    /**
     * Setting the genre of a fiction paperback book
     * @return String to say which method is called from which class
     */
    public String genre(){
        return "Method genre called from Fiction";
    }
}

class Story{
    private Author[] theAuthor=new Author[10];

    /**
     * Summary of the story
     * @return String to say which method is called from which class
     */
    public String plot(){
        return "Method plot called from Story";
    }

    /**
     * Getter method for theAuthor
     * @return Current value of theAuthor
     */
    public Author[] getTheAuthor(){
        return theAuthor;
    }

    /**
     * Setter method for theAuthor
     * @param theAuthor: Value to set theAuthor to
     */
    public void setTheAuthor(Author[] theAuthor){
        this.theAuthor=theAuthor;
    }
}

class Anthology extends Fiction{
    private Story[] story;

    /**
     * Inherited constructor from parent class Fiction
     * @param isbn: Value to set isbn to
     * @param pages: Value to set pages to
     */
    Anthology(String isbn, int pages){
        super(isbn, pages);
    }

    /**
     * Inherited method from parent class Fiction, creates cover art for anthology
     * @return String to say which method is called from which class
     */
    public String coverArt(){
        return "Method coverArt called from Anthology";
    }

    /**
     * Constructor to check that there are at least 5 stories in the anthology
     * @param story: Value to set story to
     */
    Anthology(Story[] story){
        if(story.length < 5){
            throw new ArrayIndexOutOfBoundsException("Anthology cannot have less than 5 stories");
        }

        this.story=story;
    }

    /**
     * Setting the order for the anthology
     * @return String to say which method is called from which class
     */
    public String storyOrder(){
        return "Method storyOrder called from Anthology";
    }

    /**
     * Getter method for story
     * @return Current value of story
     */
    public Story[] getStory(){
        return story;
    }

    /**
     * Setter method for story
     * @param story: Value to set story to
     */
    public void setStory(Story[] story){
        this.story=story;
    }
}

class Novel extends Fiction{
    private Author[] theAuthor=new Author[10];
    private Series mySeries=new Series();

    /**
     * Inherited constructor from parent class Fiction
     * @param isbn: Value to set isbn to
     * @param pages: Value to set pages to
     */
    Novel(String isbn, int pages){
        super(isbn, pages);
    }

    /**
     * Inherited method from parent class Fiction, creates cover art for a fiction novel
     * @return String to say which method is called from which class
     */
    public String coverArt(){
        return "Method coverArt called from Novel";
    }

    /**
     * Setting theme for the novel
     * @return String to say which method is called from which class
     */
    public String theme(){
        return "Method theme called from Novel";
    }

    /**
     * Getter method for theAuthor
     * @return Current value of theAuthor
     */
    public Author[] getTheAuthor(){
        return theAuthor;
    }

    /**
     * Setter method for theAuthor
     * @param theAuthor: Value to set theAuthor to
     */
    public void setTheAuthor(Author[] theAuthor){
        this.theAuthor=theAuthor;
    }

    /**
     * Getter method for mySeries
     * @return Current value of mySeries
     */
    public String getMySeriesName(){
        return mySeries.getSeriesName();
    }

    /**
     * Setter method for mySeries
     * @param mySeriesName: Value to set mySeries to
     */
    public void setMySeriesName(String mySeriesName){
        this.mySeries.setSeriesName(mySeriesName);
    }
}

class Publisher{
    private String name;
    private String address;
    private Classic[] classicsCatalog=new Classic [10];

    /**
     * Constructor for Publisher
     * @param name: Value to set name to
     * @param address: Value to set address to
     */
    public Publisher(String name, String address){
        this.name=name;
        this.address=address;
    }

    /**
     * Creates a hard copy of the letter head
     * @return String to say which method is called from which class
     */
    public String printLetterHead(){
        return "Method printLetterHead called from Publisher";
    }

    /**
     * Getter method for name
     * @return Current value of name
     */
    public String getName(){
        return name;
    }

    /**
     * Setter method for name
     * @param name: Value to set name to
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * Getter method for address
     * @return Current value of address
     */
    public String getAddress(){
        return address;
    }

    /**
     * Setter method for address
     * @param address: Value to set address to
     */
    public void setAddress(String address){
        this.address=address;
    }

    /**
     * Getter method for classicsCatalog
     * @return Current value of classicsCatalog
     */
    public Classic[] getClassicsCatalog(){
        return classicsCatalog;
    }

    /**
     * Setter method for classicsCatalog
     * @param classicsCatalog: Value to set classicsCatalog to
     */
    public void setClassicsCatalog(Classic[] classicsCatalog){
        this.classicsCatalog=classicsCatalog;
    }
}

class Author{
    private String name="Unknown";
    private String address;
    private int age;

    /**
     * Constructor for Author
     * @param name: Value to set name to
     * @param address: Value to set address to
     * @param age: Value to set age to
     */
    public Author(String name, String address, int age){
        this.name=name;
        this.address=address;
        this.age=age;
    }

    /**
     * Default constructor for Author
     */
    public Author(){}

    /**
     * Writing a book
     * @return String to say which method is called from which class
     */
    public String write(){
        return "Method write called from Author";
    }
}

class Series{
    private String seriesName;

    /**
     * Default constructor for Series
     */
    public Series(){}

    /**
     * Setting theme for series
     * @return String to say which method is called from which class
     */
    public String theme(){
        return "Method theme called from Series";
    }

    /**
     * Getter method for seriesName
     * @return Current value of seriesName
     */
    public String getSeriesName(){
        return seriesName;
    }

    /**
     * Setter method for seriesName
     * @param seriesName: Value to set seriesName to
     */
    public void setSeriesName(String seriesName){
        this.seriesName=seriesName;
    }
}

class Contract{
    private String date;
    private Publisher publisherInfo;
    private Author[] authorInfo=new Author[10];

    /**
     * Constructor for Contract
     * @param date: Value to set date to
     * @param publisherInfo: Value to set publisherInfo to
     * @param authorInfo: Value to set authorInfo to
     */
    public Contract(String date, Publisher publisherInfo, Author[] authorInfo){
        this.date=date;
        this.publisherInfo=publisherInfo;
        this.authorInfo=authorInfo;
    }

    /**
     * Printing the contract between an author and publisher
     * @return String to say which method is called from which class
     */
    public String printContract(){
        return "Method printContract called from Contract";
    }

    /**
     * Getter method for date
     * @return Current value of date
     */
    public String getDate(){
        return date;
    }

    /**
     * Setter method for date
     * @param date: Value to set date to
     */
    public void setDate(String date){
        this.date=date;
    }

    /**
     * Getter method for publisherInfo
     * @return Current value of publisherInfo
     */
    public Publisher getPublisherInfo(){
        return publisherInfo;
    }

    /**
     * Setter method for publisherInfo
     * @param publisherInfo: Value to set publisherInfo to
     */
    public void setPublisherInfo(Publisher publisherInfo){
        this.publisherInfo=publisherInfo;
    }

    /**
     * Getter method for authorInfo
     * @return Current value of authorInfo
     */
    public Author[] getAuthorInfo(){
        return authorInfo;
    }

    /**
     * Setter method for authorInfo
     * @param authorInfo: Value to set authorInfo to
     */
    public void setAuthorInfo(Author[] authorInfo){
        this.authorInfo=authorInfo;
    }
}

public class MyBook{
    public static void main(String[] args) {
        // Nonfiction, Category, Paperback
        var history = new Nonfiction();
        var deweyOne = new Category();
        deweyOne.setCategory("History");
        var deweyTwo = new Category();
        deweyTwo.setCategory("French");
        deweyTwo.setSuperCategory(deweyOne);
        deweyOne.setSubCategory(deweyTwo);
        var deweyThree = new Category();
        deweyThree.setCategory("Revolution");
        deweyThree.setSuperCategory(deweyTwo);
        deweyTwo.setSubCategory(deweyThree);
        System.out.println(deweyThree.sort());
        history.setDeweyClassification(deweyThree);
        System.out.println(history.topic());
        System.out.println(history.coverArt());

        // Series, Novel

        var anne = new Author("Anne Rice", "USA", 60);
        System.out.println(anne.write());
        var interviewWithVampire = new Novel();
        interviewWithVampire.setTheAuthor("anne");
        System.out.println(interviewWithVampire.coverArt());
        System.out.println(interviewWithVampire.genre());

        // Anthology, Story
        var vampireInParis = new Story();
        vampireInParis.setTheAuthor("anne");
        System.out.println(vampireInParis.plot());
        var vampiresEverywhere = new Anthology();
        System.out.println(vampiresEverywhere.storyOrder());

    }
}
