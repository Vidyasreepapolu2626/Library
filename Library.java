import java.util.*;

class Book {
    String title;
    String author;
    boolean isIssued;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Issued: " + isIssued);
    }
}

public class Library {
    static List<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        books.add(new Book("Java Basics", "James"));
        books.add(new Book("C Programming", "Dennis"));

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Show Books\n2. Issue Book\n3. Return Book\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: showBooks(); break;
                case 2: issueBook(); break;
                case 3: returnBook(); break;
                case 4: System.exit(0);
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void showBooks() {
        for (Book b : books) {
            b.displayInfo();
        }
    }

    static void issueBook() {
        System.out.print("Enter book title to issue: ");
        String title = scanner.nextLine();
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title) && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book issued.");
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }

    static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title) && b.isIssued) {
                b.isIssued = false;
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Book not found or was not issued.");
    }
}
