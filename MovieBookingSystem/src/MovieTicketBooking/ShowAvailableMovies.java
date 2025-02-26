package MovieTicketBooking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ShowAvailableMovies {
    public static void showMoviesAndShows() {
        Connection conn = DataBaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed");
            return;
        }
        String query = "SELECT m.movie_id, s.show_id, m.title, s.show_time, s.available_seats "
                     + "FROM Movies m "
                     + "JOIN Shows s ON m.movie_id = s.movie_id";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Available Movies and Shows:");
            while (rs.next()) {
                int movieId = rs.getInt("movie_id");
                int showId = rs.getInt("show_id");
                String title = rs.getString("title");
                String showTime = rs.getTimestamp("show_time").toString();
                int availableSeats = rs.getInt("available_seats");
                System.out.println("Movie ID: " + movieId + ", Show ID: " + showId + ", Title: " + title 
                                   + ", Show Time: " + showTime + ", Available Seats: " + availableSeats);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}