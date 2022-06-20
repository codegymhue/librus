package vn.hd.librus.views;

import vn.hd.librus.model.Role;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrarianView extends UserView {

    public static void launch() {
        LibrarianView librarianView = new LibrarianView();
//        librarianView.login(Role.LIBRARIAN);
        librarianView.menuOption();
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
                        BookMenuView.launch();
                        break;
                    case 2:
                        BookItemMenuView.launch();
                        break;
                    case 3:
                        BookLendingMenu.launch();
                        break;
                    case 4:
                        UserMenuView.launch();
                        break;
                    case 5 :
                        MenuView.showSelection();
                        break;
                    case 6 :
                        MenuView.exit();
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
        System.out.println("\t ✬ ✬ ✬ ✬ ✬  MENU LIBRARIAN  ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ");
        System.out.println("\t ✬                                     ✬");
        System.out.println("\t ✬     1. Quản lí sách                 ✬");
        System.out.println("\t ✬     2. Quản lí BookItem             ✬");
        System.out.println("\t ✬     3. Quản lí BookLending          ✬");
        System.out.println("\t ✬     4. Quản lí người dùng           ✬");
        System.out.println("\t ✬     5. Quay lại Main Menu           ✬");
        System.out.println("\t ✬     6. Exit                         ✬");
        System.out.println("\t ✬                                     ✬");
        System.out.println("\t ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ✬ ");
    }

}
