package vn.hd.librus.views;

import vn.hd.librus.model.*;
import vn.hd.librus.services.BookLendingService;
import vn.hd.librus.services.IBookLendingService;
import vn.hd.librus.utils.AppUtils;
import vn.hd.librus.utils.InstantUtils;

import java.util.Scanner;


public class BookLendingView {
    private IBookLendingService bookLendingService;
    private final Scanner scanner = new Scanner(System.in);


    public BookLendingView() {
        bookLendingService = BookLendingService.getInstance();
    }

    public void update() {
        boolean isRetry;
        do {
            showBooksLending(InputOption.UPDATE);
            long id = inputId(InputOption.UPDATE);
            System.out.println("┌ - - - - - - -  SỬA - - - - - - - ┐");
            System.out.println("|   1. Sửa trạng thái Lending      |");
            System.out.println("|   2. Quay lại Menu               |");
            System.out.println("└ - - - - - - - - - - - - - - - - -┘");
            System.out.println("Chọn chức năng: ");
            int option = AppUtils.retryChoose(1, 2);
            BookLending newBookLending = new BookLending();
            newBookLending.setId(id);

            switch (option) {
                case 1:
                    LendingStatus lendingStatus = inputLendingStatus(InputOption.ADD);
                    newBookLending.setStatus(lendingStatus);
                    bookLendingService.update(newBookLending);
                    System.out.println("Cập nhập trạng thái Lending thành công");
                    break;
                case 2:
                    showBooksLending(InputOption.UPDATE);
                    break;
            }
            isRetry = option != 2 && AppUtils.isRetry(InputOption.UPDATE);
        } while (isRetry);
    }


    public void showBooksLending(InputOption inputOption) {
        System.out.println("--------------------------------------------------------------- BOOK LENDING --------------------------------------------------------------------");
        System.out.printf(" %-15s %-15s %-15s %-15s %-18s %-18s %-18s \n",
                "Id BookLending",
                "Id BookItem",
                "Id User",
                "Lending Status",
                "Ngày Mượn Sách",
                "Ngày Đến Hạn",
                "Ngày Trả Sách"

        );
        for (BookLending bookLending : bookLendingService.findAll()) {
            System.out.printf(" %-15s %-15s %-15s %-15s %-18s %-18s %-18s \n",
                    bookLending.getId(),
                    bookLending.getBookItemId(),
                    bookLending.getUserId(),
                    bookLending.getStatus(),
                    bookLending.getCreatedAt() == null ? "" : InstantUtils.instantToString(bookLending.getCreatedAt()),
                    bookLending.getDueAt() == null ? "" : InstantUtils.instantToString(bookLending.getDueAt()),
                    bookLending.getReturnAt() == null ? "" : InstantUtils.instantToString(bookLending.getReturnAt())
            );
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------\n");
        if (inputOption == InputOption.SHOW)
            AppUtils.isRetry(InputOption.SHOW);
    }

    private LendingStatus inputLendingStatus(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập Lending status : LENDING | DUE | RETURN");
                break;
            case UPDATE:
                System.out.println("Nhập Lending status muốn sửa: LENDING | DUE | RETURN ");
                break;
        }
        return LendingStatus.parseRole(AppUtils.retryString("lending status"));
    }

    private long inputId(InputOption option) {
        long id;
        switch (option) {
            case ADD:
                System.out.println("Nhập Id BookLending ");
                break;
            case UPDATE:
                System.out.println("Nhập Id BookLending bạn muốn sửa");
                break;
        }
        boolean isRetry = false;
        do {
            id = AppUtils.retryParseLong();
            boolean exist = bookLendingService.existById(id);
            switch (option) {
                case ADD:
                    if (exist) {
                        System.out.println("Id này đã tồn tại. Vui lòng nhập Id khác!");
                    }
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist) {
                        System.out.println("Không tìm thấy Id! Vui lòng nhập lại");
                    }
                    isRetry = !exist;
                    break;
            }
        } while (isRetry);
        return id;
    }
}
