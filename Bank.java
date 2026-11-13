import java.util.*;
import java.io.*;

public class Bank implements HasMenu {

  Admin admin = new Admin();
  CustomerList customers = new CustomerList();

  public static void main(String[] args){
    new Bank();
  } // end main

  public Bank(){
    this.start();
  } // end constructor

  public String menu(){
    Scanner input = new Scanner(System.in);
    System.out.println();
    System.out.println("Bank Menu");
    System.out.println();
    System.out.println("0: Exit");
    System.out.println("1: Login As Admin");
    System.out.println("2: Login As Customer");
    System.out.println();
    System.out.println("Action: ");
    String response = input.nextLine();

    return reponse;
  } // end menu

  public void start(){
    boolean keepGoing = true;
    while (keepGoing){
      String response = menu();
      if (response.equals("0")){
        keepGoing = false;
      } else if (response.equals("1")){
	System.out.println("Admin Login");
        if (this.admin.login()){
          startAdmin();
	} // end if
      } else if (response.equals("2")){
	System.out.println("Customer Login");
	this.loginAsCustomer();
      } else {
	System.out.println("Please Enter 0, 1, or 2");
      } // end if
    } // end while
  } // end start

  public void startAdmin(){
    boolean keepGoing = true;
    while (keepGoing){
      String response = admin.menu();
      if (response.equals("0")){
        keepGoing = false;
      } else if (response.equals("1")){
	System.out.println("Full Customer Report");
	this.reportAllCustomers();
      } else if (response.equals("2")){
	System.out.println("Add a User");
	this.addUser();
      } else if (response.equals("3")){
	System.out.println("Apply Interest to Savings");
	this.applyInterest();
      } // end if
    } // end while
  } // end startAdmin

  public void loadSampleCustomers(){
    customers.add(new Customer("Alice", "1111"));
    customers.add(new Customer("Bob", "2222"));
    customers.add(new Customer("Cindy", "3333"));
  } // end loadSampleCustomers

  public void reportAllCustomers(){
    for (Customer customer: customers){
      System.out.println(customer.getReport());
    } // end for
  } // endreportAllCustomers

  public void addUser(){
    Scanner input = new Scanner(System.in);
    System.out.print("Username: ");
    String userName = input.nextLine();
    System.out.print("PIN: ");
    String PIN = input.nextLine();
    customers.add(new Customer(userName, PIN));
  } // end addUser

  public void applyInterest(){
    for (Customer customer: customers){
      customer.savings.calcInterest();
    } // end for
  } // end applyInterest

  public void loginAsCustomer(){
    Scanner input = new Scanner(System.in);
    System.out.println("Username: ");
    String userNameIn = input.nextLine();
    System.out.println("PIN: ");
    String PINin = input.nextLine();

    Customer currentCustomer = null;
    for (Customer customer: customers){
      if (customer.login(userNameIn, PINin)){
        currentCustomer = customer;
      } // end if
    } // end for
    
    if (currentCustomer == null){
      System.out.println("Customer not found");
    } else {
      currentCustomer.start();
    } // end if
  } // end loginAsCustomer

} // end Bank

class CustomerList extends ArrayList<Customer> {};
