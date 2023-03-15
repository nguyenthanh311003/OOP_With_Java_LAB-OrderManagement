
package object;


public class Order {
    private String orderID;
    private String orderOfCustomerID;
    private String orderOfProductID;
    private int orderQuantity;
    private String orderDate;
    private String status;

    public Order() {
    }

    public Order(String orderID, String orderOfCustomerID, String orderOfProductID, int orderQuantity, String orderDate, String status) {
        this.orderID = orderID;
        this.orderOfCustomerID = orderOfCustomerID;
        this.orderOfProductID = orderOfProductID;
        this.orderQuantity = orderQuantity;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderOfCustomerID() {
        return orderOfCustomerID;
    }

    public void setOrderOfCustomerID(String orderOfCustomerID) {
        this.orderOfCustomerID = orderOfCustomerID;
    }

    public String getOrderOfProductID() {
        return orderOfProductID;
    }

    public void setOrderOfProductID(String orderOfProductID) {
        this.orderOfProductID = orderOfProductID;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%d,%s,%s\n", orderID, orderOfCustomerID, orderOfProductID, orderQuantity, orderDate, status);
    }

    
    
    
}
