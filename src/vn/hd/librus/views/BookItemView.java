package vn.hd.librus.views;
import vn.hd.librus.model.*;
import vn.hd.librus.services.*;
import vn.hd.librus.utils.AppUtils;
import vn.hd.librus.utils.InstantUtils;



public class BookItemView {
    private IUserService userService;
    private IBookItemService bookItemService;
    private IBookLendingService bookLendingService;

    public static void main(String[] args) {
        BookItemView bookItemView = new BookItemView();
        bookItemView.update();

    }


    public BookItemView() {
        userService = UserService.getInstance();
        bookItemService = BookItemService.getInstance();
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
            int option = AppUtils.retryChoose(1,6);
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
        System.out.printf(" %-11s %-11s %-12s %-12s %-12s %-14s %-14s %-16s %-16s %-16s \n",
                "Id",
                "Id sách",
                "Nhà xuất bản",
                "Năm xuất bản",
                "Gía sách",
                "Định dạng ",
                "Trạng thái ",
                "Ngày giao dịch",
                "Ngày mượn sách",
                "Ngày trả sách"

        );
        for (BookItem bookItem : bookItemService.findAll()) {
            System.out.printf(" %-11s %-11s %-12s %-12s %-12s %-14s %-14s %-16s %-16s %-16s \n",
                    bookItem.getBookItemID(),
                    bookItem.getBookId(),
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

//    private void checkOutBook() {
//        long barcode = inputBarcode(InputOption.OTHER);
//        BookItem bookItem = bookItemService.findByBarcode(barcode);
//
//        System.out.println("Thông tin sách " + bookItem);
//        if (bookItem.isReferenceOnly()) {
//            System.out.println("Sách này chỉ được đọc ở Thư Viện, không được phép mượn");
//            return;
//        }
//
//        User user = userService.getCurrentUser();
//        if (bookLendingService.isBookIssuedQuotaExceeded(user.getId())) {
//            System.out.println("Người dùng đã mượn quá số lượng sách cho phép");
//            return;
//        }
//
//        bookLendingService.lendBook(user.getId(), bookItem.getBookItemID());
//        System.out.println("Mượn sách thành công");
//    }

//    private void returnBook() {
//        long barcode = inputBarcode(InputOption.OTHER);
//        BookItem bookItem = BookItemService.getInstance().findByBarcode(barcode);
//        System.out.println("Thông tin sách " + bookItem);
//        // check Fine
//        // Tăng numberBook
//    }


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
            if (publicationAt <=0)
                System.out.println("Năm xuất bản phải lớn hơn 0 ");
        } while (publicationAt <=0);
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
