package vn.hd.librus.model;

import vn.hd.librus.utils.InstantUtils;

import java.time.Instant;

public class BookReservation {
    private Long id;
    private Long bookItemBarcode;
    private Long userId;
    private Instant dueAt;
    private Instant returnAt;
    private Instant createdAt;
    private Instant updatedAt;

    public static BookReservation parse(String raw) {
        BookReservation reservation = new BookReservation();
        String[] fields = raw.split(",");
        reservation.id = Long.parseLong(fields[0]);
        reservation.bookItemBarcode = Long.parseLong(fields[1]);
        reservation.userId = Long.parseLong(fields[2]);
        reservation.dueAt = InstantUtils.parseInstant(fields[3]);
        reservation.returnAt = InstantUtils.parseInstant(fields[4]);
        reservation.createdAt = InstantUtils.parseInstant(fields[5]);
        reservation.updatedAt = InstantUtils.parseInstant(fields[6]);
        return reservation;
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

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                id,
                bookItemBarcode,
                userId,
                dueAt,
                returnAt,
                createdAt,
                updatedAt
        );
    }
}
