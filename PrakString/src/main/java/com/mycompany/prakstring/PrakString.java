/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prakstring;
import java.util.Scanner;
/**
 *
 * @author mdifa
 */
public class PrakString {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

        // input
        String A = sc.nextLine();
        String B = sc.nextLine();

        // Hitung panjang
        int lengthSum = A.length() + B.length();

        // Memeriksa apakah A leksikografis lebih besar dari B
        String lexio = A.compareTo(B) > 0 ? "Yes" : "No";

        // Mengganti huruf pertama di A dan B menjadi huruf besar
        A = A.substring(0, 1).toUpperCase() + A.substring(1);
        B = B.substring(0, 1).toUpperCase() + B.substring(1);

        // Menampilkan hasil
        System.out.println(lengthSum);
        System.out.println(lexio);
        System.out.println(A + " " + B);

        sc.close();
    }
}
