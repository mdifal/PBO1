/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restaurantmain;

/**
 *
 * @author mdifa
 */

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestaurantMain {
    private static final Logger LOGGER = Logger.getLogger(RestaurantMain.class.getName());
    
    public static void main(String[] args) {
        // Setup logging
        Handler consoleHandler = new ConsoleHandler();
        LOGGER.addHandler(consoleHandler);
        consoleHandler.setLevel(Level.ALL);
        
        Restaurant menu = new Restaurant();
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

        menu.tampilMenuMakanan();

        Scanner scanner = new Scanner(System.in);
        boolean selesai = false;
        while (!selesai) {
            LOGGER.info("\nMasukkan nama makanan (Ketik 'selesai' untuk selesai):");
            String namaMakanan = scanner.nextLine();

            if (namaMakanan.equalsIgnoreCase("selesai")) {
                selesai = true;
            } else {
                LOGGER.info("Masukkan jumlah yang akan dipesan:");
                int jumlahPesanan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline dari buffer

                menu.pesanMakanan(namaMakanan, jumlahPesanan);
            }
        }

        LOGGER.info("\nPesanan Anda:");
        menu.tampilMenuMakanan();

        scanner.close();
    }
}