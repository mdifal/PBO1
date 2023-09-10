/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.operatorjava;

/**
 *
 * @author mdifa
 */
import java.util.Scanner;

public class OperatorJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca input dalam format "A operator B"
        String input = scanner.nextLine();
        scanner.close();

        // Memecah input berdasarkan spasi
        String[] parts = input.split(" ");

        // Mengambil nilai A, operator, dan B dari array parts
        int A = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int B = Integer.parseInt(parts[2]);

        // Melakukan operasi matematika sesuai operator
        int result = 0;

        switch (operator) {
            case "+":
                result = A + B;
                break;
            case "-":
                result = A - B;
                break;
            case "*":
                result = A * B;
                break;
            case "/":
                result = A / B;
                break;
            case "%":
                result = A % B;
                break;
            default:
                System.out.println("Operator tidak valid");
                return;
        }

        // Menampilkan hasil operasi
        System.out.println(result);
    }
}

