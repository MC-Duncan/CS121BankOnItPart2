import java.util.*;
import java.io.*;

public class Admin extends User implements HasMenu, Serializable {

  public static void main(String[] args){
    Admin a = new Admin();
    a.login();
  } // end main

  public Admin(){
    this.userName = "admin";
    this.PIN = "0000";
  } // end constructor

  public String menu(){
    Scanner input = new Scanner(System.in);

    System.out.println("Admin Menu");
    System.out.println();
    System.out.println("0: Exit");
    System.out.println("1: Full Customer Report");
    System.out.println("2: Add User");
    System.out.println("3: Apply Interest to Savings Accounts");
    System.out.println();
    System.out.println("Action: ");

    String response = input.nextLine();
    return response;
  } // end menu

  public void start(){
    // will be implemented in Bank
  } // end start

  public String getReport(){
    String report = "Admin Username: " + this.getUserName();
    report += ", Admin PIN: " + this.getPIN();
    return report;
  } // end getReport

} // end admin class
