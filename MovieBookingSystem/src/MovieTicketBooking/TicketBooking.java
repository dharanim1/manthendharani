package MovieTicketBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class TicketBooking {
    public static void bookTicket(Scanner scanner) {
        Connection conn = DataBaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed");
            return;
        }
        try {
            // Step 1: Get user name
            System.out.println("Enter your name:");
            String userName = scanner.next();
            // Step 2: Show available movies and shows
            ShowAvailableMovies.showMoviesAndShows();
            // Step 3: Ask user to choose show ID
            System.out.println("Enter Show ID:");
            int showId = scanner.nextInt();
            // Step 4: Check available seats
            String checkQuery = "SELECT available_seats FROM Shows WHERE show_id = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                checkStmt.setInt(1, showId);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    int availableSeats = rs.getInt("available_seats");
                    // Step 5: Ask user how many seats to book
                    System.out.println("Enter number of seats to book:");
                    int seatsToBook = scanner.nextInt();
                    if (availableSeats >= seatsToBook) {
                        // Step 6: Insert into booking table
                        String bookQuery = "INSERT INTO Bookings (show_id, user_name, seats_booked) VALUES (?, ?, ?)";
                        try (PreparedStatement bookStmt = conn.prepareStatement(bookQuery)) {
                            bookStmt.setInt(1, showId);
                            bookStmt.setString(2, userName);
                            bookStmt.setInt(3, seatsToBook);
                            bookStmt.executeUpdate();
                            // Step 7: Update shows table
                            String updateQuery = "UPDATE Shows SET available_seats = available_seats - ? WHERE show_id = ?";
                            try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                                updateStmt.setInt(1, seatsToBook);
                                updateStmt.setInt(2, showId);
                                updateStmt.executeUpdate();
                            }
                            System.out.println("Booking successful! Seats booked: " + seatsToBook);
                        }
                    } else {
                        System.out.println("Not enough available seats.");
                    }
                } else {
                    System.out.println("Show not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
