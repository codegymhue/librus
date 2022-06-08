package vn.hd.librus.views;

import vn.hd.librus.model.Role;
import vn.hd.librus.model.User;
import vn.hd.librus.services.BookItemService;
import vn.hd.librus.services.IBookItemService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberView extends UserView {
    private final IBookItemService bookItemService;

    public MemberView() {
        bookItemService = BookItemService.getInstance();
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
                        UserMenuView.launch();
                        break;
                    case 2:
                        BookItemMenuView.launch();
                        break;
                    case 3:
                        BookReservationMenuView.launch();
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
        System.out.println("\t✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬LIBRUS✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬");
        System.out.printf("\t✬\t%-55s                Số sách đã mượn:  %-6s✬", "Đinh Phan Thị Khanh Hằng", 4);
        System.out.printf("\t✬\t%-55s                Số sách đang mượn:%-6s✬", "khanhhangcute@gfmga.com", 4);
        System.out.printf("\t✬\t%-55s                                 ✬", "0987654321");
        System.out.println("\t✬                                 ✬");
        System.out.println("\t✬                                 ✬");
        System.out.println("\t✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬");
    }

    public void showMenu() {
        System.out.println("✬                                                                       ✬");
        System.out.println("✬     1. Đổi thông tin cá nhân                 ✬");
        System.out.println("✬     2. Xem sách đang mượn       ✬");
        System.out.println("✬                                  ✬");
        System.out.println("✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬");
    }
}
