package Fruit;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ACER
 */
public class Library {

    public int GetInt(String mess) {
        System.out.println(mess);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public double GetDouble(String mess) {
        System.out.println(mess);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    public String GetLine(String mess) {
        System.out.println(mess);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }

    public int generateID(ArrayList<Fruit> list_F) {
        int id = 0;
        if (list_F.size() == 0) {
            return 1;
        } else {

            for (Fruit s : list_F) {
                if (s.getId() == list_F.size()) {
                    id = s.getId() + 1;
                }
            }
        }
        return id;
    }

    public void createFruit(ArrayList<Fruit> list_F) {
        int id = generateID(list_F);
        String name = GetLine("Enter fruit name: ");
        double price = GetDouble("Enter fruit price: ");
        int quantity = GetInt("Enter fruit quantity");
        String origin = GetLine("Enter fruit origin: ");
        list_F.add(new Fruit(id, name, price, quantity, origin));
    }

    public void displayFruit(ArrayList<Fruit> list_F) {
        for (Fruit f : list_F) {
            System.out.println("Id: " + f.getId() + " - Name: " + f.getName() + " - Price: " + f.getPrice() + " - quantity:" + f.getQuantity() + " - origin: " + f.getOrigin());
        }
    }

    public void viewOrder() {

    }

    public void shopping(ArrayList<Fruit> list_F, Hashtable<String, ArrayList<Order>> ht) {
         if(ht.isEmpty()){
            System.out.println("No Product");
            return;
        }
        displayFruit(list_F);
        String name = GetLine("Enter fruit name: ");
        ArrayList<Order> list_o = new ArrayList<>();
        for (Fruit f : list_F) {
            if (name.equals(f.getName())) {          
                int id = f.getId();
                double price = f.getPrice();
                int quantity = f.getQuantity();
                list_o.add(new Order(id, name, quantity, price));
                displayListOrder(list_o);
                String customer = GetLine("Enter Customer of name: ");
                ht.put(customer,list_o);
                System.out.println("Add Successfull");
            }
        }
    }

    private void displayListOrder(ArrayList<Order> list_o) {
        double total = 0;
        for (Order o : list_o) {
            System.out.println("Id: " + o.getId() + " - Customer of name: " + o.getName() + " - quanlity: " + o.getQuanlity() + " - price: " + o.getPrice());
            total += o.getPrice() * o.getQuanlity();
        }
        System.out.println("Total: "+ total);
    }
    
    public void viewListOrder(Hashtable<String, ArrayList<Order>> ht){
        if(ht.isEmpty()){
            System.out.println("No Order");
            return;
        }
        for(String name: ht.keySet()){
            System.out.println("Customer: "+ name);
            ArrayList<Order> array_o = ht.get(name);
            displayListOrder(array_o);
        }
    }
    
    public int menu() {
        Library lb = new Library();
        System.out.println("1. Create Fruit");
        System.out.println("2. View Order");
        System.out.println("3. Shopping");
        System.out.println("4. Exit");
        int choice = lb.GetInt("Enter your choice: ");
        return choice;
    }
}
