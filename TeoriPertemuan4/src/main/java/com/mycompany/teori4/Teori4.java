/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.teori4;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mdifa
 */
// Kelas MathOperations
class MathOperations {
    public static int tambah(int a, int b) {
        return a + b;
    }
}

// Kelas Calculator
class Calculator {
    public int hitung(int x, int y) {
        return MathOperations.tambah(x, y);
    }
}

// Kelas Animal (kelas induk)
class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }
}

// Kelas Dog (kelas anak yang mewarisi dari Animal)
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void bark() {
        System.out.println("Woof! Woof!");
    }
}

public class Teori4 {
    public static void main(String[] args) {
        // Contoh Dependency
        Calculator calc = new Calculator();
        int hasil = calc.hitung(5, 3);
        System.out.println("Hasil perhitungan: " + hasil);

        // Contoh Aggregation
        Library library = new Library("Public Library");
        library.addBook(new Book("The Great Gatsby"));
        library.addBook(new Book("To Kill a Mockingbird"));

        // Contoh Inheritance
        Dog myDog = new Dog("Buddy");
        myDog.eat();
        myDog.bark();
    }
}

// Kelas Book (untuk contoh Aggregation)
class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// Kelas Library (untuk contoh Aggregation)
class Library {
    private String libraryName;
    private List<Book> books;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
