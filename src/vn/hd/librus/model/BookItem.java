//package librarymanagement.hangdinh.vn.model;
//
//import java.util.Date;
//
//public class BookItem extends Book{
//    private String barcode;
//    private Date borrowed;
//    private Date dueDate;
//    private double price;
//    private BookFormat format;
//    private BookStatus status;
//    private Date dateOfPurchase;
//    private Date publication ;
//    boolean isReferenceOnly ;
//
//    public BookItem(String ISBN, String title, String subject, String publisher, String language, int numberOfPage) {
//        super(ISBN, title, subject, publisher, language, numberOfPage);
//    }
//
//    public BookItem(String ISBN, String title, String subject, String publisher, String language, int numberOfPage, String barcode, Date borrowed, Date dueDate, double price, BookFormat format, BookStatus status, Date dateOfPurchase, Date publication, boolean isReferenceOnly) {
//        super(ISBN, title, subject, publisher, language, numberOfPage);
//        this.barcode = barcode;
//        this.borrowed = borrowed;
//        this.dueDate = dueDate;
//        this.price = price;
//        this.format = format;
//        this.status = status;
//        this.dateOfPurchase = dateOfPurchase;
//        this.publication = publication;
//        this.isReferenceOnly = isReferenceOnly;
//    }
//
//    public String getBarcode() {
//        return barcode;
//    }
//
//    public void setBarcode(String barcode) {
//        this.barcode = barcode;
//    }
//
//    public Date getBorrowed() {
//        return borrowed;
//    }
//
//    public void setBorrowed(Date borrowed) {
//        this.borrowed = borrowed;
//    }
//
//    public Date getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(Date dueDate) {
//        this.dueDate = dueDate;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public BookFormat getFormat() {
//        return format;
//    }
//
//    public void setFormat(BookFormat format) {
//        this.format = format;
//    }
//
//    public BookStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(BookStatus status) {
//        this.status = status;
//    }
//
//    public Date getDateOfPurchase() {
//        return dateOfPurchase;
//    }
//
//    public void setDateOfPurchase(Date dateOfPurchase) {
//        this.dateOfPurchase = dateOfPurchase;
//    }
//
//    public Date getPublication() {
//        return publication;
//    }
//
//    public void setPublication(Date publication) {
//        this.publication = publication;
//    }
//
//    public boolean isReferenceOnly() {
//        return isReferenceOnly;
//    }
//
//    public void setReferenceOnly(boolean referenceOnly) {
//        isReferenceOnly = referenceOnly;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
//                barcode,
//                borrowed,
//                dueDate,
//                price,
//                format,
//                status,
//                dateOfPurchase,
//                publication,
//                isReferenceOnly);
//
//    }
//}
