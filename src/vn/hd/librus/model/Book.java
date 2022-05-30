package vn.hd.librus.model;

public class Book {
    private String ISBN ;
    //ISBN is the acronym for International Standard Book Number. This 10 or 13-digit number identifies a specific book
    private String title;
    private String author;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPage;

    public Book(String ISBN, String title,String author, String subject, String publisher, String language, int numberOfPage) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberOfPage = numberOfPage;
    }

    public static Book parse (String raw ){
        String [] fields = raw.split(",");
        String ISBN = fields[0];
        String title = fields[1];
        String author = fields[2];
        String subject = fields[3];
        String publisher = fields[4];
        String language = fields[5];
        int numberOfPage = Integer.parseInt(fields[6]);
        return new Book (ISBN,title,author,subject,publisher,language,numberOfPage);

    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                ISBN,
                title,
                author,
                subject,
                publisher,
                language,
                numberOfPage);
    }
}