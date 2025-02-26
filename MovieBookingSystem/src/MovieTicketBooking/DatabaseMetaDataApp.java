package MovieTicketBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;
 
public class DatabaseMetaDataApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Connection conn = DataBaseConnection.getConnection())
		{
			java.sql.DatabaseMetaData dbmd = conn.getMetaData();
			System.out.println("Database product name: " + dbmd.getDatabaseProductName());
			System.out.println("Database product version: "+dbmd.getDatabaseProductVersion());
			System.out.println("JDBC driver name: " + dbmd.getDriverName());
			System.out.println("JDBC driver version: " + dbmd.getDriverVersion());
			System.out.println("DB url: " + dbmd.getURL());
			System.out.println("DB username: " + dbmd.getUserName());
			ResultSet rs  = dbmd.getTables("movie_booking", null, "%", new String[] {"TABLE"});
			while(rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}
			ResultSet rs2 = dbmd.getColumns("movie_booking", null, "shows","%");
			while(rs2.next()) {
				System.out.println("Column" +rs2.getString("COLUMN_NAME"));

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		}
 
}