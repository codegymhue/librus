package vn.hd.librus.views;

import vn.hd.librus.Constants;
import vn.hd.librus.model.*;
import vn.hd.librus.services.*;
import vn.hd.librus.utils.AppUtils;
import vn.hd.librus.utils.InstantUtils;

import java.time.Duration;


public class BookItemView {
    private final IUserService userService;
    private final IBookItemService bookItemService;
    private final IBookLendingService bookLendingService;


    public BookItemView() {
        userService = UserService.getInstance();
        bookItemService = BookItemService.getInstance();
        bookLendingService = BookLendingService.getInstance();
    }


    public void update() {
        boolean isRetry;
        do {
            showBooksItem(InputOption.UPDATE);
            long id = inputId(InputOption.UPDATE);
            System.out.println("┌ - - - - - - -  SỬA - - - - - - - ┐");
            System.out.println("|   1. Sửa nhà xuất bản            |");
            System.out.println("|   2. Sửa năm xuất bản            |");
            System.out.println("|   3. Sửa giá sách                |");
            System.out.println("|   4. Sửa định dạng sách          |");
            System.out.println("|   5. Sửa trạng thái sách         |");
            System.out.println("|   6. Quay lại Menu               |");
            System.out.println("└ - - - - - - - - - - - - - - - - -┘");
            System.out.println("Chọn chức năng: ");
            int option = AppUtils.retryChoose(1, 6);
            BookItem newBookItem = new BookItem();
            newBookItem.setBookItemID(id);

            switch (option) {

                case 1:
                    String publisher = inputPublisher(InputOption.UPDATE);
                    newBookItem.setPublisher(publisher);
                    bookItemService.update(newBookItem);
                    System.out.println("Nhà xuất bản đã cập nhập thành công");
                    break;
                case 2:
                    Integer publicationAt = inputPublicationAt(InputOption.UPDATE);
                    newBookItem.setPublicationAt(publicationAt);
                    bookItemService.update(newBookItem);
                    System.out.println("Năm xuất bản đã cập nhập thành công");
                    break;
                case 3:
                    double price = inputPrice(InputOption.UPDATE);
                    newBookItem.setPrice(price);
                    bookItemService.update(newBookItem);
                    System.out.println("Gía sách đã cập nhật thành công");
                    break;
                case 4:
                    BookFormat bookFormat = inputBookFormat(InputOption.UPDATE);
                    newBookItem.setFormat(BookFormat.parserBookFormat(bookFormat.getValue()));
                    bookItemService.update(newBookItem);
                    System.out.println("Định dạng sách đã cập nhật thành công");
                    break;
                case 5:
                    BookStatus status = inputBookStatus(InputOption.UPDATE);
                    newBookItem.setStatus(status);
                    bookItemService.update(newBookItem);
                    System.out.println("Trạng thái của sách đã cập nhập thành công");
                    break;

                case 6:
                    break;

            }
            isRetry = option != 6 && AppUtils.isRetry(InputOption.UPDATE);
        } while (isRetry);
    }


