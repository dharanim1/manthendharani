package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogin {
	public static void login(String username,String password){
	       Connection conn=DataBaseConnection.getConnection();
	       if(conn==null){
	           System.out.println("Database connection failed.");
	           return;
	       }
	       String query="SELECT * FROM Users WHERE username=? AND password=?";
	       try (PreparedStatement pstmt=conn.prepareStatement(query)){
	           pstmt.setString(1 ,username );
	           pstmt.setString(2 ,password );
	           ResultSet rs=pstmt.executeQuery();
	           if(rs.next()){
	               boolean isAdmin=rs.getBoolean("is_admin");
	               if(isAdmin){
	                   AdminFunctionality.showAdminMenu();
	               }else{
	                   UserFunctionality.showUserMenu(username);
	               }
	           }else{
	               System.out.println("Invalid credentials. Please try again.");
	           }
	       }catch(SQLException e){
	           e.printStackTrace();
	       }
	   }
	    public static void register(String username, String password, boolean isAdmin) {
	        Connection conn = DataBaseConnection.getConnection();
	        if (conn == null) {
	            System.out.println("Database connection failed.");
	            return;
	        }
	        String query = "INSERT INTO Users (username, password, is_admin) VALUES (?, ?, ?)";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setString(1, username);
	            pstmt.setString(2, password);
	            pstmt.setBoolean(3, isAdmin);
	            pstmt.executeUpdate();
	            System.out.println("Registration successful. You can now log in.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


