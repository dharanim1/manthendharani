package MovieTicketBooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 

public class storedProcedure {
	public static void StoredProcedure() throws SQLException {
		Connection conn = DataBaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed");
			return;
		}
 

		String procedure = ""
				+ "	CREATE PROCEDURE GetmovieTitleGenre ("
				+ " IN input_movie_id INT,"
				+ " OUT title_output VARCHAR(30),"
				+ " OUT genre_output VARCHAR(20)"
				+ "	)"
				+ "	BEGIN"
				+ "	  SELECT title, genre INTO title_output, genre_output FROM Movies WHERE movie_id = input_movie_id; "
				+ "	END;";
		Statement smt = conn.createStatement();
		smt.execute(procedure);
		System.out.println("Stored procedure 2 created sucessfully");
	}
	public static void main(String[] args) throws SQLException { 
		StoredProcedure();
	}
}