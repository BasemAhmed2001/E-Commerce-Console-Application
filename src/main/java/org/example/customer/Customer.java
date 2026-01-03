package org.example.customer;




public class Customer {

    private int id;
    private String fullName;
    private String userName;
    private String password;
    private double balance;


    public Customer(int id, String fullName, String userName, String password, double balance) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.balance = balance;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
