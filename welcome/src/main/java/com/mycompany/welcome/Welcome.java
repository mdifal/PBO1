/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.welcome;

/**
 *
 * @author mdifa
 */
public class Welcome {

    public static void main(String[] args) {
      
        String greeting = "Welcome to Core Java";
        System.out.println(greeting); //print var greeting
        for (int i = 0; i < greeting.length(); i++)//untuk looping print  '='
            System.out.print("=");
        System.out.println();
    }
}
