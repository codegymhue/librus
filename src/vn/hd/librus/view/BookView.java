//package librarymanagement.hangdinh.vn.view;
//
//import librarymanagement.hangdinh.vn.service.BookService;
//import librarymanagement.hangdinh.vn.service.IBookService;
//
//import java.util.Scanner;
//
//public class BookView {
//    private final IBookService bookService;
//    private final Scanner input = new Scanner(System.in);
//
//    public BookView() { bookService = BookService.getInstance();}
//
//    public void add(){
//
//    }
//    public void update(){}
//
//    private String inputTitle(InputOption option){
//        switch (option){
//            case ADD :
//                System.out.println("Input Book's Title: ");
//                break;
//            case UPDATE:
//                System.out.println("Input Book's Title that you want to edit: ");
//                break;
//        }
//        System.out.println("=>");
//        String title = input.nextLine();
//        return title;
//    }
//
//    private String inputAuthor(InputOption option){
//        switch (option) {
//            case ADD:
//                System.out.println("Input Book's Author");
//                break;
//            case UPDATE:
//                System.out.println("Input Book's Author that you want to edit: ");
//                break;
//        }
//        System.out.println("=>");
//        String author =input.nextLine();
//        return author ;
//
//        }
//
//    private String inputSubject(InputOption option){
//        switch (option){
//            case ADD :
//                System.out.println("Input Subject");
//                break;
//            case UPDATE:
//                System.out.println("Input Subject that you want to edit");
//                break;
//        }
//        System.out.println("=>");
//        String subject = input.nextLine();
//        return subject;
//    }
//
//    private String inputPublisher(InputOption option){
//        switch (option){
//            case ADD :
//                System.out.println("Input Yearbook Publishing");
//                break;
//            case UPDATE:
//                System.out.println("Input Yearbook Publishing that you want to edit ");
//                break;
//        }
//        System.out.println("=>");
//        String publisher = input.nextLine();
//        return publisher;
//    }
//
//    private String inputLanguage(InputOption option){
//        switch (option){
//            case ADD :
//                System.out.println("Input language: ");
//                break;
//            case UPDATE:
//                System.out.println("Input language that you want to edit:");
//                break;
//        }
//        System.out.println("=>");
//        String language = input.nextLine();
//        return language ;
//    }
//    private int numberOfPage(InputOption option){
//        switch (option){
//            case ADD :
//                System.out.println("Input number of page");
//                break;
//            case UPDATE:
//                System.out.println("Input number of page that you want to change");
//                break;
//        }
//        int numberOfPage;
//
//        do {
//            System.out.println("=>");
//           numberOfPage = Integer.parseInt(input.nextLine());
//           if (numberOfPage <= 0)
//               System.out.println("The number of page must be over than 0");
//        }while(numberOfPage <0);
//        return numberOfPage;
//    }
//
//}
