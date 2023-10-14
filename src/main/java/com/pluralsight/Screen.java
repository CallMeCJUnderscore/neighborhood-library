package com.pluralsight;

import java.util.Scanner;

public class Screen {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        char command;
        int numOfBooks = 5;
        Book[] books = new Book[20];

        books[0] = new Book(1, "9780679783268", "Pride and Prejudice", true, "Jacob Geller");
        books[1] = new Book(2, "9780451524935", "1984", false, "");
        books[2] = new Book(3, "9780451530066", "Crime and Punishment", false, "");
        books[3] = new Book(4, "9798630242716", "Hamlet", false, "");
        books[4] = new Book(5, "9780060883287", "One Hundred Years of Solitude", false, "");

        while(true) {
            System.out.println("Welcome to the neighborhood library!");
            System.out.println("Your Options are: ");
            System.out.println("Show (A)vailable Books");
            System.out.println("Show (C)hecked Out Books");
            System.out.println("Check (I)n a Book");
            System.out.println("Check (O)ut a Book");
            System.out.println("e(X)it");
            System.out.print("Please select an option: ");
            command = scanner.next().toUpperCase().charAt(0);

            switch (command){
                case 'A':
                    showAvailableBooks(books, numOfBooks);

                case 'C':
                    showCheckedOutBooks(books, numOfBooks);
                case 'I':
                    //check in
                case 'O':
                    //check out
                case 'E':
                    System.out.println("Thank you for using the system! Goodbye!");
                    return;
                default:
                    System.out.println("ERROR: Invalid Choice.");
                    continue;
            }
        }
    }

    public static void showAvailableBooks(Book[] books, int numOfBooks) {
        for (int i = 0; i < numOfBooks; i++) {
            if (books[i].getIsCheckedOut() == false) {
                System.out.println("Book " + books[i].getId() + ": \"" + books[i].getTitle() + "\", ISBN= " + books[i].getIsbn());
            } //Ex: Book 1: "Pride and Prejudice", ISBN= 9780679783268
        }
    }
    public static void showCheckedOutBooks(Book[] books, int numOfBooks){
        System.out.println("Displaying all checked out books...\n");

        for(int i = 0; i < numOfBooks; i++){
            if(books[i].getIsCheckedOut() == true){System.out.println("Book "+books[i].getId()+", \""+books[i].getTitle()+"\" (ISBN "+books[i].getIsbn()+"), is currently checked out by "+books[i].getCheckedOutTo());}
        } //Ex: Book 1, "Pride and Prejudice" (ISBN 9780679783268), is currently checked out by Jacob Geller
    }
    public static void checkInABook(Book[] books, int numOfBooks){
        System.out.print("Please enter a book ID: ");
        int id = scanner.nextInt();
        int bookToCheck = 0;
        boolean bookFound = false;

        for(int i = 0; i<numOfBooks; i++){
            if(books[i].getId()==id){
                bookToCheck=i;
                bookFound=true;
            }

            if(bookFound==true){
                if(books[bookToCheck].getIsCheckedOut()==true){
                    System.out.println("\""+books[bookToCheck].getTitle()+"\" has been checked in!");
                    books[i].setCheckedOut(false);
                }
                else{
                    System.out.println("ERROR: \""+books[bookToCheck].getTitle()+"\" is already checked in!");
                }
            }
            else{
                System.out.println("ERROR: No book found with given ID!");
            }
        }
    }
    public static void checkOutABook(Book[] books, int numOfBooks){
        System.out.print("Please enter a book ID: ");
        int id = scanner.nextInt();
        int bookToCheck = 0;
        boolean bookFound = false;

        for(int i = 0; i<numOfBooks; i++){
            if(books[i].getId()==id){
                bookToCheck=i;
                bookFound=true;
            }

            if(bookFound==true){
                if(books[bookToCheck].getIsCheckedOut()==true){
                    System.out.println("ERROR: \""+books[bookToCheck].getTitle()+"\" has already been checked out!");
                }
                else{
                    System.out.print("Who is checking out "+books[bookToCheck].getTitle()+"? ");
                }
            }
            else{
                System.out.println("ERROR: No book found with given ID!");
            }
        }
    }

}
