import java.util.Scanner;
public class books {

    book theBooks[] = new book[20];
    public static int count;

    Scanner input = new Scanner(System.in);

    public void addBook(book b)
    {
        for (int i = 0; i < count; i++) {

        }
        if (count < 20) {
            theBooks[count] = b;
            count++;
        }
        else {
            System.out.println(
                    "�������� ����� �������� ����");
        }
    }
    public void searchByAuthorName()
    {
        System.out.println("������� ��� ������:");
        String author = input.nextLine();
        int flag = 0;
        System.out.println(
                "����������������� �����  ��������  �����  ��� �������");

        for (int i = 0; i < count; i++) {

            if (author.equalsIgnoreCase(
                    theBooks[i].author)) {

                System.out.println(
                        theBooks[i].id + " "
                                + theBooks[i].title + " "
                                + theBooks[i].author + " "
                                + theBooks[i].yearPublished);
                flag++;
            }
        }
        if (flag == 0)
            System.out.println("����/� ������ " + author
                    + " �� �������/�");
    }
    public void showAllBooks()
    {
        System.out.println(
                "����������������� �����  ��������  �����  ��� �������");
        for (int i = 0; i < count; i++) {

            System.out.println(
                    theBooks[i].id + " "
                            + theBooks[i].title + " "
                            + theBooks[i].author + " "
                            + theBooks[i].yearPublished);
        }
    }
    public void dispMenu()
    {
        System.out.println("������� 1 ��� ���������� ����� �����");
        System.out.println("������� 2 ��� ����������� ���� ����");
        System.out.println("������� 3 ��� ������ ����");
        System.out.println("������� 0 ��� ���������� ������");
    }
}