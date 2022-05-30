package vn.hd.librus.model;

public enum BookFormat {
    PAPERBACK ("PaperBack"),
    HARDCOVER ("HardCover"),
    NEWSPAPER ("Newspaper"),
    MAGAZINE ("Magazine"),
    EBOOK ("Ebook");

    private String value;
    private BookFormat(String value){this.value = value ;}
    public String getValue(){return  this.value;}

//    public static BookFormat bookFormat(String value) {
//        BookFormat[] values = values();
//        for (BookFormat bookFormat : values) {
//            if (bookFormat.value.equals(value))
//                return bookFormat;
//        }
//
//        throw new IllegalArgumentException("Invalid BookFormat value : " + value);
//
//    }
}
