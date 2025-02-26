package movieticketbooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DatabaseTables2 {
 
	public static void createtables2() {
		Connection conn = DatabaseConnection.getConnection();
		if ( conn == null) {
			System.out.println("Database Connection Failed.");
		return;
		}
		try {
			Statement smt = conn.createStatement();
		// statement use = general purpose access to the db
			// execute object - used for general purpose access to the db
		// create table
			//execute()- executeUpdate(), ResultSet()
			String createMoviesTable = "CREATE TABLE IF NOT EXISTS Movies ("
                    + "movie_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "title VARCHAR(60) NOT NULL, "
                    + "genre VARCHAR(20), "
                    + "duration INT NOT NULL)";
            smt.executeUpdate(createMoviesTable);
            System.out.println("Movies table created.");
            // Shows table
            String createShowsTable = "CREATE TABLE IF NOT EXISTS Shows ("
                    + "show_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "movie_id INT, "
                    + "show_time DATETIME NOT NULL, "
                    + "available_seats INT NOT NULL, "
                    + "FOREIGN KEY (movie_id) REFERENCES Movies(movie_id))";
            smt.executeUpdate(createShowsTable);
            System.out.println("Shows table created.");
            // Bookings table
            String createBookingsTable = "CREATE TABLE IF NOT EXISTS Bookings ("
                    + "booking_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "user_name VARCHAR(50) NOT NULL, "
                    + "show_id INT NOT NULL, "
                    + "seats_booked INT NOT NULL, "
                    + "booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                    + "FOREIGN KEY (show_id) REFERENCES Shows(show_id))";
            smt.executeUpdate(createBookingsTable);
            System.out.println("Bookings table created.");

			smt.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[ ] args) {
		createtables2();
	}
}
