//package librarymanagement.hangdinh.vn.view;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class BookViewLauncher {
//    public static void run() {
//        int number;
//        do {
//            Scanner input = new Scanner(System.in);
//            BookView bookView = new BookView();
//            managementBook();
//            try {
//                System.out.println("Input number: ");
//                System.out.println("=>");
//                number = input.nextInt();
//                switch (number){
//                    case 1 :
//                        break;
//                    case 2 :
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//                    case 5:
//                        break;
//                    case 6 :
//                        break;
//                    case 7:
//                        break;
//                }
//
//            } catch (InputMismatchException io){
//                System.out.println("Wrong input. Try again !!! ");
//            } catch (Exception e){
//                e.printStackTrace();
//                System.out.println(e.getMessage());
//            }
//        } while (true);
//    }
//        public static void managementBook(){
//            System.out.println("*---------- Management Book ----------*");
//            System.out.println("|    1.Add book                       |");
//            System.out.println("|    2.Remove book                    |");
//            System.out.println("|    3.Edit book                      |");
//            System.out.println("|    4.Search Book                    |");
//            System.out.println("|    5.Display Book                   |");
//            System.out.println("|    6.Renew Book                     |");
//            System.out.println("|    7.Back to Menu Library           |");
//            System.out.println("*-------------------------------------*");
//        }
//    }
//
