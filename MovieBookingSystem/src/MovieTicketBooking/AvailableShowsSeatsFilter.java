package MovieTicketBooking;

import java.sql.SQLException;

import javax.sql.RowSet;
 
public class AvailableShowsSeatsFilter implements javax.sql.rowset.Predicate{
	private int minSeats;
 
	public AvailableShowsSeatsFilter(int minSeats) {
		this.minSeats = minSeats;
	}
 
 
	@Override
	public boolean evaluate(RowSet rs) {
		try {
			int availableSeats = rs.getInt("available_seats");
			return availableSeats >=minSeats;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
 
	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
 
	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
 
}