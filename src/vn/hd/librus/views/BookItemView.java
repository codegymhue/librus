package vn.hd.librus.views;

import vn.hd.librus.model.BookItem;
import vn.hd.librus.services.BookService;
import vn.hd.librus.services.IBookService;
import vn.hd.librus.utils.AppUtils;

import java.time.Instant;
import java.util.Scanner;

public class BookItemView {
    private IBookService bookService; //Dependency Inversion Principle (SOLID)
    private final Scanner scanner = new Scanner(System.in);
    public BookItemView() {
        bookService = BookService.getInstance();
    }

    public void add() {
        do {
            //long id = inputId(InputOption.ADD);
            //long id = System.currentTimeMillis() / 1000;
            String isbn = inputISBN(InputOption.ADD);
            long barcode = inputBarcode(InputOption.ADD);
            //String author = inputBorrowedAt(InputOption.ADD);
            //   String subject = InputDueAt(InputOption.ADD);
            // String publisher = inputPrice(InputOption.ADD);
            String language = inputBookFormat(InputOption.ADD);
            int numberOfPages = inputNumberOfPages(InputOption.ADD);
            //    Book newBook = new Book( isbn, title, author, subject, publisher, language, numberOfPages);
            //   bookService.add(newBook);
            System.out.println("Bạn đã thêm sách thành công\n");

        } while (AppUtils.isRetry(InputOption.ADD));
    }

    public void update() {
        boolean isRetry;
        do {
            //showBooks(InputOption.UPDATE);
            //  String id = inputISBN(InputOption.UPDATE);
            long id = inputId(InputOption.UPDATE);
            System.out.println("┌ - - - - SỬA  - - - ┐");
            System.out.println("| 1.Sửa tên sách     |");
            System.out.println("| 2.Sửa tác giả      |");
            System.out.println("| 3.Sửa chủ đề       |");
            System.out.println("| 4.Sửa nhà xuất bản |");
            System.out.println("| 5.Sửa ngôn ngữ     |");
            System.out.println("| 6.Sửa số trang     |");
            System.out.println("| 7.Quay lại MENU    |");
            System.out.println("└ - - - - - -  - - - ┘");
            System.out.println("Chọn chức năng: ");
            int option = AppUtils.retryChoose(1, 7);
            BookItem newBookItem = new BookItem();
            newBookItem.setId(id);
            //newBook.setId(id);
            switch (option) {
                case 1:
//                    long title = inputBarcode(InputOption.UPDATE);
//                    newBookItem.setTitle(title);
//                    bookService.update(newBook);
//                    System.out.println("Tên sách đã cập nhật thành công");
                    break;
                case 2:
//                    String author = inputBorrowedAt(InputOption.UPDATE);
//                    newBook.setAuthor(author);
//                    bookService.update(newBook);
//                    System.out.println("Tác giả đã cập nhật thành công");
                    break;
                case 3:
//                    String subject = InputDueAt(InputOption.UPDATE);
//                    newBook.setSubject(subject);
//                    bookService.update(newBook);
//                    System.out.println("Tác giả đã cập nhật thành công");
                    break;
                case 4:
//                    String publisher = inputPrice(InputOption.UPDATE);
//                    newBook.setPublisher(publisher);
//                    bookService.update(newBook);
//                    System.out.println("Tác giả đã cập nhật thành công");
                    break;
                case 5:
//                    String language = inputBookFormat(InputOption.UPDATE);
//                    newBook.setPublisher(language);
//                    bookService.update(newBook);
//                    System.out.println("Tác giả đã cập nhật thành công");
                    break;
                case 6:
//                    int numberOfPages = inputNumberOfPages(InputOption.UPDATE);
//                    newBook.setNumberOfPages(numberOfPages);
//                    bookService.update(newBook);
//                    System.out.println("Số trang sách thành công");
                    break;
            }
            isRetry = option != 7 && AppUtils.isRetry(InputOption.UPDATE);
        } while (isRetry);
    }


    //Tái sử dụng khi vn.hd.librus.sort tránh đổi thứ tự list gốc
    public void showBooks(InputOption inputOption) {
        System.out.println("-----------------------------------------DANH SÁCH SÁCH-------------------------------------------");
        System.out.printf(" %-10s %-20s %-15s %-15s %-15s %-10s %-10s  %-10s  %-10s \n",
                "ISBN",
                "Tên sách",
                "Tác giả",
                "Chủ đề",
                "Nhà xuất bản",
                "Ngôn ngữ",
                "Số trang",
                "Ngày tạo",
                "Ngày cập nhật");
//        for (Book book : bookService.findAll()) {
//            System.out.printf(" %-10s %-20s %-15s %-15s %-15s %-10s %-10s  %-10s  %-10s \n",
//                    //book.getId(),
//                    book.getIsbn(),
//                    book.getTitle(),
//                    book.getAuthor(),
//                    book.getSubject(),
//                    book.getPublisher(),
//                    book.getLanguage(),
//                    book.getNumberOfPages(),
//                    InstantUtils.instantToString(book.getCreatedAt()),
//                    book.getUpdatedAt() == null ? "" : InstantUtils.instantToString(book.getUpdatedAt()));
//        }
//        System.out.println("--------------------------------------------------------------------------------------------------\n");
//        if (inputOption == InputOption.SHOW) AppUtils.isRetry(InputOption.SHOW);
    }

