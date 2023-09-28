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
import java.util.logging.Logger;

public class Restaurant {
    private static final Logger LOGGER = Logger.getLogger(Restaurant.class.getName());
    private List<MenuItem> menuItems;
    
    public Restaurant() {
        menuItems = new ArrayList<>();
 
    }


    public void tambahMenuMakanan(String nama, double harga, int stok) {
        if (harga >= 0 && stok >= 0) {
            MenuItem item = new MenuItem(nama, harga, stok);
            menuItems.add(item);
        } else {
            LOGGER.warning("Harga dan stok makanan tidak boleh negatif.");
        }
    }
    
public void tampilMenuMakanan() {
    for (MenuItem item : menuItems) {
        if (!item.isOutOfStock()) {
            String message = String.format("%s[%d]\tRp. %.2f", item.getNama(), item.getStok(), item.getHarga());
            LOGGER.info(message);
        }
    }
}

    
public void pesanMakanan(String nama, int jumlahPesanan) {
    for (MenuItem item : menuItems) {
        if (item.getNama().equalsIgnoreCase(nama)) {
            if (!item.isOutOfStock()) {
                if (item.getStok() >= jumlahPesanan) {
                    item.kurangiStok(jumlahPesanan);
                    String pesananMessage = String.format("Pesanan Anda: %s (Jumlah: %d)", item.getNama(), jumlahPesanan);
                    LOGGER.info(pesananMessage);
                } else {
                    String stokTidakCukupMessage = String.format("Maaf, stok %s tidak mencukupi.", item.getNama());
                    LOGGER.warning(stokTidakCukupMessage);
                }
            } else {
                String habisMessage = String.format("Maaf, %s habis.", item.getNama());
                LOGGER.warning(habisMessage);
            }
            return;
        }
    }
    String tidakDitemukanMessage = String.format("Menu %s tidak ditemukan.", nama);
    LOGGER.warning(tidakDitemukanMessage);
}

}

class MenuItem {
    private String nama;
    private double harga;
    private int stok;
    
    public MenuItem(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
    
    public String getNama() {
        return nama;
    }
    
    public double getHarga() {
        return harga;
    }
    
    public int getStok() {
        return stok;
    }
    
    public boolean isOutOfStock() {
        return stok == 0;
    }
    
    public void kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            stok -= jumlah;
        }
    }
}
