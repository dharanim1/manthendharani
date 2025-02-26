package MovieTicketBooking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;
public class Test3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DataBaseConnection.getConnection();
		if(conn == null) {
			System.out.println("Database Connection Failed");
			return;
		}
		try {
			Scanner sc= new Scanner(System.in);
			CallableStatement csmt = conn.prepareCall("{call FetchMultipleRows(?)}");
			System.out.println("Enter your name:");
			String name_input = sc.nextLine();
			csmt.setString(1, name_input);
			ResultSet rs = csmt.executeQuery();
			while(rs.next()) {
				int bookingID = rs.getInt("booking_id");
				int showId = rs.getInt("show_id");
				int seatsBooked = rs.getInt("seats_booked");
				Timestamp showdate = rs.getTimestamp("booking_date");
		        System.out.println(" Booking ID: "+bookingID);
		        System.out.println(" Show ID : "+showId);
		        System.out.println(" Seats Booked :"+seatsBooked);
		        System.out.println(" Show Date : "+showdate);
				System.out.println(" ");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
