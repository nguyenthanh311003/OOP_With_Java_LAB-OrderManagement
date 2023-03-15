
package object;


public class Customer {
    private String customerID;
    private String customerName;
    private String customerAddress;
    private String phone;

    public Customer() {
    }

    public Customer(String customerID, String customerName, String customerAddress, String phone) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.phone = phone;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    @Override
//    public String toString() {
//        return String.format("%-4s        | %-30s | %-30s  | %-12s\n", customerID, customerName, customerAddress, phone);
//    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s\n", customerID, customerName, customerAddress, phone);
    }
    
    
}
