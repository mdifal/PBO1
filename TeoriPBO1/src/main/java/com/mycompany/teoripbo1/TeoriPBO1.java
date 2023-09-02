/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.teoripbo1;
import java.util.Scanner;
/**
 *
 * @author mdifa
 */
public class TeoriPBO1 {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        double nilai_akhir;
        double nilai;
        
        System.out.println("Masukkan nilai Tugas :");
        nilai = sc.nextLong();
        nilai_akhir = nilai * 0.2;
        System.out.println("Masukkan nilai UTS :");
        nilai = sc.nextLong();
        nilai_akhir = nilai_akhir + nilai*0.35;
        System.out.println("Masukkan nilai UAS :");
        nilai = sc.nextLong();
        nilai_akhir = nilai_akhir + nilai*0.45;
        
         System.out.println("Nilai Akhir : " + nilai_akhir);
         System.out.print("Grade : ");
         
         if(nilai_akhir>=85){
             System.out.print("A");
         }
         else if(nilai_akhir>=75 && nilai_akhir<85){
             System.out.print("B");
         }
         else if(nilai_akhir>=65 && nilai_akhir<75){
             System.out.print("C");
         }
         else if(nilai_akhir>=49 && nilai_akhir<65){
             System.out.print("D");
         }
         else{
             System.out.print("E");
         }
    }
}
