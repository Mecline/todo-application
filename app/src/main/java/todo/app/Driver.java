package todo.app;

import java.sql.SQLException;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) throws SQLException {
		System.out.println("Please start with the application."
				+ "\nFor all available commands, type HELP");
		
	        Scanner in = new Scanner(System.in); 
	        String s = in.nextLine();
	        
	        while (s != "") {
	        switch(s.toLowerCase()) {
	        case "help" :
	        	System.out.println("Available commands are below:"
	        			+ "\nPRINT: Print out tasks that need to be done."
	        			+ "\nURGENT: Print out tasks on high priority."
	        			+ "\nUPDATE: Will update a record."
	        			+ "\nADD: Will add a new task to complete."
	        			+ "\nDELETE: Will delete a record from the table."
	        			+ "\nEXIT: Exit the application");
	        	s = in.nextLine();
	        	break;
	        
	        case "update" :
	        	System.out.println("Enter task to be updated");
	        	String taskUpdate = in.nextLine();
	        	
	        	System.out.println("Enter date started with format mm/dd/yyyy");
	        	String dateUpdate = in.nextLine();
	        	
	        	System.out.println("Current status: 0 - Not started, 1 - In progress, 2 - Complete");
	        	String statusUpdate = in.nextLine();
	        	
	        	Todo.updateEntry(taskUpdate, dateUpdate, statusUpdate);
	        	s = "";
	        	break;
	        	
	        case "print" :
	        	Todo.printAll();
	        	s = in.nextLine();
	        	break;
	        
	        case "urgent" :
	        	Todo.printUrgent();
	        	s = in.nextLine();
	        	break;
	        
	        case "add" :
	        	System.out.println("Enter priority level: Urgent, Moderate, Low");
	        	String priorityLevel = in.nextLine();
	        	
	        	System.out.println("Enter task description");
	        	String task = in.nextLine();
	        	
	        	System.out.println("Enter date started with format mm/dd/yyyy");
	        	String dateStarted = in.nextLine();
	        	
	        	System.out.println("Current status: 0 - Not started, 1 - In progress, 2 - Complete");
	        	String currentStatus = in.nextLine();
	        	
	        	if (task.equals("")) {System.out.println("Task cannot be empty"); break;}
	        	
	        	Todo.addEntry(priorityLevel, task, dateStarted, currentStatus);
	        	s = in.nextLine();
	        	break;
	        	
	        case "delete" :

	        	System.out.println("Enter task description");
	        	String taskDelete = in.nextLine();
	        	
	        	Todo.deleteEntry(taskDelete);
	        	s = in.nextLine();
	        	break;
	        	
	        case "exit" :
	        	System.out.println("Quitting application");
	        	s = "";
	        	break;
	        	
	        default: 
	        	System.out.println("Command not found, retry or type EXIT to close.");
	        	s = in.nextLine();
	        	break;
	        	}
	        }
	    System.out.println("Closed application.");    
	}
}

