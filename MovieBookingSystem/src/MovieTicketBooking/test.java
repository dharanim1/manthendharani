package MovieTicketBooking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class test {
	private static int movie_id;

	public static void main(String[] args)  {
		Connection conn = DataBaseConnection.getConnection();
	    if (conn == null) {
	        System.out.println("Database connection failed");
	        return;
	    }
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter your movie Id:");
	    int movieId = scanner.nextInt();
	    scanner.close();
	    
	    
		try(CallableStatement csmt = conn.prepareCall("{call test(?,?)}")) {
		    csmt.setInt(1, movie_id);
		    csmt.registerOutParameter(2,  Types.VARCHAR);
		    csmt.execute();
		    String title = csmt.getString(2);
		    System.out.println("Movie Title:"+ title);
		    
		    
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}