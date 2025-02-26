package MovieTicketBooking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
public class InsertData {
	//two methods
	//insert movies data
	public static void insertMovies()
	{
		Connection conn = DataBaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return;
	}
        String insertMovieSQL="insert into Movies(title,genre,duration) Values(?,?,?)";
//        PreparedStatement psmt = conn.prepareStatement(insertMovieSQL);
       try(PreparedStatement psmt = conn.prepareStatement(insertMovieSQL) )
        {
    	   //movie1
        	psmt.setString(1,"rose");
        	psmt.setString(2,"rom-com");
        	psmt.setInt(3, 150);
        	psmt.executeUpdate();
        	//movie2
        	psmt.setString(1,"Fighter");
        	psmt.setString(2,"Action");
        	psmt.setInt(3, 150);
        	psmt.executeUpdate();
        	//movie3
        	psmt.setString(1,"ram");
        	psmt.setString(2,"Action");
        	psmt.setInt(3, 150);
        	psmt.executeUpdate();
        	System.out.println("movies data inserted successfully");
        }
       catch(SQLException e)
       {
    	 e.printStackTrace();
       }
	}

	//insert shows
	public static void insertShows()
	{
		Connection conn = DataBaseConnection.getConnection();
        if (conn == null) {
            System.out.println("Database connection failed.");
            return;
	}
        String insertShowsSQL = "INSERT INTO Shows (movie_id, show_time, available_seats) VALUES (?, ?, ?)";
try(PreparedStatement psmt =conn.prepareStatement(insertShowsSQL))
{
	//one show
	psmt.setInt(1, 1);
	psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025, 2,15,18,30)));
	psmt.setInt(3, 100);
	psmt.executeUpdate();
	psmt.setInt(2, 1);
	psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025, 2,15,18,30)));
	psmt.setInt(3, 100);
	psmt.executeUpdate();
	psmt.setInt(1, 4);
	psmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.of(2025, 2,15,18,30)));
	psmt.setInt(3, 100);
	psmt.executeUpdate();
	System.out.println("shows data inserted successfully");
	
}
catch(SQLException e)
{
	 e.printStackTrace();
}
}
	public static void main(String[] args)
	{
		insertMovies();
		insertShows();
	}
}

