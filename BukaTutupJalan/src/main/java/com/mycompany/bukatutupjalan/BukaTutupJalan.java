/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bukatutupjalan;

/**
 *
 * @author mdifa
 */
import java.util.Scanner;

public class BukaTutupJalan {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan plat nomor untuk 4 mobil (pisahkan dengan spasi):");
        String input = scanner.nextLine();
        scanner.close();

        String[] platNumbers = input.split(" ");
        int sum = 0;

        for (String platNumber : platNumbers) {
            int number = Integer.parseInt(platNumber);
            sum += number;
        }

        if ((sum - 999999) % 5 != 0) {
            System.out.println("Berhenti");
        } else {
            System.out.println("Jalan");
    }
    }
}

