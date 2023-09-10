/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bigint;

/**
 *
 * @author mdifa
 */
import java.util.*;
import java.math.*;

public class BigInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the input as strings
        String strA = sc.nextLine();
        String strB = sc.nextLine();
        
        // Create BigInteger objects from the input strings
        BigInteger a = new BigInteger(strA);
        BigInteger b = new BigInteger(strB);
        
        // Calculate the sum and product
        BigInteger sum = a.add(b);
        BigInteger product = a.multiply(b);
        
        // Print the results without leading zeros
        System.out.println(sum.toString());
        System.out.println(product.toString());
        
        sc.close();
    }
}
