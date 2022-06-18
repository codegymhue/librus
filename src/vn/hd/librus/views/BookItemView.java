package vn.hd.librus.views;

import vn.hd.librus.Constants;
import vn.hd.librus.model.BookFormat;
import vn.hd.librus.model.BookItem;
import vn.hd.librus.model.BookStatus;
import vn.hd.librus.model.User;
import vn.hd.librus.services.*;
import vn.hd.librus.utils.AppUtils;
import vn.hd.librus.utils.InstantUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.Period;

public class BookItemView {
    private IUserService userService;
    private IBookItemService bookItemService;
    private IBookLendingService bookLendingService;

//    public static void main(String[] args) {
//        BookItemView bookItemView = new BookItemView();
//
//    }


    public BookItemView() {
        userService = UserService.getInstance();
        bookItemService = BookItemService.getInstance();
    }


    public void update() throws ParseException {
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
            newBookItem.setBookItemID(id);

            switch (option) {
                case 1:
                    long barcode = inputBarcode(InputOption.UPDATE);
                    newBookItem.setBarcode(barcode);
                    bookItemService.update(newBookItem);
                    System.out.println("Barcode sách đã cập nhật thành công");
                    break;
                case 2:
                    Instant borrowedAt = Instant.now();
                    newBookItem.setBorrowedAt(borrowedAt);
                    bookItemService.update(newBookItem);
                    System.out.println("Ngày mượn sách đã cập nhật thành công");
                    break;
                case 3:
                    Instant dueAt = Instant.now().plus(Period.ofDays(Constants.MAX_LENDING_DAYS));
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
                    BookFormat bookFormat = inputBookFormat(InputOption.UPDATE);
                    newBookItem.setFormat(BookFormat.parserBookFormat(bookFormat.getValue()));
                    bookItemService.update(newBookItem);
                    System.out.println("Định dạng sách đã cập nhật thành công");
                    break;
                case 6:
                    BookStatus status = inputBookStatus(InputOption.UPDATE);
                    newBookItem.setStatus(status);
                    bookItemService.update(newBookItem);
                    System.out.println("Trạng thái của sách đã cập nhập thành công");
                    break;

                case 7:
                    Instant dateOfPurchase = inputDateOfPurchase(InputOption.UPDATE);
                    newBookItem.setDateOfPurchase(dateOfPurchase);
                    bookItemService.update(newBookItem);
                    System.out.println("Ngày mua sách đã cập nhật thành công");
                    break;
                case 8:
                    Integer publicationAt = inputPublicationAt(InputOption.UPDATE);
                    newBookItem.setPublicationAt(publicationAt);
                    bookItemService.update(newBookItem);
                    System.out.println("Ngày xuất bản sách đã cập nhật thành công");
                    break;
                case 9:
                    Instant updatedAt = inputUpdateAt(InputOption.UPDATE);
                    newBookItem.setUpdatedAt(updatedAt);
                    bookItemService.update(newBookItem);
                    System.out.println("Ngày updated sách đã cập nhật thành công");
                    break;
                case 10:
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
                "Sách");
        for (BookItem bookItem : bookItemService.findAll()) {
            System.out.printf(" %-15s %-15s %-15s %-15s %-15s %-15s %-15s  %-15s  %-15s %-15s %-15s  %-15s \n",
                    bookItem.getBookItemID(),
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
                    bookItem.getBook()
            );

        }
        System.out.println("--------------------------------------------------------------------------------------------------\n");
        if (inputOption == InputOption.SHOW) AppUtils.isRetry(InputOption.SHOW);
    }

    private void checkOutBook() {
        long barcode = inputBarcode(InputOption.OTHER);
        BookItem bookItem = bookItemService.findByBarcode(barcode);

        System.out.println("Thông tin sách " + bookItem);
        if (bookItem.isReferenceOnly()) {
            System.out.println("Sách này chỉ được đọc ở Thư Viện, không được phép mượn");
            return;
        }

        User user = userService.getCurrentUser();
        if (bookLendingService.isBookIssuedQuotaExceeded(user.getId())) {
            System.out.println("Người dùng đã mượn quá số lượng sách cho phép");
            return;
        }

        bookLendingService.lendBook(user.getId(), bookItem.getBookItemID());
        System.out.println("Mượn sách thành công");
    }

    private void returnBook() {
        long barcode = inputBarcode(InputOption.OTHER);
        BookItem bookItem = BookItemService.getInstance().findByBarcode(barcode);
        System.out.println("Thông tin sách " + bookItem);
        // check Fine
        // Tăng numberBook
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

    private long inputBarcode(InputOption option) {
        long barcode;
        switch (option) {
            case ADD:
                System.out.println("Nhập mã barcode cho sách:");
                break;
            case UPDATE:
                System.out.println("Nhập mã barcode cần sửa cho sách");
            case OTHER:
                System.out.println("Nhập mã barcodec của sách cần checkout");
                break;
        }
        boolean isRetry = false;
        do {
            barcode = AppUtils.retryParseLong();
            boolean exist = bookItemService.existByBarcode(barcode);
            switch (option) {
                case ADD:
                    if (exist) {
                        System.out.println("barcode sach này đã tồn tại. Vui lòng nhập barcode khác!");
                    }
                    isRetry = exist;
                    break;
                case OTHER:
                case UPDATE:
                    if (!exist) {
                        System.out.println("Không tìm thấy sach co barcode! Vui lòng nhập lại");
                    }
                    isRetry = !exist;
                    break;
            }
        } while (isRetry);
        return barcode;
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
        return InstantUtils.parseInstant("Ngày mượn sách");

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
        return InstantUtils.parseInstant("Ngày trả sách");
    }

    private Instant inputDateOfPurchase(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập ngày mua sách: ");
                break;
            case UPDATE:
                System.out.println("Nhập ngày mua sách mà bạn muốn sửa:");
                break;
        }
        return InstantUtils.parseInstant("Ngày mua sách");
    }

    private Instant inputUpdateAt(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập ngày update sách: ");
                break;
            case UPDATE:
                System.out.println("Nhập ngày update sách mà bạn muốn sửa:");
                break;
        }
        return InstantUtils.parseInstant("Ngày update sách");
    }

    private int inputPublicationAt(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập năm phát hành sách: ");
                break;
            case UPDATE:
                System.out.println("Nhập năm phát hành sách mà bạn muốn sửa:");
                break;
        }
        return AppUtils.retryParseInt();
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
        return AppUtils.retryParseDouble();
    }

    private BookFormat inputBookFormat(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập kiểu định dạng của sách: PAPERBACK|HARDCOVER|NEWSPAPER|MAGAZINE|EBOOK ");
                break;
            case UPDATE:
                System.out.println("Nhập kiểu định dạng của sách muốn sửa: PAPERBACK|HARDCOVER|NEWSPAPER|MAGAZINE|EBOOK ");
                break;
        }
        return BookFormat.parserBookFormat(AppUtils.retryString(""));
    }

    private BookStatus inputBookStatus(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập trạng thái của sách: AVAILABLE|RESERVED|LOANED|LOST");
                break;
            case UPDATE:
                System.out.println("Nhập trạng thái sách muốn sửa: AVAILABLE|RESERVED|LOANED|LOST ");
                break;
        }
        return BookStatus.parseBookStatus(AppUtils.retryString("Trạng thái"));
    }


    private Long inputBookId(InputOption option) {
        switch (option) {
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
