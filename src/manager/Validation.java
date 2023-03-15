package manager;

import java.util.List;
import java.util.Scanner;
import object.Customer;
import object.Order;
import object.Product;

public class Validation {

    private static Scanner sc = new Scanner(System.in);
    private static String cID;
    private static String oID;
    private static String pID;
//Customer begin

    public static String getCustomerID(String msg, List<Customer> cList, int mode) {
        //mode 1 = add
        //mode 2 = search
        //mode 3 = check
        //mode 4 = update
        boolean cont = true;
        do {
            try {
                String pattern = "(C)[0-9][0-9][0-9]";
                System.out.print(msg);
                cID = sc.nextLine();
                if (customerIDExist(cID, cList) && cID.matches(pattern) && mode == 1) {
                    throw new Exception();
                }

                if (!customerIDExist(cID, cList) && cID.matches(pattern) && mode == 1) {
                    return cID;
                }

                if (!customerIDExist(cID, cList) && cID.matches(pattern) && (mode == 2 || mode == 3)) {
                    throw new NullPointerException();
                }

                if (customerIDExist(cID, cList) && (mode == 3 || mode == 4 || mode == 2)) {
                    return cID;
                } else if (cID.equals("") && mode == 4) {
                    return cID;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException exception) {
                System.err.println("Please enter an Customer ID as form (Cxxx) with x is a digit from 0 to 9");
            } catch (NullPointerException exception) {
                System.err.println("Customer ID not exist!");
            } catch (Exception exception) {
                System.err.println("Customer ID already exist!");
            }
        } while (cont);
        return cID;
    }

    public static String getCustomerName(String msg, List<Customer> cList, int mode) {
        //mode 1 = input
        //mode 2 = update
        boolean cont = true;
        String s = "";
        do {
            try {
                String pattern = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*${5,30}";
                System.out.print(msg);
                s = sc.nextLine();

                if (s.matches(pattern) && (mode == 1 || mode == 2)) {
                    return s;
                } else if (s.equals("") && mode == 2) {

                    return s;

                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException exception) {
                System.err.println("Please enter Book name in range a to z and in length 5 to 30 characters!");
                cont = true;
            }
        } while (cont);
        return s;
    }

    public static String getCustomerAddress(String msg, List<Customer> cList, int mode) {
        //mode 1 = input
        //mode 2 = update
        boolean cont = true;
        String s = "";
        do {
            try {
                String pattern = "[\\s\\S]*."; //chỉnh lại thêm số vào được
                System.out.print(msg);
                s = sc.nextLine();
                if (s.matches(pattern) && (mode == 1 || mode == 2)) {
                    return s;
                } else if (s.equals("") && mode == 2) {
                    return s;
                } else {
                    throw new Exception();
                }

            } catch (Exception exception) {
                System.err.println("Please enter Customer address to continuous!");
                cont = true;
            }
        } while (cont);
        return s;
    }

    public static String getCustomerPhone(String msg, List<Customer> cList, int mode) {
        boolean cont = true;
        String s = "";
        do {
            try {
                String pattern = "[0-9]{10,12}";
                System.out.print(msg);
                s = sc.nextLine();

                if (s.matches(pattern) && (mode == 1 || mode == 2)) {
                    return s;
                } else if (s.equals("") && mode == 2) {
                    return s;
                } else {
                    throw new Exception();
                }

            } catch (Exception exception) {
                System.err.println("Please enter a Customer phone number in length 10 to 12 and just type number!");
                cont = true;
            }
        } while (cont);
        return s;
    }

    public static boolean customerIDExist(String customerID, List<Customer> cList) {
        for (Customer c : cList) {
            if (c.getCustomerID().equals(customerID)) {
                return true;
            }
        }
        return false;
    }
//Customer end

//Order begin
    public static String getOrderID(String msg, List<Order> oList, int mode) {
        //mode 1 = input
        //mode 3 = update
        //mode 3 = delete
        boolean cont = true;
        do {
            try {
                String pattern = "(D)[0-9][0-9][0-9]";
                System.out.print(msg);
                oID = sc.nextLine();

                if (!oID.matches(pattern)) {
                    throw new NumberFormatException();
                }

                if (orderIDExist(oID, oList) && mode == 1) {
                    throw new Exception();
                }

                if (!orderIDExist(oID, oList) && mode == 3) {
                    throw new NullPointerException();
                }

                cont = false;
            } catch (NumberFormatException exception) {
                System.err.println("Please enter an Order ID as form (Dxxx) with x is a digit from 0 to 9!");
                cont = true;
            } catch (NullPointerException exception) {
                System.err.println("Book ID not exist!");
                cont = true;
            } catch (Exception exception) {
                System.err.println("Book ID already exist!");
                cont = true;
            }
        } while (cont);
        return oID;
    }

    public static String getProductID(String msg, List<Product> pList, int mode) {
        //mode 1 = add
        //mode 2 = search
        //mode 3 = check
        //mode 4 = update
        boolean cont = true;
        do {
            try {
                String pattern = "(P)[0-9][0-9][0-9]";
                System.out.print(msg);
                pID = sc.nextLine();
                if (!productIDExist(pID, pList) && pID.matches(pattern) && (mode == 2 || mode == 3)) {
                    throw new NullPointerException();
                }

                if (productIDExist(pID, pList) && (mode == 3 || mode == 4 || mode == 2)) {
                    return pID;
                } else if (pID.equals("") && mode == 4) {
                    return pID;
                } else {
                    throw new NumberFormatException();
                }

            } catch (NumberFormatException exception) {
                System.err.println("Please enter an Product ID as form (Pxxx) with x is a digit from 0 to 9");
            } catch (NullPointerException exception) {
                System.err.println("Product ID not exist!");
            }

        } while (cont);
        return pID;
    }

    public static int getQuantity(String msg, List<Order> oList, int mode) {
        boolean cont = true;
        int quantity = 0;
        do {
            try {
                System.out.print(msg);
                quantity = Integer.parseInt(sc.nextLine());

                if (quantity < 0) {
                    throw new Exception();
                }
                cont = false;
            } catch (NumberFormatException exception) {
                System.err.println("A quantity must be an integer number!");
            } catch (Exception exception) {
                System.err.println("Please enter a quantity greater than 0!");
            }
        } while (cont);
        return quantity;
    }

//    public static String getDate1() {
//        String day, month, year;
//        System.out.print("Enter day: ");
//        day = sc.nextLine();
//        System.out.println("Enter Month: ");
//        month = sc.nextLine();
//        System.out.println("Enter Year: ");
//        year = sc.nextLine();
//        return String.format("%s/%s/%s", day, month, year);
//    }
//
//    public static String getDate(List<Order> oList, int mode) {
//        //mode 1 = input
//        //mode 2 = update
//        boolean cont = true;
//        do {
//            String pattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
//            if (getDate1().matches(pattern) && mode == 1) {
//                cont = false;
//                return getDate1();
//            } else {
//                getDate1();
//                cont = true;
//            }
//        } while (cont);
//        return getDate1();
//    }
    public static String getDate(String msg, List<Order> oList, int mode) {
        //mode 1 = input
        //mode 2 = update
        boolean cont = true;
        String s = "";
        do {
            try {
                String pattern = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                System.out.print(msg);
                s = sc.nextLine();

                if (s.matches(pattern) && (mode == 1 || mode == 2)) {
                    return s;
                } else if (s.equals("") && mode == 2) {
                    return s;
                } else {
                    throw new Exception();
                }

            } catch (Exception exception) {
                System.err.println("Please enter a date as form (dd/mm/yyyy) witch d, m, y is a digit from 0 to 9!");
                cont = true;
            }
        } while (cont);
        return s;
    }

    public static String getStatus(String msg, List<Order> oList, int mode) {
        boolean cont = true;
        String s = "";
        do {
            try {
                String pattern = "[a-z]";
                System.out.print(msg);
                s = sc.nextLine();
                if (s.equals("t") && (mode == 1 || mode == 2)) {
                    s = "True";
                    break;
                } else if (s.equals("f") && (mode == 1 || mode == 2)) {
                    s = "False";
                } else if (s.equals("") && mode == 1) {
                    s = "False";
                } else if (s.equals("") && mode == 2) {
                    return s;
                } else {
                    throw new Exception();
                }
                cont = false;
            } catch (Exception exception) {
                System.err.println("Please enter t or f (t: True, f: False) to set a order status!");
                cont = true;
            }
        } while (cont);
        return s;
    }

    public static boolean productIDExist(String productID, List<Product> pList) {
        for (Product p : pList) {
            if (p.getProductID().equals(productID)) {
                return true;
            }
        }
        return false;
    }

    public static boolean orderIDExist(String orderID, List<Order> oList) {
        for (Order o : oList) {
            if (o.getOrderID().equals(orderID)) {
                return true;
            }
        }
        return false;
    }

    public static String cName(String id, List<Customer> cList, List<Order> oList) {

        String name;
        for (Customer c : cList) {
            if (c.getCustomerID().equals(id)) {
                name = c.getCustomerName();
                return name;
            }
        }
        return null;
    }
}
