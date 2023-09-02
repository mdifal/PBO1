/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.datatypes;
import java.util.Scanner;

public class Datatypes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Berapa kali ingin input ");
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                String result = x + " can be fitted in:\n";
                if (x >= -128 && x <= 127) result += "* byte\n";
                if (x >= -32768 && x <= 32767) result += "* short\n";
                if (x >= -Math.pow(2, 31) && x <= Math.pow(2, 31) - 1) result += "* int\n";
                if (x >= -Math.pow(2, 63) && x <= Math.pow(2, 63) - 1) result += "* long\n";
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }
    }
}

