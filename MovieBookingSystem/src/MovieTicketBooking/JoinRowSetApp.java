package MovieTicketBooking;

import java.sql.Connection;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;

public class JoinRowSetApp {
public static void main(String[] args) {
        Connection conn = DataBaseConnection.getConnection();
        try {
            CachedRowSet movies = RowSetProvider.newFactory().createCachedRowSet();
            movies.setCommand("SELECT movie_id, title, genre, duration FROM movies");
            movies.execute(conn);
            CachedRowSet shows = RowSetProvider.newFactory().createCachedRowSet();
            shows.setCommand("SELECT movie_id, show_id, show_time, available_seats FROM shows");
            shows.execute(conn);
            conn.close();
            System.out.println("Connection closed");

            JoinRowSet jrs = RowSetProvider.newFactory().createJoinRowSet();
            movies.setMatchColumn("movie_id");
            shows.setMatchColumn("movie_id");

            jrs.addRowSet(movies);
            jrs.addRowSet(shows);

            while (jrs.next()) {
            	 System.out.println("Movie ID: " + jrs.getInt("movie_id"));
            	 System.out.println("Title: " + jrs.getString("title"));
            	 System.out.println("Genre: " + jrs.getString("genre"));
            	 System.out.println("Duration: " + jrs.getInt("duration"));
            	 System.out.println("Show ID: " + jrs.getInt("show_id"));
            	 System.out.println("Show Time: " + jrs.getString("show_time"));	
            	 System.out.println("Seats: " + jrs.getInt("available_seats"));		
                System.out.println("-------------------------------------");	
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


