package vn.hd.librus.model;

import java.time.Instant;

public class Book {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private Instant createdAt;
    private Instant updatedAt;

    public Book() {
    }

    public Book(long id, String isbn, String title, String author, String subject, String publisher, String language, int numberOfPages, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

    }

    public Book(long id, String isbn, String title, String author, String subject, String publisher, String language, int numberOfPages) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberOfPages = numberOfPages;
    }

    public Book(String isbn, String title, String author, String subject, String publisher, String language, int numberOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberOfPages = numberOfPages;
    }


    public static Book parse(String raw) {
        String[] fields = raw.split(",");
//        long id = Long.parseLong(fields[0]);
        String ISBN = fields[0];
        String title = fields[1];
        String author = fields[2];
        String subject = fields[3];
        String publisher = fields[4];
        String language = fields[5];
        int numberOfPage = Integer.parseInt(fields[6]);
        return new Book( ISBN, title, author, subject, publisher, language, numberOfPage);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s", isbn, title, author, subject, publisher, language, numberOfPages);
    }
}