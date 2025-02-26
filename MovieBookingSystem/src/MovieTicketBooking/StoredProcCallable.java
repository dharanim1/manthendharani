package MovieTicketBooking;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 
 
public class StoredProcCallable {
	//create procedure
	//create procedure name(IN movie_id INT, OUT title VARCHAR(25))
	//begin
	//logical
	//end;
	//Statement smt
	//creating -> input movie id -> output title
	public static void storedProcedure(){
		 Connection conn = DataBaseConnection.getConnection();
		    if (conn == null) {
		        System.out.println("Database connection failed");
		        return;
		    }
		   
		try {
			String procedure = "CREATE PROCEDURE test(IN movieid INT, OUT Movietitle VARCHAR(60))"
					+"BEGIN"
					+"  SELECT title into Movietitle FROM movies WHERE movie_id = movieid;"
					+"END;";
			Statement smt = conn.createStatement();
			smt.execute(procedure);
			System.out.println("Stored Procedure created successfully");
		}
			catch(SQLException e) {
				e.printStackTrace();
		}		
	}
}