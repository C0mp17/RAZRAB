import java.util.Scanner;
public class Library {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        books ob = new books();

        int choice;
        int searchChoice;
        do {
            ob.dispMenu();
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    book b = new book();
                    ob.addBook(b);
                    break;
                case 3:
                    ob.searchByAuthorName();
                case 2:
                    ob.showAllBooks();
                    break;
            }
        }
        while (choice != 0);
    }
}