package com.pluralsight;

import java.util.Scanner;

public class Screen {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String command; //create variables
        int numOfBooks = 5;
        Book[] books = new Book[20];

        //fill array with dummy books
        books[0] = new Book(1, "9780679783268", "Pride and Prejudice", true, "Jacob Geller");
        books[1] = new Book(2, "9780451524935", "1984", false, "");
        books[2] = new Book(3, "9780451530066", "Crime and Punishment", false, "");
        books[3] = new Book(4, "9798630242716", "Hamlet", false, "");
        books[4] = new Book(5, "9780060883287", "One Hundred Years of Solitude", true, "Nick Robinson");

        while(true) { //run infinitely until user decides to quit
            System.out.println("Welcome to the neighborhood library home screen!");
            System.out.println("Your Possible Actions are: ");
            System.out.println("    Show  (A)vailable Books");
            System.out.println("    Show  (C)hecked Out Books");
            System.out.println("    Check (I)n a Book");
            System.out.println("    Check (O)ut a Book");
            System.out.println("         e(X)it Program");
            System.out.print("Please select the action you would like to perform: ");
            command = scanner.nextLine().toUpperCase();

            switch (command){
                case "A":
                    showAvailableBooks(books, numOfBooks);
                    break;
                case "C":
                    showCheckedOutBooks(books, numOfBooks);
                    break;
                case "I":
                    checkInABook(books, numOfBooks);
                    break;
                case "O":
                    checkOutABook(books, numOfBooks);
                    break;
                case "X":
                    System.out.println("Thank you for using the system! Goodbye!");
                    return;
                default:
                    System.out.println("ERROR: Invalid Choice.\n\n");
            }
        }
    }

    public static void showAvailableBooks(Book[] books, int numOfBooks) {
        System.out.println("\nDisplaying available books...\n");

        //runs through the array of books and displays all entries where isCheckedOut==false
        for (int i = 0; i < numOfBooks; i++) {
            if (books[i].getIsCheckedOut() == false) {
                System.out.println("Book " + books[i].getId() + ": \"" + books[i].getTitle() + "\", ISBN= " + books[i].getIsbn());
            } //Ex: Book 1: "Pride and Prejudice", ISBN= 9780679783268
        }

        //display user menu
        System.out.println("\nWhat would you like to do next?");
        System.out.println("    (C)heck out a book");
        System.out.println("   e(X)it to Home Screen");
        System.out.print  ("Please choose one of the options listed above: ");
        String input = scanner.nextLine().toUpperCase();
        if(input.equalsIgnoreCase("C")){
            checkOutABook(books, numOfBooks);
        }
        else{
            System.out.println("\n");
        }
    }
    public static void showCheckedOutBooks(Book[] books, int numOfBooks){
        System.out.println("\nDisplaying all checked out books...\n");

        //runs through the array of books and displays all entries where isCheckedOut==true
        for(int i = 0; i < numOfBooks; i++){
            if(books[i].getIsCheckedOut() == true){System.out.println("Book "+books[i].getId()+", \""+books[i].getTitle()+"\" (ISBN "+books[i].getIsbn()+"), is currently checked out by "+books[i].getCheckedOutTo());}
        }//Ex: Book 1, "Pride and Prejudice" (ISBN 9780679783268), is currently checked out by Jacob Geller

        //display user menu
        System.out.println("What would you like to do next?");
        System.out.println("    (C)heck in a book");
        System.out.println("   e(X)it to Home Screen");
        System.out.print  ("Please choose one of the options listed above: ");
        String input = scanner.nextLine().toUpperCase();
        if(input.equalsIgnoreCase("C")){
            checkInABook(books, numOfBooks);
        }
        else{
            System.out.println("\n");
        }
    }
    public static void checkInABook(Book[] books, int numOfBooks){
        //prompt user
        System.out.print("\nPlease enter the ID of the book you would like to check in: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int bookToCheck = 0;
        boolean bookFound = false;

        for(int i = 0; i<numOfBooks; i++) { //check if given ID exists in library
            if (books[i].getId() == id) {
                bookToCheck = i;
                bookFound = true;
            }
        }
            if(bookFound==true){ //if ID does exist
                if(books[bookToCheck].getIsCheckedOut()==true){ //book can be checked in
                    System.out.println("\""+books[bookToCheck].getTitle()+"\" has been checked in!\n\n");
                    books[bookToCheck].setIsCheckedOut(false);
                }
                else{ //book cannot be checked in
                    System.out.println("ERROR: \""+books[bookToCheck].getTitle()+"\" is already checked in!\n\n");
                }
            }
            else{ //if ID does not exist
                System.out.println("ERROR: No book found with given ID!\n\n");
            }
        }

    public static void checkOutABook(Book[] books, int numOfBooks){
        //prompt user
        System.out.print("Please enter the ID of the book you would like to check out: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int bookToCheck = 0;
        boolean bookFound = false;

        //check if given ID exists in library
        for(int i = 0; i<numOfBooks; i++) {
            if (books[i].getId() == id) {
                bookToCheck = i;
                bookFound = true;
            }
        }
            if(bookFound==true){ //if ID does exist
                if(books[bookToCheck].getIsCheckedOut()==true){ //book cannot be checked out
                    System.out.println("ERROR: \""+books[bookToCheck].getTitle()+"\" has already been checked out!\n\n");
                }
                else{ //book can be checked out
                    String name = null;
                    while(name==null) {
                        System.out.print("Who is checking out \"" + books[bookToCheck].getTitle() + "\"? ");
                        name = scanner.nextLine();
                    }
                    System.out.println("\""+books[bookToCheck].getTitle()+"\" has been checked out to "+name+"! Enjoy your book!\n\n"); //update library with new info
                    books[bookToCheck].setIsCheckedOut(true);
                    books[bookToCheck].setCheckedOutTo(name);
                }
            }
            else{ //if ID does not exist
                System.out.println("ERROR: No book found with given ID!\n\n");
            }
        }
}