    public void showBooksItem(InputOption inputOption) {
        System.out.println("--------------------------------------------------------------- BOOK ITEM --------------------------------------------------------------------");
        System.out.printf(" %-10s %-15s %-10s %-8s %-10s %-14s %-14s %-16s %-16s %-16s \n",
                "Id",
                "Tên sách",
                "Nhà XB",
                "Năm XB",
                "Gía sách",
                "Định dạng ",
                "Trạng thái ",
                "Ngày nhập vào TV",
                "Ngày mượn sách",
                "Hạn trả sách"

        );
        for (BookItem bookItem : bookItemService.findAll()) {
            System.out.printf(" %-10s %-15s %-10s %-8s %-10s %-14s %-14s %-16s %-16s %-16s \n",
                    bookItem.getBookItemID(),
                    bookItem.getBook().getTitle(),
                    bookItem.getPublisher(),
                    bookItem.getPublicationAt(),
                    AppUtils.doubleToVND(bookItem.getPrice()),
                    bookItem.getFormat(),
                    bookItem.getStatus(),
                    bookItem.getDateOfPurchase() == null ? "" : InstantUtils.instantToString(bookItem.getDateOfPurchase()),
                    bookItem.getBorrowedAt() == null ? "" : InstantUtils.instantToString(bookItem.getBorrowedAt()),
                    bookItem.getDueAt() == null ? "" : InstantUtils.instantToString(bookItem.getDueAt())
            );
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------\n");
        if (inputOption == InputOption.SHOW)
            AppUtils.isRetry(InputOption.SHOW);
    }

    public void checkoutBook() {

        long id = inputId(InputOption.CHECKOUT);
        BookItem bookItem = bookItemService.findById(id);
        System.out.println("Thông tin của sách: " + bookItem);
        if (bookItem.isReferenceOnly()) {
            System.out.println("Sách này chỉ được đọc ở Thư Viện, không được phép mượn");
            return;
        }
        long userId = inputUserId();
        if (bookLendingService.isBookIssuedQuotaExceeded(userId)) {
            System.out.println("Người dùng đã mượn quá số lượng sách cho phép");
            return;
        }

        bookLendingService.lendBook(userId, bookItem.getBookItemID());
        System.out.println("Bạn đã mượn sách thành công");
    }

    void returnBook() {

        long userId = inputUserId();
        BookLending bookLending = bookLendingService.findByUserId(userId);
        long bookItemId = inputId(InputOption.RETURN);
        BookItem bookItem = bookItemService.findById(bookItemId);
        System.out.println("Thông tin sách muốn trả : " + bookItem);

        if (bookLending == null) {
            System.out.println("Người dùng này chưa mượn sách ở thư viện ! BookItem này thuộc người dùng khác");
            return;
        } else System.out.println("Thông tin BookLending :" + bookLending);

        Duration duration = Duration.between(bookLending.getCreatedAt(), bookLending.getDueAt());
        System.out.println("Số ngày mượn cuốn sách tính tới hiện tại là: " + duration.toDays());

        if (duration.toDays() > Constants.MAX_LENDING_DAYS) {
            System.out.println("Người dùng vượt quá số ngày cho phép");
            System.out.println("Người dùng bị phạt 100.000đ");
            return;
        }
        bookLendingService.returnBook(bookLending.getUserId());
        System.out.println("Bạn đã trả sách thành công \uD83C\uDF8A");

    }


    private long inputId(InputOption option) {
        long id;
        switch (option) {
            case ADD:
                System.out.println("Nhập Id");
                break;
            case CHECKOUT:
                System.out.println("Nhập Id BookItem để checkout sách");
                break;
            case RETURN:
                System.out.println("Nhập Id BookItem để trả sách");
                break;
            case UPDATE:
                System.out.println("Nhập Id bạn muốn sửa");
                break;
            case DELETE:
                System.out.println("Nhập Id bạn cần xoá: ");
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

                case CHECKOUT:
                    if (!exist) {
                        System.out.println("Không tìm thấy sách ! Vui lòng nhập lại");
                    }
                    isRetry = !exist;
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

    private long inputUserId() {
        long userId;
        System.out.println("Nhập UserId :");
        while (!userService.existById(userId = AppUtils.retryParseLong())) {
            System.out.println("Không tìm thấy người dùng ! Vui lòng nhập lại");
        }
        return userId;
    }


    private String inputPublisher(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập nhà xuất bản: ");
                break;
            case UPDATE:
                System.out.println("Nhập nhà xuất bản muốn sửa: ");
                break;
        }
        return AppUtils.retryString("Chủ đề");
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
        int publicationAt;
        do {
            publicationAt = AppUtils.retryParseInt();
            if (publicationAt <= 0)
                System.out.println("Năm xuất bản phải lớn hơn 0 ");
        } while (publicationAt <= 0);
        return publicationAt;
    }


    private double inputPrice(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập giá sách: ");
                break;
            case UPDATE:
                System.out.println("Nhập giá sách bạn muốn sửa: ");
                break;
        }
        double price;
        do {
            price = AppUtils.retryParseDouble();
            if (price <= 0)
                System.out.println("Giá sách phải lớn hơn 0 (giá > 0)");
        } while (price <= 0);
        return price;
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
}
