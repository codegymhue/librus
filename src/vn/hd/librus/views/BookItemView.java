package vn.hd.librus.views;

import vn.hd.librus.model.BookFormat;
import vn.hd.librus.model.BookItem;
import vn.hd.librus.model.BookStatus;
import vn.hd.librus.services.BookItemService;
import vn.hd.librus.services.IBookItemService;
import vn.hd.librus.utils.AppUtils;

import java.time.Instant;
import java.util.Scanner;

public class BookItemView {

    private IBookItemService bookItemService;
    private final Scanner scanner = new Scanner(System.in);


    public BookItemView() {
        bookItemService = BookItemService.getInstance();
    }

    public void add() {
        do {
            long id = System.currentTimeMillis() / 1000;
            long barcode = inputBarcode(InputOption.ADD);
            Instant borrowedAt = inputBorrowedAt(InputOption.ADD);
            Instant dueAt = inputDueAt(InputOption.ADD);
            double price = inputPrice(InputOption.ADD);
            String format = inputBookFormat(InputOption.ADD);
            String status = inputBookStatus(InputOption.ADD);
            Instant dateOfPurchase = inputDateOfPurchase(InputOption.ADD);
            Instant publicationAt = inputPulicationAt(InputOption.ADD);
            Instant updatedAt = inputUpdateAt(InputOption.ADD);
            Long bookId = inputBookId(InputOption.ADD);
            BookItem newBookItem = new BookItem(id, barcode, borrowedAt, dueAt, price, format,
                    status,dateOfPurchase,publicationAt,updatedAt,bookId);
            System.out.println("Bạn đã thêm BookItem thành công\n");

        } while (AppUtils.isRetry(InputOption.ADD));
    }

    public void update() {
        boolean isRetry;
        do {
            showBooksItem(InputOption.UPDATE);
            long id = inputId(InputOption.UPDATE);
            System.out.println("┌ - - - - - - - SỬA  - - - - - ┐");
            System.out.println("| 1.Sửa barcode                |");
            System.out.println("| 2.Sửa ngày mượn sách         |");
            System.out.println("| 3.Sửa ngày trả sách          |");
            System.out.println("| 4.Sửa giá sách               |");
            System.out.println("| 5.Sửa định dạng sách         |");
            System.out.println("| 6.Sửa trạng thái sách        |");
            System.out.println("| 7.Sửa ngày mua sách          |");
            System.out.println("| 8.Sửa ngày xuất bản sách     |");
            System.out.println("| 9.Sửa ngày update sách       |");
            System.out.println("| 10.Quay lại Menu             |");
            System.out.println("└ - - - - - -  - - - - - - - - ┘");
            System.out.println("Chọn chức năng: ");
            int option = AppUtils.retryChoose(1, 10);
            BookItem newBookItem = new BookItem();
            newBookItem.setId(id);

            switch (option) {
                case 1:
                    long barcode = inputBarcode(InputOption.UPDATE);
                    newBookItem.setBarcode(barcode);
                    bookItemService.update(newBookItem);
                    System.out.println("Barcode sách đã cập nhật thành công");
                    break;
                case 2:
                    Instant borrowedAt  = inputBorrowedAt(InputOption.UPDATE);
                    newBookItem.setBorrowedAt(borrowedAt);
                    bookItemService.update(newBookItem);
                    System.out.println("Ngày mượn sách đã cập nhật thành công");
                    break;
                case 3:
                    Instant dueAt = inputDueAt(InputOption.UPDATE);
                    newBookItem.setDueAt(dueAt);
                    bookItemService.update(newBookItem);
                    System.out.println("Ngày trả sách đã cập nhật thành công");
                    break;
                case 4:
                    double price = inputPrice(InputOption.UPDATE);
                    newBookItem.setPrice(price);
                    bookItemService.update(newBookItem);
                    System.out.println("Gía sách đã cập nhật thành công");
                    break;
                case 5:
                    String bookFormat = inputBookFormat(InputOption.UPDATE);
                    newBookItem.setFormat(BookFormat.parserBookFormat(bookFormat));
                    bookItemService.update(newBookItem);
                    System.out.println("Định dạng sách đã cập nhật thành công");
                    break;
                case 6:
                    String status = inputBookStatus(InputOption.UPDATE);
                    newBookItem.setStatus(BookStatus.parseBookStatus(status));
                    bookItemService.update(newBookItem);
                    System.out.println("Trạng thái sách đã cập nhật thành công");
                    break;
                case 7 :
                    Instant dateOfPurchase = inputDateOfPurchase(InputOption.UPDATE);
                    newBookItem.setDateOfPurchase(dateOfPurchase);
                    bookItemService.update(newBookItem);
                    System.out.println("Ngày mua sách đã cập nhật thành công");
                    break;
                case 8 :
                    Instant publicationAt = inputPulicationAt(InputOption.UPDATE);
                    newBookItem.setPublicationAt(publicationAt);
                    bookItemService.update(newBookItem);
                    System.out.println("Ngày xuất bản sách đã cập nhật thành công");
                    break;
                case 9 :
                    Instant updatedAt = inputUpdateAt(InputOption.UPDATE);
                    newBookItem.setUpdatedAt(updatedAt);
                    bookItemService.update(newBookItem);
                    System.out.println("Ngày updated sách đã cập nhật thành công");
                    break;
                case 10 :
                    break;

            }
            isRetry = option != 10 && AppUtils.isRetry(InputOption.UPDATE);
        } while (isRetry);
    }



