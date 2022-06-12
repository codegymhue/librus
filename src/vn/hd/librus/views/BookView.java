package vn.hd.librus.views;

import vn.hd.librus.model.Book;
import vn.hd.librus.services.IBookService;
import vn.hd.librus.sort.SortByIsbnASC;
import vn.hd.librus.sort.SortByIsbnDESC;
import vn.hd.librus.sort.SortByNameASC;
import vn.hd.librus.sort.SortByNameDES;
import vn.hd.librus.utils.AppUtils;
import vn.hd.librus.services.BookService;
import vn.hd.librus.utils.InstantUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookView {

    public static void main(String[] args) {
        BookView bookView = new BookView();
        bookView.update();
    }
    private IBookService bookService; //Dependency Inversion Principle (SOLID)
    private final Scanner scanner = new Scanner(System.in);

    public BookView() {
        bookService = BookService.getInstance();
    }

    public void add() {
        do {
//                int id = inputId(InputOption.ADD);
            long id = System.currentTimeMillis() / 1000;
            String isbn = inputISBN(InputOption.ADD);
            String title = inputTitle(InputOption.ADD);
            String author = inputAuthor(InputOption.ADD);
            String subject = inputSubject(InputOption.ADD);
            String publisher = inputPublisher(InputOption.ADD);
            String language = inputLanguage(InputOption.ADD);
            int numberOfPages = inputNumberOfPages(InputOption.ADD);
            Book newBook = new Book(id, isbn, title, author, subject, publisher, language, numberOfPages);
            bookService.add(newBook);
            System.out.println("Bạn đã thêm sách thành công\n");

        } while (AppUtils.isRetry(InputOption.ADD));
    }

    public void update() {
        boolean isRetry;
        do {
            showBooks(InputOption.UPDATE);
            String id = inputISBN(InputOption.UPDATE);
            System.out.println("┌ - - - - SỬA  - - - ┐");
            System.out.println("| 1.Sửa tên sách     |");
            System.out.println("| 2.Sửa tác giả      |");
            System.out.println("| 3.Sửa chủ đề       |");
            System.out.println("| 4.Sửa nhà xuất bản |");
            System.out.println("| 5.Sửa ngôn ngữ     |");
            System.out.println("| 6.Sửa số trang     |");
            System.out.println("| 7.Quay lại MENU    |");
            System.out.println("└ - - - - - -  - - - ┘");
            System.out.println("Chọn chức năng: ");
            int option = AppUtils.retryChoose(1, 7);
            Book newBook = new Book();
            newBook.setIsbn(id);
            switch (option) {
                case 1:
                    String title = inputTitle(InputOption.UPDATE);
                    newBook.setTitle(title);
                    bookService.update(newBook);
                    System.out.println("Tên sách đã cập nhật thành công");
                    break;
                case 2:
                    String author = inputAuthor(InputOption.UPDATE);
                    newBook.setAuthor(author);
                    bookService.update(newBook);
                    System.out.println("Tác giả đã cập nhật thành công");
                    break;
                case 3:
                    String subject = inputSubject(InputOption.UPDATE);
                    newBook.setSubject(subject);
                    bookService.update(newBook);
                    System.out.println("Tác giả đã cập nhật thành công");
                    break;
                case 4:
                    String publisher = inputPublisher(InputOption.UPDATE);
                    newBook.setPublisher(publisher);
                    bookService.update(newBook);
                    System.out.println("Tác giả đã cập nhật thành công");
                    break;
                case 5:
                    String language = inputLanguage(InputOption.UPDATE);
                    newBook.setPublisher(language);
                    bookService.update(newBook);
                    System.out.println("Tác giả đã cập nhật thành công");
                    break;
                case 6:
                    int numberOfPages = inputNumberOfPages(InputOption.UPDATE);
                    newBook.setNumberOfPages(numberOfPages);
                    bookService.update(newBook);
                    System.out.println("Số trang sách thành công");
                    break;
            }
            isRetry = option != 7 && AppUtils.isRetry(InputOption.UPDATE);
        } while (isRetry);
    }


    //Tái sử dụng khi vn.hd.librus.sort tránh đổi thứ tự list gốc
    public void showBooks(InputOption inputOption) {
        System.out.println("-----------------------------------------DANH SÁCH SÁCH-------------------------------------------");
        System.out.printf("%-15s %-30s %-25s %-10s %-20s %-20s %-20s %-20s  %-20s  %-20s \n",
                "Id",
                "ISBN",
                "Tên sách",
                "Tác giả",
                "Chủ đề",
                "Nhà xuất bản",
                "Ngôn ngữ",
                "Số trang",
                "Ngày tạo",
                "Ngày cập nhật");
        for (Book book : bookService.findAll()) {
            System.out.printf("%-15s %-30s %-25s %-10s %-20s %-20s %-20s %-20s  %-20s  %-20s\n",
                    book.getId(),
                    book.getIsbn(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getSubject(),
                    book.getPublisher(),
                    book.getLanguage(),
                    book.getNumberOfPages(),
                    InstantUtils.instantToString(book.getCreatedAt()),
                    book.getUpdatedAt() == null ? "" : InstantUtils.instantToString(book.getUpdatedAt()));
        }
        System.out.println("--------------------------------------------------------------------------------------------------\n");
        if (inputOption == InputOption.SHOW) AppUtils.isRetry(InputOption.SHOW);
    }

    public void remove() {
        showBooks(InputOption.DELETE);
        long id;
        while (!bookService.existsById(id = inputId(InputOption.DELETE))) {
            System.out.println("Không tìm thấy sản phẩm cần xóa");
            System.out.println("Nhấn 'y' để thêm tiếp \t|\t 'q' để quay lại \t|\t 't' để thoát chương trình");
            System.out.print(" ⭆ ");
            String option = scanner.nextLine();
            switch (option) {
                case "y":
                    break;
                case "q":
                    return;
                case "t":
                    AppUtils.exit();
                    break;
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    break;
            }
        }

        System.out.println("❄ ❄ ❄ ❄ REMOVE COMFIRM ❄ ❄ ❄");
        System.out.println("❄  1. Nhấn 1 để xoá        ❄");
        System.out.println("❄  2. Nhấn 2 để quay lại   ❄");
        System.out.println("❄ ❄ ❄ ❄ ❄ ❄ ❄  ❄ ❄ ❄ ❄ ❄ ❄ ❄");
        int option = AppUtils.retryChoose(1, 2);
        if (option == 1) {
            bookService.deleteById(id);
            System.out.println("Đã xoá sản phẩm thành công! \uD83C\uDF8A");
            AppUtils.isRetry(InputOption.DELETE);
        }

    }

    public Book findBooksByName() {
        bookService.findAll();
        System.out.println("Nhập tên sách mà bạn muốn tìm kiếm : ");
        String title = scanner.nextLine().toLowerCase();
        for (Book book : bookService.findAll()) {
            if (book.getTitle().toLowerCase().contains(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> initBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("903753","Tuyết giữa mùa hè","Sayadaw UJotika","Văn học","First new","Tiếng Việt",200));
        bookList.add(new Book("2748264","Sapiens - Lược sử loài người","Yuval Noah Harari","Khoa học","Omega plus","Tiếng Việt",443));
        bookList.add(new Book("4586486","Pro SQL","Cu Tran","IT","CodeGym editor","English",180));
        bookList.add(new Book("468268","Master JAVA Programming","Loc Vo","IT","LocVo Editor","English",100));
        bookList.add(new Book("4517458164","The Diary of Anne Frank","Anne Frank","Autobiography","Omega Plus","English",500));
        bookList.add(new Book("4361574","How to become master Dev-Java","Minh Bui","IT","CodeGym editor","English",120));

        return bookList;
    }



    public void displayBook(){
        int choice;
        do{
            showBooks(InputOption.SHOW);
            System.out.println("1.Hiển thị danh sách BOOKS theo Tên (A-Z)");
            System.out.println("2.Hiển thị danh sách BOOKS theo Tên (Z-A)");
            System.out.println("3.Hiển thị danh sách BOOKS theo mã Isbn (tăng dần)");
            System.out.println("4.Hiển thị danh sách BOOKS theo mã Isbn (giảm dần)");
            System.out.println("5.Quay lại");
            choice =  Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 :
                    initBooks().sort(new SortByNameASC());
                    break;
                case 2:
                    initBooks().sort(new SortByNameDES());
                    break;
                case 3 :
                    initBooks().sort(new SortByIsbnASC());
                    break;
                case 4:
                    initBooks().sort(new SortByIsbnDESC());
                    break;
                case 5 :
                    break;
                default:
                    System.out.println("Bạn đã nhập sai chức năng. Vui lòng nhập lại.");
            }
        }while (choice !=6);
    }

    public Book findBooksByAuthor() {
        bookService.findAll();
        System.out.println("Nhập tên tác giả mà bạn muốn tìm kiếm: ");
        String author = scanner.nextLine().toLowerCase();
        for (Book book : bookService.findAll()) {
            if (book.getAuthor().toLowerCase().contains(author)) {
                return book;
            }
        }
        return null;
    }


    private int inputId(InputOption option) {
        int id;
        switch (option) {
            case ADD:
                System.out.println("Nhập Id");
                break;
            case UPDATE:
                System.out.println("Nhập id bạn muốn sửa");
                break;
            case DELETE:
                System.out.println("Nhập id bạn cần xoá: ");
                break;
        }
        boolean isRetry = false;
        do {
            id = AppUtils.retryParseInt();
            boolean exist = bookService.existsById(id);
            switch (option) {
                case ADD:
                    if (exist) {
                        System.out.println("Id này đã tồn tại. Vui lòng nhập id khác!");
                    }
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist) {
                        System.out.println("Không tìm thấy id! Vui lòng nhập lại");
                    }
                    isRetry = !exist;
                    break;
            }
        } while (isRetry);
        return id;
    }

    private String inputTitle(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập tên sách ");
                break;
            case UPDATE:
                System.out.println("Nhập tên sách muốn sửa: ");
                break;
        }
        return AppUtils.retryString("Tên sách");
    }

    private String inputAuthor(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập tên tác giả ");
                break;
            case UPDATE:
                System.out.println("Nhập tên tác giả muốn sửa: ");
                break;
        }
        return AppUtils.retryString("Tên tác giả");
    }

    private String inputSubject(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập chủ đề sách: ");
                break;
            case UPDATE:
                System.out.println("Nhập chủ đề sách muốn sửa: ");
                break;
        }
        return AppUtils.retryString("Chủ đề");
    }

    private String inputPublisher(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập nhà xuất bản: ");
                break;
            case UPDATE:
                System.out.println("Nhập nhà xuất bản muốn sửa: ");
                break;
        }
        return AppUtils.retryString("Chủ đề");
    }

    private String inputLanguage(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập ngôn ngữ của sách: ");
                break;
            case UPDATE:
                System.out.println("Nhập ngôn ngữ của sách muốn sửa: ");
                break;
        }
        return AppUtils.retryString("Ngôn ngữ sách");
    }

    private String inputISBN(InputOption option) {
        String isbn;
        switch (option) {
            case ADD:
                System.out.println("Nhập ISBN");
                break;
            case UPDATE:
                System.out.println("Nhập ISBN bạn muốn sửa");
                break;
            case DELETE:
                System.out.println("Nhập ISBN bạn cần xoá: ");
                break;
        }
        boolean isRetry = false;
        do {
            isbn = AppUtils.retryString("ISBN");
            boolean exist = bookService.existByISBN(isbn);
            switch (option) {
                case ADD:
                    if (exist) {
                        System.out.println("ISBN này đã tồn tại. Vui lòng nhập isbn khác!");
                    }
                    isRetry = exist;
                    break;
                case UPDATE:
                    if (!exist) {
                        System.out.println("Không tìm thấy isbn! Vui lòng nhập lại");
                    }
                    isRetry = !exist;
                    break;
            }
        } while (isRetry);
        return isbn;
    }

    private int inputNumberOfPages(InputOption option) {
        switch (option) {
            case ADD:
                System.out.println("Nhập số trang sách: ");
                break;
            case UPDATE:
                System.out.println("Nhập số trang sách muốn sửa: ");
                break;
        }
        int numberOfPages;
        do {
            numberOfPages = AppUtils.retryParseInt();
            if (numberOfPages <= 0) System.out.println("Số trang phải lớn hơn 0 (số trang > 0)");
        } while (numberOfPages <= 0);
        return numberOfPages;
    }

}
