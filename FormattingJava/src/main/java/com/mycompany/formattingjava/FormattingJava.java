/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.formattingjava;

/**
 *
 * @author mdifa
 */
import java.util.Scanner;

public class FormattingJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Jumlah Input
        System.out.print("Masukkan jumlah data: ");
        int numInputs = scanner.nextInt();

        // Inisialisasi arrays untuk menyimpan data
        String[] inputStrings = new String[numInputs];
        int[] inputIntegers = new int[numInputs];

        // Membaca input
        for (int i = 0; i < numInputs; i++) {
         
            inputStrings[i] = scanner.next();
            inputIntegers[i] = scanner.nextInt();
        }
        // Print garis pemisah
        System.out.println("================================");
        // Mencetak semua input
        for (int i = 0; i < numInputs; i++) {
            System.out.printf("%-15s%03d%n", inputStrings[i].toLowerCase(), inputIntegers[i]);
        }
        scanner.close();
}
}