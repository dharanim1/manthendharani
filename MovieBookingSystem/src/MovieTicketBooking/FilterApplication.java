package MovieTicketBooking;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;
 
public class FilterApplication {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Connection conn = DataBaseConnection.getConnection())
		{
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery("select * from shows");

			FilteredRowSet frs = RowSetProvider.newFactory().createFilteredRowSet();
			frs.populate(rs);
			frs.setFilter(new AvailableShowsSeatsFilter(80));

			while(frs.next()) {
				 System.out.println("Movie ID: " + frs.getInt("movie_id"));
            	 System.out.println("Show ID: " + frs.getInt("show_id"));
            	 System.out.println("Show Time: " + frs.getString("show_time"));	
            	 System.out.println("Seats: " + frs.getInt("available_seats"));		
                System.out.println("-------------------------------------");	

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
 
}
}

