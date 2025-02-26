package MovieTicketBooking;

import java.util.Scanner;
public class MovieTicketBookingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Show available movies");
            System.out.println("2. Ticket booking");
            System.out.println("3. Confirmation ticket");
            System.out.println("4. exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                	ShowAvailableMovies.showMoviesAndShows();
                    break;
                case 2:
                	TicketBooking.bookTicket(scanner);
                    break;
                case 3:
                	Bookingonformation.confirmationTicket(scanner);
                	break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}