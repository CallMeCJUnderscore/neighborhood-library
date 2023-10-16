package com.pluralsight;

public class Book {

    /*-----------VARIABLES---------------*/

    private int id;
    private String isbn;
    private String title;
    boolean isCheckedOut;
    private String checkedOutTo;

    /*------------CONSTRUCTORS-----------*/

    public Book() { //default
        id= 0;
        isbn = "";
        title = "";
        isCheckedOut = false;
        checkedOutTo = "";
    }

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    /*----------GETTERS/SETTERS----------*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setIsCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    /*-------------FUNCTIONS-------------*/

    public void checkOut(String checkedOutTo){
        if(isCheckedOut){
            System.out.println("This book was already checked out!");
        }
        else{
            System.out.println("This book was successfully checked out to: " + checkedOutTo);
            this.checkedOutTo = checkedOutTo;
            isCheckedOut = true;
        }

    }
    public void checkIn(){
        if(!isCheckedOut){
            System.out.println("This book isn't checked out!");
        }
        else{
            System.out.println("This book has been checked in.");
            checkedOutTo = "";
            isCheckedOut = false;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                ", checkedOutTo='" + checkedOutTo + '\'' +
                '}';
    }
}
