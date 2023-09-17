/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.upinipin;

/**
 *
 * @author mdifa
 */
public class UpinIpin {
    public static void main(String[] args) {
        Item name = new Item("upin");
    }

    public static class Item {
        private String name;

        private Item() {
            name = "Ipin";
        }

        public Item(String name) {
            this();
            System.out.println(this.name);
        }
    }
}
