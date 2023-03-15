package manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import object.Customer;
import object.Order;
import object.Product;

public class Management {

    private static Scanner sc = new Scanner(System.in);
    private List<Product> pList;
    private List<Customer> cList;
    private List<Order> oList;

    public Management() {
        pList = new ArrayList<>();
        cList = new ArrayList<>();
        oList = new ArrayList<>();
    }

    public void customerDisplay() {
        for (Customer c : cList) {
            System.out.println(c);
        }
    }

    public void productDisplay() {
        for (Product p : pList) {
            System.out.println(p);
        }
    }

    public void orderDisplay() {
        for (int i = 0; i < oList.size() - 1; i++) {
            for (int j = i + 1; j < oList.size(); j++) {
                if (Validation.cName(oList.get(i).getOrderOfCustomerID(), cList, oList).charAt(0) > Validation.cName(oList.get(j).getOrderOfCustomerID(), cList, oList).charAt(0)) {

                    Collections.swap(oList, i, j);

                }
            }
        }

        for (Order o : oList) {
            System.out.printf("%s,%s,%s,%d,%s,%s\n", o.getOrderID(), o.getOrderOfCustomerID(), o.getOrderOfProductID(), o.getOrderQuantity(), o.getOrderDate(), o.getStatus());
        }
    }

    public void addCustomer() {
        String customerID, customerName, customerAddress, customerPhone;

        customerDisplay();

        customerID = Validation.getCustomerID("Enter Customer ID with form (Cxxx): ", cList, 1);
        customerName = Validation.getCustomerName("Enter Customer name: ", cList, 1);
        customerAddress = Validation.getCustomerAddress("Enter Customer address: ", cList, 1);
        customerPhone = Validation.getCustomerPhone("Enter Customer phone number: ", cList, 1);

//        pList.add(new Publisher(publisherId, publisherName, phoneNumber));
        cList.add(new Customer(customerID, customerName, customerAddress, customerPhone));
        customerDisplay();
        this.customerSaveToFile();
        cList.removeAll(cList);
    }

//    public void searchCustomer() {
//        String customerCode;
//        if (cList.isEmpty()) {
//            System.out.println("Don't have any Customer in list!");
//        } else {
//            customerCode = Validation.getCustomerID("Enter Customer ID with form (Cxxx): ", cList, 2);
//            for (Customer c : cList) {
//
//                if (customerCode.equals(c.getCustomerID())) {
//                    System.out.println(c);
//                    return;
//                } else {
//                    System.out.println("Don't have any following the format which is giving!");
//                }
//                break;
//            }
//
//        }
//    }
    public void searchCustomer() {
        String customerIDSearch;

        this.customerDisplay();

        System.out.print("\n\nEnter ID of customer you want to search: ");
        customerIDSearch = sc.nextLine();

        for (Customer c : cList) {
            if (customerIDSearch.equals(c.getCustomerID())) {
                System.out.println(c);
                return;
            }
        }

        if (customerIDSearch.equals("")) {
            for (Customer c : cList) {
                System.out.print(c);
            }
            return;
        }

        System.err.println("This customer does not exist!!!!!");

    }

    public void updateCustomer() {
        String customerIDForUpdate;
        String customerNameForUpdate;
        String customerAddressForUpdate;
        String customerPhoneForUpdate;

        customerDisplay();
        customerIDForUpdate = Validation.getCustomerID("Enter Customer ID with form (Cxxx): ", cList, 3);
        if (cList.isEmpty()) {
            System.out.println("List is empty!");
        } else {

            for (Customer c : cList) {
                if (c.getCustomerID().equals(customerIDForUpdate)) {
                    customerNameForUpdate = Validation.getCustomerName("Enter new Customer name: ", cList, 2);
                    if (customerNameForUpdate.equals("")) {
                        c.setCustomerName(c.getCustomerName());
                    } else {
                        c.setCustomerName(customerNameForUpdate);
                    }

                    customerAddressForUpdate = Validation.getCustomerAddress("Enter new Customer address: ", cList, 2);
                    if (customerAddressForUpdate.equals("")) {
                        c.setCustomerAddress(c.getCustomerAddress());
                    } else {
                        c.setCustomerAddress(customerAddressForUpdate);
                    }

                    customerPhoneForUpdate = Validation.getCustomerPhone("Enter new Customer phone: ", cList, 2);
                    if (customerPhoneForUpdate.equals("")) {
                        c.setPhone(c.getPhone());
                    } else {
                        c.setPhone(customerPhoneForUpdate);
                    }
                }
            }
            System.out.println("Update Customer Success!");
            customerDisplay();
            this.customerSaveToFile();
            cList.removeAll(cList);
        }
    }

    public void customerSaveToFile() {
        try {
            File f = new File("customer.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Customer c : cList) {
                bw.write(c.toString());
            }
            System.out.println("The Customer list has been saved to file.");
            bw.close();
            fw.close();
        } catch (Exception exception) {
            System.out.println("Save to file failed!");
        }
    }

