package vn.hd.librus.views;

import vn.hd.librus.model.BookItem;
import vn.hd.librus.model.Role;
import vn.hd.librus.model.User;
import vn.hd.librus.services.*;
import vn.hd.librus.utils.AppUtils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MemberView extends UserView {

    private final IBookItemService bookItemService;
    private final IBookLendingService bookLendingService;
    private final IUserService userService;

    public MemberView() {
        bookItemService = BookItemService.getInstance();
        bookLendingService = BookLendingService.getInstance();
        userService = UserService.getInstance();
    }

    public static void launch() {
        MemberView memberView = new MemberView();
        memberView.menuOption();
    }

    public void menuOption() {
        do {
            showHeader();
            showMenu();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nChọn chức năng ");
                System.out.print("⭆ ");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        UserView userView = new UserView();
                        userView.updateUser();
                        break;
                    case 2:
                        BookLendingView bookLendingView = new BookLendingView();
                        bookLendingView.showBooksLending(InputOption.SHOW);
                        break;
                    case 3:
                        MenuView.exit();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        menuOption();
                }

            } catch (InputMismatchException ex) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (true);
    }

    public void showHeader() {

        long id = inputUserId();
        System.out.println("\t✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬  LIBRUS  ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬");
        System.out.println();
        System.out.printf("\t %-5s %-15s %-5s %-15s %-5s %-15s %-5s %-15s \n",
                "✬|✬"
                , "Tên Người Dùng    "
                , "✬|✬"
                , "Số điện thoại  ",
                "✬|✬    ",
                "Email ",
                "✬|✬",
                "Số sách đang mượn");

        User user = userService.findById(id);
        System.out.printf("\t %-7s %-15s %-7s %-12s %-7s %-23s %-7s %-7s \n",
                "✬-✬-✬-✬",
                user.getUsername(),
                "✬-✬-✬-✬",
                user.getMobile(),
                "✬-✬-✬-✬",
                user.getEmail(),
                "✬-✬-✬-✬",
                bookLendingService.countBookItemLendingByUserIdAndStatus(user.getId()));

        System.out.println();
        System.out.println("\t✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ");
    }

    private long inputUserId() {
        long userId;
        System.out.println("Nhập UserId để xem thông tin của bạn");
        while (!userService.existById(userId = AppUtils.retryParseLong())) {
            System.out.println("Không tìm thấy người dùng ! Vui lòng nhập lại");
        }
        return userId;
    }

    public void showMenu() {
        System.out.println("\t ✬ ✬ ✬ ✬ ✬ ✬ ✬ MENU MEMBER  ✬ ✬ ✬ ✬ ✬ ✬ ✬");
        System.out.println("\t ✬                                    ✬");
        System.out.println("\t ✬     1. Sửa thông tin               ✬");
        System.out.println("\t ✬     2. Xem thông tin BookLending   ✬");
        System.out.println("\t ✬     3. Exit                        ✬");
        System.out.println("\t ✬                                    ✬");
        System.out.println("\t ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬");
    }

}
