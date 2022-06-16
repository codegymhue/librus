package vn.hd.librus.views;

import vn.hd.librus.model.Role;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrarianView extends UserView {

    public static void launch() {
        LibrarianView librarianView = new LibrarianView();
        librarianView.login(Role.LIBRARIAN);
        menuOption();
    }

    public static void menuOption() {
        do {
            mainMenu();
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nChọn chức năng ");
                System.out.print("⭆ ");
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        UserMenuView.launch();
                        break;
                    case 2:
                        BookItemMenuView.launch();
                        break;
                    case 3:
                       // BookReservationMenuView.launch();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        menuOption();
                }

            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }


    public static void mainMenu() {
        System.out.println("\t ✬ ✬ ✬ ✬ ✬ ✬ ✬MAIN MENU✬ ✬ ✬ ✬ ✬ ✬ ✬");
        System.out.println("\t ✬                                 ✬");
        System.out.println("\t ✬     1. Quản lí người dùng       ✬");
        System.out.println("\t ✬     2. Quản lí bánh             ✬");
        System.out.println("\t ✬     3. Quản lí đơn đặt hàng     ✬");
        System.out.println("\t ✬                                 ✬");
        System.out.println("\t ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬");
    }

    public static void orderMenu() {
        System.out.println("✬ ✬ ✬ ✬ ✬ ✬ ✬ORDER MENU✬ ✬ ✬ ✬ ✬ ✬ ✬");
        System.out.println("✬                                  ✬");
        System.out.println("✬     1. Tạo order                 ✬");
        System.out.println("✬     2. xem danh sách order       ✬");
        System.out.println("✬                                  ✬");
        System.out.println("✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬");
    }
}
