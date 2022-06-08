package vn.hd.librus.views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookItemMenuView {

    public static void main(String[] args) {
        BookItemMenuView.launch();
    }

    public static void launch() {
        int choice;
        do {
            Scanner input = new Scanner(System.in);
            BookItemView bookItemView = new BookItemView();
            menuBookItem();
            try {
                System.out.println("Chọn chức năng :");
                System.out.println("=>");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        bookItemView.add();
                        break;
                    case 2:
                        bookItemView.update();
                        break;
                    case 3:
                        bookItemView.remove();
                        break;
                    case 4:
                        bookItemView.showBooks(InputOption.SHOW);
                        break;
                    case 5:
                        MenuView.managementBook();
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Chọn chức năng không đúng. Vui lòng chọn lại");
                }

            } catch (InputMismatchException io) {
                System.out.println("Nhập sai. Vui lòng nhập lại");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public static void menuBookItem() {
        System.out.println("*------------ Menu BookItem ----------*");
        System.out.println("|    1.Add book                       |");
        System.out.println("|    2.Update book                    |");
        System.out.println("|    3.Remove book                    |");
        System.out.println("|    4.Show Book                      |");
        System.out.println("|    5.Back to Menu ManagementBook    |");
        System.out.println("|    6.Exit                           |");
        System.out.println("*-------------------------------------*");

    }
}
