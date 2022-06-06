package vn.hd.librus.model;

import java.time.Instant;

public class Fine {
    private Long id;
    private Long bookItemBarcode;
    private Long userId;
    private Instant createdAt;

    public static Fine parse(String record) {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
