package vn.hd.librus.model;

import java.time.Instant;

public class BookReservation {
    private Long bookItemBarcode;
    private Long userId;
    private Instant dueAt;
    private Instant returnAt;
    private Instant createdAt;
    private Instant updatedAt;

    public Long getBookItemBarcode() {
        return bookItemBarcode;
    }

    public void setBookItemBarcode(Long bookItemBarcode) {
        this.bookItemBarcode = bookItemBarcode;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
}
