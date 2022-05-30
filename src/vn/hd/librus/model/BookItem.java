package vn.hd.librus.model;

import java.time.Instant;

public class BookItem {
    private Long id;
    private String barcode;
    private Instant borrowedAt;
    private Instant dueAt;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private Instant dateOfPurchase;
    private Instant publication;
    boolean isReferenceOnly;
    private Long bookId;
    private Book book;

    public Long getId() {
        return id;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Instant getBorrowedAt() {
        return borrowedAt;
    }

    public void setBorrowedAt(Instant borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public Instant getDueAt() {
        return dueAt;
    }

    public void setDueAt(Instant dueAt) {
        this.dueAt = dueAt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookFormat getFormat() {
        return format;
    }

    public void setFormat(BookFormat format) {
        this.format = format;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Instant getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Instant dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Instant getPublication() {
        return publication;
    }

    public void setPublication(Instant publication) {
        this.publication = publication;
    }

    public boolean isReferenceOnly() {
        return isReferenceOnly;
    }

    public void setReferenceOnly(boolean referenceOnly) {
        isReferenceOnly = referenceOnly;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                id,
                barcode,
                borrowedAt,
                dueAt,
                price,
                format,
                status,
                dateOfPurchase,
                publication,
                isReferenceOnly,
                bookId
        );

    }
}
