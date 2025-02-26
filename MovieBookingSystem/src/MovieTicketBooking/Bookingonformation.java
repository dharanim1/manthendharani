package MovieTicketBooking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Bookingonformation {
	
public static void confirmationTicket(Scanner scanner) {
    Connection conn = DataBaseConnection.getConnection();
    if (conn == null) {
        System.out.println("Database connection failed");
        return;
    }
    try {
        // Step 1: Get user name
        System.out.println("Enter your name:");
        String userName = scanner.next();
        //Step 2:Fetch booking details
        String query ="Select Bookings.booking_id As Booking_Id, Movies.title As MovieName,"+
                       "Shows.Show_time, Bookings.seats_booked"+
                      "From Bookings"+
        		      "Join shows On Bookings.show_id = shows.booking_id "+
                      "Join movies On shows.movie_id = movies.booking_id"+
        		      "Where Bookings.username = ?;";
    try(PreparedStatement stmt = conn.prepareStatement(query)){
    	stmt.setString(1,  userName);
    	ResultSet rs = stmt.executeQuery();
    	boolean hasBookings = false;
    	System.out.println("Your Bookings:");
    	System.out.println("Booking Id | Title | Show_time | seats_booked");
    	while(rs.next()) {
    		hasBookings = true;
    		int booking_id = rs.getInt("booking_id");
    		String Title = rs.getString("title");
    		String Show_time = rs.getString("Show_time");
    		int seats_booked = rs.getInt("seats_booked");
    		System.out.println(booking_id+ "|"+Title+"|"+Show_time+"|"+seats_booked);
    		
    	}
    	if(!hasBookings) {
    		System.out.println("No Bookings found for"+ userName);
    	}
    	
    }
    } catch(SQLException e) {
    	e.printStackTrace();
    }
	//ask username use of preparedStatement
	//relating all three tables - use th joines
	//Booking> Username, Booking Id
	//Movies> Movie Name
	//shows> showtime,Seats booked

}
}