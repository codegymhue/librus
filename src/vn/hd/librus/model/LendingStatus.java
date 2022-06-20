package vn.hd.librus.model;

public enum LendingStatus {
    LENDING("LENDING"),
    DUE("DUE"),
    RETURN("RETURN");

    private final String value;

    private LendingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static LendingStatus parseRole(String value) {
        for (LendingStatus status : values()) {
            if (status.value.equals(value))
                return status;
        }

        throw new IllegalArgumentException("Invalid role value : " + value);
    }
}
