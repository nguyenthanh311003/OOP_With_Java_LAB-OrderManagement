
package gui;

import java.util.Scanner;
import manager.Management;


public class Menu {
    
    Scanner sc = new Scanner(System.in);
    public void orderMenu(){
        Management m = new Management();
        int op;
        boolean cont = true;
        String s;
        m.customerLoadFromFile();
        m.orderLoadFromFile();
        m.productLoadFromFile();
        do {
            try {
                System.out.println("<====================Order Management====================>");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~Customer Part~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("| 1- List all Products                                   |");
                System.out.println("| 2- List all Customers                                  |");
                System.out.println("| 3- Search a Customer                                   |");
                System.out.println("| 4- Add a Customer                                      |");
                System.out.println("| 5- Update a Customer                                   |");
                System.out.println("~~~~~~~~~~~~~~~~~~~~Order Part~~~~~~~~~~~~~~~~~~~");
                System.out.println("| 6- List all Orders in ascending order of Customer name |");
                System.out.println("| 7- List all pending Orders                             |");
                System.out.println("| 8- Add an Order                                        |");
                System.out.println("| 9- Update an Order                                     |");
                System.out.println("| 10- Delete an Order based on its ID                     |");
                System.out.println("| Others- Quit                                           |");
                System.out.println("<========================================================>");
                System.out.print("Enter your option or press any key except from 1 to 9 to quit menu: ");
                op = Integer.parseInt(sc.nextLine());
                switch (op) {
                    case 1:
                        boolean b = true;
                        do {
                            m.productDisplay();
                            System.out.print("Would you like yo return to the menu ? (press y to return menu or press any key to stop): ");
                            s = sc.nextLine();
                            if (s.equals("y") || s.equals("Y")) {
                                b = false;
                                cont = true;
                            } else {
                                b = true;
                            }
                        } while (b);
                        break;
                        
                    case 2:
                        boolean c = true;
                        do {
                            m.customerDisplay();
                            System.out.print("Would you like yo return to the menu ? (press y to return menu or press any key to stop): ");
                            s = sc.nextLine();
                            if (s.equals("y") || s.equals("Y")) {
                                c = false;
                                cont = true;
                            } else {
                                c = true;
                            }
                        } while (c);
                        break;
                        
                    case 3:
                        boolean d = true;
                        do {
                        m.searchCustomer();
                        System.out.print("Would you like yo return to the menu ? (press y to return menu or press any key to stop): ");
                        s = sc.nextLine();
                        if (s.equals("y") || s.equals("Y")) {
                            d = false;
                            cont = true;
                        } else {
                            d = true;
                        }
                        }while(d);
                        break;
                        
                    case 4:
                        boolean a = true;
                        do {
                            m.addCustomer();
                            m.customerLoadFromFile();
                            System.out.print("Would you like yo return to the menu ? (press y to return menu or press any key to stop): ");
                            s = sc.nextLine();
                            if (s.equals("y") || s.equals("Y")) {
                                a = false;
                                cont = true;
                            } else {
                                a = true;
                            }

                        } while (a);
                        break;
                        
                    case 5:
                        boolean e = true;
                        do {
                        m.updateCustomer();
                        m.customerLoadFromFile();
                        System.out.print("Would you like yo return to the menu ? (press y to return menu or press any key to stop): ");
                        s = sc.nextLine();
                        if (s.equals("y") || s.equals("Y")) {
                            e = false;
                            cont = true;
                        } else {
                            e = true;
                        }
                        }while(e);
                        break;

                    case 6:
                        boolean f = true;
                        do {
                        m.orderDisplay();
                        System.out.print("Would you like yo return to the menu ? (press y to return menu or press any key to stop): ");
                        s = sc.nextLine();
                        if (s.equals("y")) {
                            f = false;
                            cont = true;
                        } else {
                            f = true;
                        }
                        }while(f);
                        break;
                        
                    case 7:
                        boolean k = true;
                        do {
                        m.orderPedingDisplay();
                        System.out.print("Would you like yo return to the menu ? (press y to return menu or press any key to stop): ");
                        s = sc.nextLine();
                        if (s.equals("y") || s.equals("Y")) {
                            k = false;
                            cont = true;
                        } else {
                            k = true;
                        }
                        }while(k);
                        break;

                    case 8:
                        boolean g = true;
                        do {
                        m.addOrder();
                        m.orderLoadFromFile();
                        System.out.print("Would you like yo return to the menu ? (press y to return menu or press any key to stop): ");
                        s = sc.nextLine();
                        if (s.equals("y")) {
                            g = false;
                            cont = true;
                        } else {
                            g = true;
                        }
                        } while(g);
                        break;
                        
                    case 9:
                        boolean h = true;
                        do {
                        m.updateOrder();
                        m.orderLoadFromFile();
                        System.out.print("Would you like yo return to the menu ? (press y to return menu or press any key to stop): ");
                        s = sc.nextLine();
                        if (s.equals("y") || s.equals("Y")) {
                            h = false;
                            cont = true;
                        } else {
                            h = true;
                        }
                        }while(h);
                        break;
                        
                    case 10:
                        boolean j = true;
                        do {
                        m.deleteOrder();
                        m.orderLoadFromFile();
                        System.out.print("Would you like yo return to the menu ? (press y to return menu or press any key to stop): ");
                        s = sc.nextLine();
                        if (s.equals("y") || s.equals("Y")) {
                            j = false;
                            cont = true;
                        } else {
                            j = true;
                        }
                        }while(j);
                        break;

                    default:
                        cont = false;
                        break;
                }
            } catch (NumberFormatException exception) {
                System.err.println("Please enter an integer in this situation!");
                cont = true;
            }
        } while (cont);
    }
}
