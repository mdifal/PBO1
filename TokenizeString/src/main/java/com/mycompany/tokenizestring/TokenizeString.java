/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tokenizestring;
import java.util.Scanner;
/**
 *
 * @author mdifa
 */
import java.util.Scanner;

public class TokenizeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        String str = sc.nextLine();
        

        String[] tokens = str.split("[^A-Za-z]+");
        
        // Print the number of tokens
        System.out.println(tokens.length);
        
        // Print each token on a new line
        for (String token : tokens) {
            System.out.println(token);
        }
        
        sc.close();
    }
}
