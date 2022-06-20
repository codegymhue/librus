package vn.hd.librus.model;

import vn.hd.librus.utils.InstantUtils;

import java.time.Instant;

public class Fine {
    private Long id;
    private Long bookItemId;
    private Long userId;
    private Instant createdAt;

    public Fine(long id, long bookItemId, long userId, Instant createdAt) {
        this.id =id ;
        this.bookItemId = bookItemId;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public static Fine parse(String record) {
        String[] fields = record.split(",");
        long id = Long.parseLong(fields[0]);
        long bookItemId = Long.parseLong(fields[1]);
        long userId = Long.parseLong(fields[2]);
        Instant createdAt = InstantUtils.parseInstant(fields[3]);
        return new Fine(id,bookItemId,userId,createdAt) ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookItemId() {
        return bookItemId;
    }

    public void setBookItemId(Long bookItemId) {
        this.bookItemId = bookItemId;
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

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",
                id,
                bookItemId,
                userId,
                createdAt);
    }
}
