/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantmain;

/**
 *
 * @author mdifa
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    private List<Product> menuItems;
    private Sales sales;

    public Restaurant() {
        menuItems = new ArrayList<>();
        sales = new Sales();
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        if (harga >= 0 && stok >= 0) {
            Product item = new Product(nama, harga, stok);
            menuItems.add(item);
        } else {
            System.out.println("Harga dan stok makanan tidak boleh negatif.");
        }
    }

    public void tampilMenuMakanan() {
        System.out.println("Menu Makanan:");
        System.out.println("No.\tNama\tHarga\tStok");
        for (int i = 0; i < menuItems.size(); i++) {
            Product item = menuItems.get(i);
            System.out.println((i + 1) + "\t" + item.getProductName() + "\tRp. " + item.getPrice() + "\t" + item.getQuantity());
        }
    }

    public void pesanMakanan(Scanner scanner) {
        boolean ordering = true;
        Sales order = new Sales();

        while (ordering) {
            tampilMenuMakanan();
            System.out.print("Pilih menu (No.): ");
            int choice = scanner.nextInt();
            if (choice < 1 || choice > menuItems.size()) {
                System.out.println("Menu tidak valid.");
                continue;
            }
            Product selectedItem = menuItems.get(choice - 1);
            System.out.print("Jumlah pesanan: ");
            int quantity = scanner.nextInt();

            if (quantity <= 0) {
                System.out.println("Jumlah pesanan tidak valid.");
                continue;
            }

            if (quantity > selectedItem.getQuantity()) {
                System.out.println("Stok tidak mencukupi.");
                continue;
            }

            order.addProduct(new Product(selectedItem.getProductName(), selectedItem.getPrice(), quantity));
            selectedItem.decreaseQuantity(quantity);

            System.out.println("Pesanan Anda: " + selectedItem.getProductName() + " x" + quantity);
            System.out.print("Pesan lagi? (y/n): ");
            String again = scanner.next();
            if (!again.equalsIgnoreCase("y")) {
                ordering = false;
            }
        }

        System.out.println("Pesanan Anda:");
        for (Product product : order.getProducts()) {
            System.out.println(product.getProductName() + "\t x" + product.getQuantity() + "\t Rp. " + (product.getPrice() * product.getQuantity()));
        }
        System.out.println("Total Bayar: Rp. " + order.calculateTotal());
    }
}
