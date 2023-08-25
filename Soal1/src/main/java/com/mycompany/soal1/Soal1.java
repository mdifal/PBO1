/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.soal1;

/**
 *
 * @author mdifa
 */
public class Soal1 {

    public static void main(String[] args) {
       byte angka1 = 125;
       byte angka2 = 6;
       byte hasil = (byte) (angka1+angka2); //menambahkan angka1 dan angka2 bertipe byte, hasilnya akan overflow karena melebihi kapasitas type data
       System.out.println("Hasil 1 " + hasil);
    }
}
