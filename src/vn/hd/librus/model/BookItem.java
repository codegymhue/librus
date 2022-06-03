package vn.hd.librus.model;

import java.time.Instant;

public class BookItem {
    private Long id;
    private Long barcode;
    private Instant borrowedAt;
    private Instant dueAt;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private Instant dateOfPurchase;
    private Instant publicationAt;
    boolean isReferenceOnly;
    private Instant updatedAt;
    private Long bookId;

    private Rack placedAt;
    private Book book;

    public static BookItem parse(String record) {
        return null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
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

    public Instant getPublicationAt() {
        return publicationAt;
    }

    public void setPublicationAt(Instant publicationAt) {
        this.publicationAt = publicationAt;
    }

    public boolean isReferenceOnly() {
        return isReferenceOnly;
    }

    public void setReferenceOnly(boolean referenceOnly) {
        isReferenceOnly = referenceOnly;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                barcode,
                borrowedAt,
                dueAt,
                price,
                format,
                status,
                dateOfPurchase,
                publicationAt,
                isReferenceOnly,
                bookId);

    }
}
