/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gajiagen;

/**
 *
 * @author mdifa
 */
import java.util.Scanner;

public class GajiAgen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        int jumlahPenjualan = scanner.nextInt();

        int gajiPokok = 500000;
        int hargaItem = 50000;
        double bonusPenjualan = 0;

        if (jumlahPenjualan >= 40) {
            bonusPenjualan = jumlahPenjualan * hargaItem * 0.25; // Bonus 25%
        } else if (jumlahPenjualan > 80) {
            bonusPenjualan = jumlahPenjualan * hargaItem * 0.35; // Bonus 35%
        } else if (jumlahPenjualan < 15) {
            gajiPokok -= (15 - jumlahPenjualan) * hargaItem * 0.15; // Denda pemotongan gaji
        }
        else {
            bonusPenjualan = jumlahPenjualan * hargaItem * 0.1; // Bonus 10%
        }

        // Total gaji
        int totalGaji = (int) (gajiPokok + bonusPenjualan);

        // Menampilkan hasil
        System.out.println(totalGaji);

        scanner.close();
    }
}
