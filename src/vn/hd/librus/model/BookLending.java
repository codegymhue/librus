package vn.hd.librus.model;

import java.time.Instant;

public class BookLending {
    private Long bookItemBarcode;
    private Long userId;
    private Instant createdAt;
    private Instant dueAt;
    private Instant returnAt;

    public Long getBookItemBarcode() {
        return bookItemBarcode;
    }

    public void setBookItemBarcode(Long bookItemBarcode) {
        this.bookItemBarcode = bookItemBarcode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getDueAt() {
        return dueAt;
    }

    public void setDueAt(Instant dueAt) {
        this.dueAt = dueAt;
    }

    public Instant getReturnAt() {
        return returnAt;
    }

    public void setReturnAt(Instant returnAt) {
        this.returnAt = returnAt;
    }
}
