package database;

import java.sql.*;
import java.util.ArrayList;

import model.TeamMember;

// This class is not used anymore, this was for jdbc which is now replaced with hibernate
public class DBConnect{
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	
	
	public DBConnect(){
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database...");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nnmanagement?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Amsterdam","root","root");
			System.out.println("Connected to database");
			
		}catch(Exception ex) {
			System.out.println("Error: " +ex);
		}
	}
	
	public ArrayList<TeamMember> getData() throws SQLException {

		    ArrayList<TeamMember> resultsList = new ArrayList<TeamMember>(); 
		
			String query = "select * from team_member;";
			
			System.out.println("Trying to execute query...");
			
			st=con.createStatement();
			rs = st.executeQuery(query);	
			
			while(rs.next()) {
				resultsList.add(new TeamMember(rs.getInt("id"), rs.getString("first_name"),rs.getString("last_name"),rs.getString("login"),rs.getString("password")));
			}
			
			return resultsList;

	}
	

	
	public void insertData(String firstName, String lastName, String login, String password) {
		
		String query = " insert into team_member (first_name, last_name, login, password)"
		        + " values (?, ?, ?, ?)";
		
		PreparedStatement preparedStmt;
		try {
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.setString (1, firstName);
		    preparedStmt.setString (2, lastName);
		    preparedStmt.setString (3, login);
		    preparedStmt.setString (4, password);
		    
		    preparedStmt.execute();
		    con.close();
		    
		} catch (SQLException e) {
			e.printStackTrace();
		    System.err.println("Insert exception!");
		    System.err.println(e.getMessage());
		}
	}

	public void deleteRecord(TeamMember teamMember) {
		
		String query = "delete from team_member where id = ?";
		
		PreparedStatement preparedStmt;
		
		try {
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.setInt(1, teamMember.getId());
		    
		    preparedStmt.executeUpdate();
		    con.close();
		    
		} catch (SQLException e) {
			e.printStackTrace();
		    System.err.println("Insert exception!");
		    System.err.println(e.getMessage());
		}
		
	}

	public void updateRecord(TeamMember teamMember) {
		
		System.out.println("Update method ivoked with data "+ teamMember.getFirstName() + " "  + teamMember.getLastName() + " "  + teamMember.getLogin());
		
		String query = " update team_member set first_name = ?, last_name = ?, login = ? where id = ?";
		
		PreparedStatement preparedStmt;
		
		try {
			
			preparedStmt = con.prepareStatement(query);
		    preparedStmt.setString (1, teamMember.getFirstName());
		    preparedStmt.setString (2, teamMember.getLastName());
		    preparedStmt.setString (3, teamMember.getLogin());
		    preparedStmt.setInt(4, teamMember.getId());
		    
		    preparedStmt.executeUpdate();
		    con.close();
		    
		} catch (SQLException e) {
			e.printStackTrace();
		    System.err.println("Insert exception!");
		    System.err.println(e.getMessage());
		}
		
	}

}