    //Tái sử dụng khi vn.hd.librus.sort tránh đổi thứ tự list gốc
    public void showBooksItem(InputOption inputOption) {
        System.out.println("-----------------------------------------BOOK ITEM-------------------------------------------");
        System.out.printf(" %-15s %-15s %-15s %-15s %-15s %-15s %-15s  %-15s  %-15s %-15s %-15s  %-15s \n",
                "Id",
                "Barcode",
                "Ngày mượn sách",
                "Ngày trả sách",
                "Gía sách",
                "Định dạng sách",
                "Trạng thái sách",
                "Ngày mua sách",
                "Ngày xuất bản sách",
                "Ngày update",
                "Id của sách",
                "Sách",
        "");
        for (BookItem bookItem : bookItemService.findAll()) {
            System.out.printf(" %-15s %-15s %-15s %-15s %-15s %-15s %-15s  %-15s  %-15s %-15s %-15s  %-15s \n",
                    bookItem.getId(),
                    bookItem.getBarcode(),
                    bookItem.getBorrowedAt(),
                    bookItem.getDueAt(),
                    bookItem.getPrice(),
                    bookItem.getFormat(),
                    bookItem.getStatus(),
                    bookItem.getDateOfPurchase(),
                    bookItem.getPublicationAt(),
                    bookItem.getUpdatedAt(),
                    bookItem.getBookId(),
                    bookItem.getBook(),
                    "");

        }
        System.out.println("--------------------------------------------------------------------------------------------------\n");
        if (inputOption == InputOption.SHOW) AppUtils.isRetry(InputOption.SHOW);
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
            boolean exist = bookItemService.existById(id);
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

    private long inputBarcode(InputOption option){
        switch (option){
            case ADD:
                System.out.println("Nhập mã barcode cho sách:");
                break;
            case UPDATE:
                System.out.println("Nhập mã barcode cần sửa cho sách");
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

    private Instant inputDueAt(InputOption option) {
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

    private Instant inputDateOfPurchase(InputOption option){
        switch (option){
            case ADD:
                System.out.println("Nhập ngày mua sách: ");
                break;
            case UPDATE:
                System.out.println("Nhập ngày mua sách mà bạn muốn sửa:");
                break;
        }
        return Instant.parse(AppUtils.retryString("Ngày mua sách"));
    }

    private Instant inputUpdateAt (InputOption option){
        switch (option){
            case ADD:
                System.out.println("Nhập ngày update sách: ");
                break;
            case UPDATE:
                System.out.println("Nhập ngày update sách mà bạn muốn sửa:");
                break;
        }
        return Instant.parse(AppUtils.retryString("Ngày update sách"));
    }

    private Instant inputPulicationAt(InputOption option){
        switch (option){
            case ADD:
                System.out.println("Nhập ngày phát hành sách: ");
                break;
            case UPDATE:
                System.out.println("Nhập ngày phát hành sách mà bạn muốn sửa:");
                break;
        }
        return Instant.parse(AppUtils.retryString("Ngày phát hành sách"));
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
                System.out.println("Nhập kiểu định dạng của sách:(Paperback/hardcover/newspaper/magazine/ebook) ");
                break;
            case UPDATE:
                System.out.println("Nhập kiểu định dạng của sách muốn sửa:(Paperback/hardcover/newspaper/magazine/ebook) ");
                break;
        }
        return AppUtils.retryString("Kiểu định dạng");
    }

    private String inputBookStatus(InputOption option){
        switch (option) {
            case ADD:
                System.out.println("Nhập trạng thái của sách : ");
                break;
            case UPDATE:
                System.out.println("Nhập trạng thái của sách muốn sửa: ");
                break;
        }
        return AppUtils.retryString("Kiểu định dạng");
    }

    private Long inputBookId(InputOption option){
        switch (option){
            case ADD:
                System.out.println("Nhập Id của sách");
                break;
            case UPDATE:
                System.out.println("Nhập Id của sách muốn sửa");
                break;
        }
        return AppUtils.retryParseLong();
    }
}
