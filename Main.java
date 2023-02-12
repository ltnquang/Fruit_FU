package Fruit;


import java.util.ArrayList;
import java.util.Hashtable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ACER
 */
public class Main{

    
    public static void main(String[] args) {
        ArrayList<Fruit> list_F = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> ht= new Hashtable<>();
        Library lb = new Library();
        //ThuVien tv = new ThuVien();
        while (true) {
            int choice = lb.menu();
            switch (choice) {
                case 1:
                    lb.createFruit(list_F);
                    break;
                case 2:
                    //ThuVien.displayFruit(list_F);
                    lb.viewListOrder(ht);
                    break;
                case 3:
                    lb.shopping(list_F, ht);
                    break;
                case 4:
                    return;
            }
        }
    }

    
}