    public void customerLoadFromFile() {
        try {
            File f = new File("customer.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] info = line.split("[,]");
                String customerID = info[0].trim();
                String customerName = info[1].trim();
                String customerAddress = info[2].trim();
                String customerPhone = info[3].trim();

                cList.add(new Customer(customerID, customerName, customerAddress, customerPhone));
            }
            fr.close();
            br.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void productLoadFromFile() {
        try {
            File f = new File("product.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] info = line.split("[,]");
                String productID = info[0].trim();
                String productName = info[1].trim();
                String unit = info[2].trim();
                String origin = info[3].trim();
                double price = Double.parseDouble(info[4].trim());

                pList.add(new Product(productID, productName, unit, origin, price));
            }
            fr.close();
            br.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void orderLoadFromFile() {
        try {
            File f = new File("order.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] info = line.split("[,]");
                String orderID = info[0].trim();
                String customerID = info[1].trim();
                String productID = info[2].trim();
                int orderQuantity = Integer.parseInt(info[3].trim());
                String orderDate = info[4].trim();
                String status = info[5].trim();

                oList.add(new Order(orderID, customerID, productID, orderQuantity, orderDate, status));
            }
            fr.close();
            br.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void orderSaveToFile() {
        try {
            File f = new File("order.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Order o : oList) {
                bw.write(o.toString());
            }
            System.out.println("The Order list has been saved to file.");
            bw.close();
            fw.close();
        } catch (Exception exception) {
            System.out.println("Save to file failed!");
        }
    }

    public void addOrder() {
        String orderID, customerID, productID, orderDate, status;
        int orderQuantity;
        orderDisplay();
        orderID = Validation.getOrderID("Enter Order ID with form (Dxxx): ", oList, 1);
        customerID = Validation.getCustomerID("Enter Customer ID with form (Cxxx): ", cList, 3);
        productID = Validation.getProductID("Enter Product ID with form (Pxxx): ", pList, 3);
        orderQuantity = Validation.getQuantity("Quantity of this Book: ", oList, 1);
        orderDate = Validation.getDate("Enter a date as form (dd/mm/yyyy) witch d, m, y is a digit from 0 to 9: ", oList, 1);
        status = Validation.getStatus("Enter t or f (t: True, f: False) to set a order status: ", oList, 1);
        oList.add(new Order(orderID, customerID, productID, orderQuantity, orderDate, status));
        orderDisplay();
        this.orderSaveToFile();
        oList.removeAll(oList);
    }

    public void updateOrder() {
        String orderIDForUpdate, customerID, productID, orderQuantity, orderDate, status;

        orderDisplay();
        orderIDForUpdate = Validation.getOrderID("Enter Order ID with form (Dxxx): ", oList, 3);

        if (oList.isEmpty()) {
            System.err.println("List is empty!");
        } else {
            for (Order o : oList) {
                if (o.getOrderID().equals(orderIDForUpdate)) {
                    customerID = Validation.getCustomerID("Enter Customer ID with form (Cxxx): ", cList, 4);

                    if (customerID.equals("")) {
                        o.setOrderOfCustomerID(o.getOrderOfCustomerID());
                    } else {
                        o.setOrderOfCustomerID(customerID);
                    }

                    productID = Validation.getProductID("Enter Product ID with form (Pxxx): ", pList, 4);
                    if (productID.equals("")) {
                        o.setOrderOfProductID(o.getOrderOfProductID());
                    } else {
                        o.setOrderOfProductID(productID);
                    }

                    do {
                        System.out.print("Enter new quantity: ");
                        orderQuantity = sc.nextLine();
                        if (orderQuantity.equals("")) {
                            o.setOrderQuantity(o.getOrderQuantity());
                            break;
                        } else if (orderQuantity.matches("^([0-9]){1,15}$")) {
                            o.setOrderQuantity(Integer.parseInt(orderQuantity));
                            break;
                        } else {
                            System.err.println("A quantity must be an integer number and greater than 0");
                        }

                    } while (true);

                    orderDate = Validation.getDate("Enter a date as form (dd/mm/yyyy) witch d, m, y is a digit from 0 to 9: ", oList, 2);
                    if (orderDate.equals("")) {
                        o.setOrderDate(o.getOrderDate());
                    } else {
                        o.setOrderDate(orderDate);
                    }

                    status = Validation.getStatus("Enter t or f (t: True, f: False) to set a order status: ", oList, 2);
                    if (status.equals("")) {
                        o.setStatus(o.getStatus());
                    } else {
                        o.setStatus(status);
                    }
                }

            }

            System.out.println("Update Order success <3");
            this.orderSaveToFile();
            oList.removeAll(oList);
        }
    }

    public void deleteOrder() {
        String orderID;
        String s = "";
        if (oList.isEmpty()) {
            System.out.println("Have no any Order in list!");
        } else {
            orderDisplay();
            orderID = Validation.getOrderID("Enter Order ID with form (Dxxx): ", oList, 3);
            for (Order o : oList) {
                if (o.getOrderID().equals(orderID)) {
                    System.out.print("Do you really want to delete this order!(Press y to confirm or any key except y to cancel): ");
                    s = sc.nextLine();
                    if (s.equals("y")) {
                        oList.remove(o);
                        System.out.println("Delete Book Success <3");
                        break;
                    } else {
                        break;
                    }

                }
            }
            orderDisplay();
            this.orderSaveToFile();
            oList.removeAll(oList);
        }
    }

    public void orderPedingDisplay() {
        for (Order o : oList) {
            if (o.getStatus().equals("false")) {
                System.out.println(o);
            }
        }
    }

}
