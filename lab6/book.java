import java.util.Scanner;

public class book {

    public int id;
    public String title;
    public String author;
    public int yearPublished;

    Scanner input = new Scanner(System.in);

    public book()
    {
        System.out.println("������� ����������������� ����� �����");
        this.id = input.nextInt();
        input.nextLine();

        System.out.println("������� �������� �����");
        this.title = input.nextLine();

        System.out.println("������� ��� ������");
        this.author = input.nextLine();

        System.out.println("������� ��� ������� �����");
        this.yearPublished = input.nextInt();
    }
}