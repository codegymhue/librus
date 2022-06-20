package vn.hd.librus.views;

import vn.hd.librus.model.Role;
import vn.hd.librus.model.User;
import vn.hd.librus.services.BookItemService;
import vn.hd.librus.services.BookLendingService;
import vn.hd.librus.services.IBookItemService;
import vn.hd.librus.services.IBookLendingService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberView extends UserView {

    public static void main(String[] args) {
        MemberView memberView = new MemberView();
        memberView.showHeader();
        //memberView.launch();
    }
    private final IBookItemService bookItemService;
    private final IBookLendingService bookLendingService;

    public MemberView() {
        bookItemService = BookItemService.getInstance();
        bookLendingService = BookLendingService.getInstance();
    }

    public static void launch() {
        MemberView memberView = new MemberView();
        memberView.login(Role.MEMBER);
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
        User user = userService.getCurrentUser();
        System.out.println("\t✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬  LIBRUS  ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬");

        System.out.println("\t ✬                Đinh Phan Thị Khánh Hằng           ✬");
        System.out.println("\t ✬ ✬ ✬ ✬ ✬ ✬   Số sách đã mượn: 4       ✬ ✬ ✬ ✬ ✬ ✬ ");
        System.out.println("\t ✬ ✬ ✬ ✬ ✬ ✬   Số sách đang mượn: 4     ✬ ✬ ✬ ✬ ✬ ✬ ");
        System.out.println("\t ✬ ✬ ✬ ✬ ✬ ✬   hangcute@gmail.com       ✬ ✬ ✬ ✬ ✬ ✬ ");
        System.out.println("\t ✬ ✬ ✬ ✬ ✬ ✬   0981234567               ✬ ✬ ✬ ✬ ✬ ✬ ");
        System.out.println("\t ✬                                                    ✬");
        System.out.println("\t✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ");
    }

    public void showMenu() {
        System.out.println("\t ✬ ✬ ✬ ✬ ✬ ✬ ✬ MENU MEMBER  ✬ ✬ ✬ ✬ ✬ ✬ ✬");
        System.out.println("\t ✬                                    ✬");
        System.out.println("\t ✬     1. Sửa thông tin cá nhân       ✬");
        System.out.println("\t ✬     2. Xem sách đang mượn          ✬");
        System.out.println("\t ✬     3. Exit                        ✬");
        System.out.println("\t ✬                                    ✬");
        System.out.println("\t ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬");
    }
}
