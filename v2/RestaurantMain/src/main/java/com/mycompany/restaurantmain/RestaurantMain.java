/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restaurantmain;

/**
 *
 * @author mdifa
 */


import java.util.Scanner;

public class RestaurantMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant menu = new Restaurant();

        // Tambahkan menu makanan
        menu.tambahMenuMakanan("Bala-Bala", 1_000, 20);
        menu.tambahMenuMakanan("Gehu", 1_000, 20);
        menu.tambahMenuMakanan("Tahu", 1_000, 0);
        menu.tambahMenuMakanan("Molen", 1_000, 20);
        menu.tambahMenuMakanan("Devil Fruit", 1_000, 20);
        menu.tambahMenuMakanan("Tsukoyomi Fruit", 1_000, 20);
        menu.tambahMenuMakanan("Nasi Goreng", 1_000, 0);
        menu.tambahMenuMakanan("Semangka Goreng", 1_000, 20);
        menu.tambahMenuMakanan("Melon Goreng", 1_000, 0);
        menu.tambahMenuMakanan("Dimsum Ayam", 1_000, 20);


        System.out.println("Selamat datang di Restaurant!");
        menu.pesanMakanan(scanner);

        scanner.close();
    }
}

