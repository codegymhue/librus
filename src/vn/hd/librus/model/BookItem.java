package vn.hd.librus.model;

import vn.hd.librus.utils.InstantUtils;

import java.time.Instant;

public class BookItem {
    private Long bookItemID;
    private Long barcode;
    private String publisher;
    private Integer numberOfPages;
    private Instant borrowedAt;
    private Instant dueAt;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private Instant dateOfPurchase;
    private Integer publicationAt;
    private boolean referenceOnly;
    private Instant updatedAt;
    private Long bookId;
    //private Rack placedAt;
    private Book book;

    public BookItem(){};

    public BookItem(long bookItemID, long barcode, String publisher, int numberOfPages,
                    Instant borrowedAt, Instant dueAt, double price,
                    BookFormat format, BookStatus status, Instant dateOfPurchase,
                    Integer publicationAt, Instant updatedAt, Long bookId) {
        this.bookItemID = bookItemID;
        this.barcode = barcode;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.borrowedAt = borrowedAt;
        this.dueAt = dueAt;
        this.price = price;
        this.format = format;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
        this.publicationAt = publicationAt;
        this.updatedAt = updatedAt;
        this.bookId = bookId;

    }

    public BookItem(long bookItemID, long barcode, String publisher, int numberOfPages, Instant borrowedAt, Instant dueAt, double price,
                    BookFormat format, BookStatus status, Instant dateOfPurchase, Integer publicationAt, Instant updatedAt) {
        this.bookItemID = bookItemID;
        this.barcode = barcode;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.borrowedAt = borrowedAt;
        this.dueAt = dueAt;
        this.price = price;
        this.format = format;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
        this.publicationAt = publicationAt;
        this.updatedAt = updatedAt;

    }


    public static BookItem parse(String record){
        BookItem bookItem = new BookItem();
        String[]fields = record.split(",");
        bookItem.bookItemID = Long.parseLong(fields[0]);
        bookItem.barcode = Long.parseLong(fields[1]);
        bookItem.publisher = fields[2];
        bookItem.numberOfPages = Integer.parseInt(fields[3]);
        bookItem.borrowedAt = InstantUtils.parseInstant(fields[4]);
        bookItem.dueAt = InstantUtils.parseInstant(fields[5]);
        bookItem.price = Double.parseDouble(fields[6]);
        bookItem.format = BookFormat.parserBookFormat(fields[7]);
        bookItem.status = BookStatus.parseBookStatus(fields[8]);
        bookItem.dateOfPurchase = InstantUtils.parseInstant(fields[9]);
        bookItem.publicationAt = Integer.parseInt(fields[10]);
        bookItem.updatedAt = InstantUtils.parseInstant(fields[11]);
        bookItem.bookId = Long.parseLong(fields[12]) ;
        return bookItem;
    }

    public long getBookItemID() {
        return bookItemID;
    }

    public void setBookItemID(long bookItemID) {
        this.bookItemID = bookItemID;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
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

    public Integer getPublicationAt() {
        return publicationAt;
    }

    public void setPublicationAt(Integer publicationAt) {
        this.publicationAt = publicationAt;
    }

    public boolean isReferenceOnly() {
        return referenceOnly;
    }

    public void setReferenceOnly(boolean referenceOnly) {
        this.referenceOnly = referenceOnly;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }




    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                bookItemID,
                barcode ,
                publisher,
                numberOfPages,
                borrowedAt ,
                dueAt ,
                price ,
                format ,
                status ,
                dateOfPurchase ,
                publicationAt ,
                updatedAt ,
                bookId );

    }
}


