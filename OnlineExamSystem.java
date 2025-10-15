package onlineexam.java;
import java.util.*;
	public class Onlineexam {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Welcome to the Online Examination System!");
	        System.out.println("Developed by Abdhul");
	        while (true) {
	            System.out.println("\nMain Menu:");
	            System.out.println("1. Register as a Student");
	            System.out.println("2. Register as an Administrator");
	            System.out.println("3. Login");
	            System.out.println("4. Exit");
	            System.out.print("Please enter your choice: ");
	            int choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.println("Student Registration Selected.");
	                    
	                    break;
	                case 2:
	                    System.out.println("Administrator Registration Selected.");
	                    
	                    break;
	                case 3:
	                    System.out.println("Login Selected.");
	                    
	                    break;
	                case 4:
	                    System.out.println("Exiting the system. Thank you!");
	                    scanner.close();
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
	            }
	        }
	    }
	}




