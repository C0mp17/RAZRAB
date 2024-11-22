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
                    "превышен лимит хранения книг");
        }
    }
    public void searchByAuthorName()
    {
        System.out.println("введите имя автора:");
        String author = input.nextLine();
        int flag = 0;
        System.out.println(
                "идентификационный номер  название  автор  год выпуска");

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
            System.out.println("книг/и автора " + author
                    + " не найдена/о");
    }
    public void showAllBooks()
    {
        System.out.println(
                "идентификационный номер  название  автор  год выпуска");
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
        System.out.println("нажмите 1 для добавления новой книги");
        System.out.println("нажмите 2 для отображения всех книг");
        System.out.println("нажмите 3 для поиска книг");
        System.out.println("нажмите 0 для завершения работы");
    }
}