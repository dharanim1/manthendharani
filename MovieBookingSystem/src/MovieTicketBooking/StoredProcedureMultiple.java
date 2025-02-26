package MovieTicketBooking;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcedureMultiple {
	public static void StoredProcedure() throws SQLException {
		Connection conn = DataBaseConnection.getConnection();
		if(conn==null) {
			System.out.println("Database Connection Failed");
			return;
		}
		String procedure = "CREATE PROCEDURE FetchMultipleRows ("
				+ "	IN input_name VARCHAR(20))"
				+ "	BEGIN"
				+ "	     SELECT * FROM Bookings "
				+ "	     Where user_name = input_name;"
				+ "	END;";
		Statement smt = conn.createStatement();
		smt.execute(procedure);
		System.out.println("Stored Procedure 3 created");
	}
	public static void main(String[] args) throws SQLException { 
		StoredProcedure();
	}

}