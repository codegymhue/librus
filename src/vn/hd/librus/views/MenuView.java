package vn.hd.librus.views;

import java.util.Scanner;

public class MenuView {

    public static void main(String[] args) {
        showSelection();
    }

    public static Scanner input = new Scanner(System.in);

    public static void exit() {
        System.out.println("End Program! Have a nice day !!! ");
        System.exit(0);
    }

    public static void showMainMenu() {
        System.out.println("*-----------------Menu-----------------*");
        System.out.println("|   1.Menu Library                     |");
        System.out.println("|   2.Menu Member                      |");
        System.out.println("|   0. Exit                            |");
        System.out.println("*--------------------------------------*");
        System.out.println("Enter your choice: ");

    }

    public static void menuLibrary() {
        System.out.println("*----------------- Menu Library -----------------*");
        System.out.println("|    1. Management book                          |");
        System.out.println("|    2. Management member                        |");
        System.out.println("|    3. Management reservation                   |");
        System.out.println("|    4. Back to MainMenu                         |");
        System.out.println("|    5. Exit                                     |");
        System.out.println("*------------------------------------------------*");
        System.out.println("Enter your choice: ");
        System.out.println("=>");
        int choice = -1;
        while (choice != 0) {
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    managementBook();
                    break;
                case 2:
                    managementMember();
                    break;
                case 3:
                    managementReservation();
                    break;
                case 4:
//                    showSelection();
                    break;
                case 5:
                    MenuView.exit();
                    break;
                default:
                    System.out.println("Wrong input! Please try again!!!");
                    menuLibrary();

            }
        }
    }

    public static void managementBook() {

        System.out.println("*---------- Management Book ----------*");
        System.out.println("|    1.Add book                       |");
        System.out.println("|    2.Remove book                    |");
        System.out.println("|    3.Edit book                      |");
        System.out.println("|    4.Search Book                    |");
        System.out.println("|    5.Display Book                   |");
        System.out.println("|    6.Renew Book                     |");
        System.out.println("|    7.Back to Menu Library           |");
        System.out.println("*-------------------------------------*");
        System.out.println("Enter your choice :");
        System.out.println("=>");

        int choice1 = -1;
        while (choice1 != 0) {
            choice1 = input.nextInt();
            input.nextLine();
            switch (choice1) {
                case 1:
                    System.out.println("Add book");
                    break;
                case 2:
                    System.out.println("Remove book");
                    break;
                case 3:
                    System.out.println("Edit book");
                    break;
                case 4:
                    System.out.println("Search book");
                    break;
                case 5:
                    System.out.println("Display book");
                    break;
                case 6:
                    System.out.println("Renew book");
                    break;
                case 7:
                    menuLibrary();
                    break;
                default:
                    System.out.println("Wrong input. Please try again!");
                    managementBook();

            }

        }
    }

    public static void managementMember() {
        System.out.println("*---------- Management Member ----------*");
        System.out.println("|    1.Register new account             |");
        System.out.println("|    2.Register/ Update account         |");
        System.out.println("|    3.Cancel membership                |");
        System.out.println("|    4.Back to Menu Library             |");
        System.out.println("*---------------------------------------*");
        System.out.println("Enter you choice:");
        System.out.println("=>");
        int choice2 = -1;
        while (choice2 != 0) {
            choice2 = input.nextInt();
            input.nextLine();
            switch (choice2) {
                case 1:
                    System.out.println("Register new account");
                    break;
                case 2:
                    System.out.println("Register/ Update account");
                    break;
                case 3:
                    System.out.println("Cancel membership");
                    break;
                case 4:
                    menuLibrary();
                    break;
                default:
                    System.out.println("Wrong input. Please try again!!!");
                    managementMember();
            }
        }

    }

    public static void managementReservation() {
        System.out.println("*---------- Management Reservation ----------*");
        System.out.println("|    1.Reserve Book                          |");
        System.out.println("|    2.Renew Book                            |");
        System.out.println("|    3.Remove reservation                    |");
        System.out.println("|    4.Back to Menu Library                  |");
        System.out.println("*--------------------------------------------*");
        System.out.println("Enter your choice:");
        System.out.println("=>");
        int choice3 = -1;
        while (choice3 != 0) {
            choice3 = input.nextInt();
            input.nextLine();
            switch (choice3) {
                case 1:
                    System.out.println("Reserve Book");
                    break;
                case 2:
                    System.out.println("Renew Book");
                    break;
                case 3:
                    System.out.println("Remove reservation");
                    break;
                case 4:
                    menuLibrary();
                    break;
                default:
                    System.out.println("Wrong input. Please try again.");
                    managementReservation();
            }
        }

    }

    public static void menuMember() {
        System.out.println("*-------------- Menu Member ------------*");
        System.out.println("|    1.Search Book                      |");
        System.out.println("|    2.Checkout Book                    |");
        System.out.println("|    3.Reserve Book                     |");
        System.out.println("|    4.Return Book                      |");
        System.out.println("|    5.Remove reservation               |");
        System.out.println("|    6.Back to Main Menu                |");
        System.out.println("*---------------------------------------*");
        System.out.println("Enter your choice: ");
        System.out.println("=>");
        int choice4 = -1;
        while (choice4 != 0) {
            choice4 = input.nextInt();
            input.nextLine();
            switch (choice4) {
                case 1:
                    System.out.println("Search Book");
                    break;
                case 2:
                    System.out.println("Checkout Book");
                    break;
                case 3:
                    System.out.println("Reserve Book");
                    break;
                case 4:
                    System.out.println("Return Book");
                    break;
                case 5:
                    System.out.println("Remove Reservation");
                    break;
                case 6:
                    showSelection();
                    break;
                default:
                    System.out.println("Wrong input. Please try again.");
                    menuMember();
            }
        }

    }

    public static void showSelection() {
        int choice ;
        while (true) {
            showMainMenu();
            try {
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        menuLibrary();
                        break;
                    case 2:
                        menuMember();
                        break;
                    case 0:
                        MenuView.exit();
                        break;
                    default:
                        System.out.println("No choice! Please try again.");

                }

            } catch (Exception e) {
                System.out.println("Wrong input. Please try again!");
                showMainMenu();
            }
        }
    }
}
