import java.util.Scanner;

public class book {

    public int id;
    public String title;
    public String author;
    public int yearPublished;

    Scanner input = new Scanner(System.in);

    public book()
    {
        System.out.println("введите идентификационный номер книги");
        this.id = input.nextInt();
        input.nextLine();

        System.out.println("введите название книги");
        this.title = input.nextLine();

        System.out.println("введите ФИО автора");
        this.author = input.nextLine();

        System.out.println("введите год выпуска книги");
        this.yearPublished = input.nextInt();
    }
}