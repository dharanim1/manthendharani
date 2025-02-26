package MovieTicketBooking;

import java.util.Scanner;

public class AdminFunctionality {
	public static void showAdminMenu(){
    Scanner scanner=new Scanner(System.in);
    while(true){
        System.out.println("Admin Menu:");
        System.out.println("1. Create Tables");
        System.out.println("2. Insert Data");
        System.out.println("3. Logout");
        int choice=scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch(choice){
            case 1:
                DatabaseTables.createtables();
                break;
            case 2:
                InsertData.insertMovies();
                InsertData.insertShows();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
}

