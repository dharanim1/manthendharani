package MovieTicketBooking;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
 
public class RowSetApplication {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DataBaseConnection.getConnection();
			JdbcRowSet rowSet =RowSetProvider.newFactory().createJdbcRowSet();
			rowSet.setUrl("jdbc:mysql://localhost:3306/movies_bookings2");
			rowSet.setUsername("root");
			rowSet.setPassword("Genpact@123456789");

			rowSet.setCommand("Select * from movies");
			rowSet.execute();
			while(rowSet.next()) {
				System.out.println("ID: "+rowSet.getInt("movie_id"));
			}
			while(rowSet.previous()) {
				System.out.println("ID: "+rowSet.getInt("movie_id"));
			}

			rowSet.close();
			System.out.println("------------------------------------------------");
			////////////////////////////////////////////////////////////
			CachedRowSet ct = RowSetProvider.newFactory().createCachedRowSet();
			ct.setUrl("jdbc:mysql://localhost:3306/movie_booking");
			ct.setUsername("root");
			ct.setPassword("Genpact@123456789");
			ct.setCommand("select * from movies");
			ct.execute();

			while(ct.next()) {
				if(ct.getInt("movie_id")==3) {
					ct.updateString("title", "Fighter3");
					ct.updateRow();
				}
			}
			 conn = DataBaseConnection.getConnection();
			 conn.setAutoCommit(false);
			ct.acceptChanges(conn);
			conn.close();
			while(ct.next()) {
				System.out.println("ID: "+ct.getInt("movie_id"));
				System.out.println("title: "+ct.getString("title"));
			}

 
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
 
}