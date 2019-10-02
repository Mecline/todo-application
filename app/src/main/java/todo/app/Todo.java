package todo.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Todo extends SQLConnection {
   
    static Connection con = getDbConnection();
	
	public static void printAll() throws SQLException {
		
	System.out.println("Printing start");
		
	ArrayList<String> taskList = new ArrayList<String>();
	Statement stmt = con.createStatement();

	String selectState = "SELECT * FROM List";
    ResultSet rs = stmt.executeQuery(selectState);
    
    while (rs.next()) {
    	
    	  String task = rs.getString("Task");
    	  String status = rs.getString("CurrentStatus");
    	  if (status.equals("0")) {
	    	  //System.out.println(task);
	    	  taskList.add("\n" + task + " - Not Started");
    	  }
    	  else if (status.equals("1")) {
    		  taskList.add("\n" + task + " - In Progress");
    	  }
    	}
    //System.out.println("Complete");
    System.out.println(taskList);
	}

	public static void printUrgent() throws SQLException{
		System.out.println("Printing urgent start");
		
		ArrayList<String> tasksUrgent = new ArrayList<String>();
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM List WHERE PriorityLevel = 'Urgent'");
		
		 while (rs.next()) {
		    	
	    	  String task = rs.getString("Task");
	    	  tasksUrgent.add(task);
		 }
		 System.out.println(tasksUrgent);
	}

	public static void addEntry(String priorityLevel, String task,
			String dateStarted, String currentStatus) throws SQLException{
		
		
		Statement stmt = con.createStatement();
		stmt.executeUpdate("INSERT INTO List VALUES"
				+ "('"+priorityLevel+"','"+task+"','"+dateStarted+"','"+currentStatus+"')");
		
		System.out.println("Added successfully.");
	}
	
	public static void deleteEntry(String task) throws SQLException {
		
		Statement stmt = con.createStatement();
		stmt.executeUpdate("DELETE FROM List WHERE Task = '"+task+"'");
		
		System.out.println("Deleted successfully.");
	}
	
	public static void updateEntry(String task, String dateStarted, String currentStatus) throws SQLException{
		
		Statement stmt = con.createStatement();
		
		
		
		stmt.executeUpdate("UPDATE List SET DateStarted = '"+dateStarted+"',"
							+ " CurrentStatus = '"+currentStatus+"' "
							+ "WHERE Task = '"+task+"'");
		
		System.out.println("Updated successfully.");
	}
	
// end
}