    public void remove() {
        showBooks(InputOption.DELETE);
        long id;
        while (!bookService.existsById(id = inputId(InputOption.DELETE))) {
            System.out.println("Không tìm thấy sản phẩm cần xóa");
            System.out.println("Nhấn 'y' để thêm tiếp \t|\t 'q' để quay lại \t|\t 't' để thoát chương trình");
            System.out.print(" ⭆ ");
            String option = scanner.nextLine();
            switch (option) {
                case "y":
                    break;
                case "q":
                    return;
                case "t":
                    AppUtils.exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    break;
            }
        }

        System.out.println("❄ ❄ ❄ ❄ REMOVE COMFIRM ❄ ❄ ❄");
        System.out.println("❄  1. Nhấn 1 để xoá        ❄");
        System.out.println("❄  2. Nhấn 2 để quay lại   ❄");
        System.out.println("❄ ❄ ❄ ❄ ❄ ❄ ❄  ❄ ❄ ❄ ❄ ❄ ❄ ❄");
        int option = AppUtils.retryChoose(1, 2);
        if (option == 1) {
            bookService.deleteById(id);
            System.out.println("Đã xoá sản phẩm thành công! \uD83C\uDF8A");
            AppUtils.isRetry(InputOption.DELETE);
        }

    }

    private long inputId(InputOption option) {
        long id;
        switch (option) {
            case ADD:
                System.out.println("Nhập Id");
                break;
            case UPDATE:
                System.out.println("Nhập id bạn muốn sửa");
                break;
            case DELETE:
                System.out.println("Nhập id bạn cần xoá: ");
                break;
        }
        boolean isRetry = false;
        do {
            id = AppUtils.retryParseLong();
            boolean exist = bookService.existsById(id);
            switch (option) {
                case ADD:
                    if (exist) {
                        System.out.println("Id này đã tồn tại. Vui lòng nhập id khác!");
                    }
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist) {
                        System.out.println("Không tìm thấy id! Vui lòng nhập lại");
                    }
                    isRetry = !exist;
                    break;
            }
        } while (isRetry);
        return id;
    }

    private long inputBarcode(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập mã Barcode ");
                break;
            case UPDATE:
                System.out.println("Nhập mã Barcode muốn sửa: ");
                break;
        }
        return AppUtils.retryParseLong();

    }

    private Instant inputBorrowedAt(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập ngày mượn sách ");
                break;
            case UPDATE:
                System.out.println("Nhập ngày mượn sách muốn sửa: ");
                break;
        }
        return Instant.parse(AppUtils.retryString("Mã Barcode"));

    }

    private Instant InputDueAt(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập ngày trả sách ");
                break;
            case UPDATE:
                System.out.println("Nhập ngày trả sách muốn sửa: ");
                break;
        }
        return Instant.parse(AppUtils.retryString("Hạn trả sách"));

    }

    private double inputPrice(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập giá sách : ");
                break;
            case UPDATE:
                System.out.println("Nhập giá sách muốn sửa: ");
                break;
        }
        return (AppUtils.retryParseDouble());
    }

    private String inputBookFormat(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập ngôn ngữ của sách: ");
                break;
            case UPDATE:
                System.out.println("Nhập ngôn ngữ của sách muốn sửa: ");
                break;
        }
        return AppUtils.retryString("Ngôn ngữ sách");
    }

    private String inputISBN(InputOption option) {
        String isbn;
        switch (option) {
            case ADD:
                System.out.println("Nhập ISBN");
                break;
            case UPDATE:
                System.out.println("Nhập ISBN bạn muốn sửa");
                break;
            case DELETE:
                System.out.println("Nhập ISBN bạn cần xoá: ");
                break;
        }
        boolean isRetry = false;
        do {
            isbn = AppUtils.retryString("ISBN");
            boolean exist = bookService.existByISBN(isbn);
            switch (option) {
                case ADD:
                    if (exist) {
                        System.out.println("ISBN này đã tồn tại. Vui lòng nhập isbn khác!");
                    }
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist) {
                        System.out.println("Không tìm thấy isbn! Vui lòng nhập lại");
                    }
                    isRetry = !exist;
                    break;
            }
        } while (isRetry);
        return isbn;
    }

    private int inputNumberOfPages(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập số trang sách: ");
                break;
            case UPDATE:
                System.out.println("Nhập số trang sách muốn sửa: ");
                break;
        }
        int numberOfPages;
        do {
            numberOfPages = AppUtils.retryParseInt();
            if (numberOfPages <= 0) System.out.println("Số trang phải lớn hơn 0 (số trang > 0)");
        } while (numberOfPages <= 0);
        return numberOfPages;
    }


    public void showBookSort() {


    }

//    public void showProductsSort(InputOption inputOption, List<Bô> products) {
//        System.out.println("-----------------------------------------DANH SÁCH BÁNH-------------------------------------------");
//        System.out.printf("%-15s %-30s %-25s %-10s %-20s %-20s %-20s\n", "Id", "Tên bánh", "Giá bánh", "Số lượng", "Ngày tạo", "Ngày cập nhật", "Mô tả");
//        for (Product product : products) {
//            System.out.printf("%-15d %-30s %-25s %-10d %-20s %-20s %-20s\n", product.getId(), product.getTitle(), AppUtils.doubleToVND(product.getPrice()), product.getQuantity(), InstantUtils.instantToString(product.getCreatedAt()), product.getUpdatedAt() == null ? "" : InstantUtils.instantToString(product.getUpdatedAt()), product.getDescription());
//        }
//        System.out.println("--------------------------------------------------------------------------------------------------\n");
//        if (inputOption == InputOption.SHOW) AppUtils.isRetry(InputOption.SHOW);
//    }

//    public void sortByPriceOrderByASC() {
//        showProductsSort(InputOption.SHOW, bookService.findAllOrderByPriceASC());
//    }
//
//    public void sortByPriceOrderByDESC() {
//        showProductsSort(InputOption.SHOW, bookService.findAllOrderByPriceDESC());
//    }

}
