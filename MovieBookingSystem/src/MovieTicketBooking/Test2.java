package MovieTicketBooking;

import java.sql.CallableStatement;

import java.sql.Connection;

import java.sql.SQLException;

import java.sql.Types;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Connection conn = DataBaseConnection.getConnection();

		if(conn == null) {

			System.out.println("Database Connection Failed");

			return;

		}

		try {

			Scanner sc= new Scanner(System.in);

			CallableStatement csmt = conn.prepareCall("{call GetmovieTitleGenre(?, ?, ?)}");

			System.out.println("Enter movie ID:");

			int movie_id_input = sc.nextInt();

			csmt.setInt(1, movie_id_input);

			csmt.registerOutParameter(2, Types.VARCHAR);

			csmt.execute();

			String title = csmt.getString(2);

			System.out.println("Movie Title : "+title);

			String genre = csmt.getString(3);

			System.out.println("Movie Genre : "+genre);

			csmt.close();

			sc.close();

		}

		catch(SQLException e) {

			e.printStackTrace();

		}

	}

}
 
 