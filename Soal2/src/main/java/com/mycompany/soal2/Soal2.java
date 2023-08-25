/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.soal2;

/**
 *
 * @author mdifa
 */
public class Soal2 {

    public static void main(String[] args) {
        int i = 42;
        String s = (i<40)?"life":(i>50)?"universe":"everything";
        //Menggunakan ternary yang memiliki kondisi:
        //Jika i kurang dari 40 akan s = "life", jika i lebih dari 50 s="universe", selain keduanya s="everything"
        System.out.println(s);
    }
}
