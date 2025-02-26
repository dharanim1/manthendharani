package HMS;

import java.sql.SQLException;

import java.util.List;

import java.util.Scanner;

public class HMSApplication {

    private static final Scanner scanner = new Scanner(System.in);

    private static final PatientDAO patientDAO = new PatientDAO();

    private static final DoctorDAO doctorDAO = new DoctorDAO();

    private static final AppointmentDAO appointmentDAO = new AppointmentDAO();

    private static final StaffDAO StaffDAO = new StaffDAO();

    public static void main(String[] args) {

        while (true) {
 
            System.out.println("Choose an option:");

            System.out.println("1. Manage Patients");

            System.out.println("2. Manage Doctors");

            System.out.println("3. Manage Appointments");

            System.out.println("4. Manage Staff");

            System.out.println("5. Exit");

            int choice = scanner.nextInt();
 
            scanner.nextLine();

            switch (choice) {
 
                case 1:

                    managePatients();

                    break;
 
                case 2:

                    manageDoctors();

                    break;
 
                case 3:

                    manageAppointments();

                    break;
 
                case 4:

                    manageStaff();

                    break;
 
                case 5:

                    System.exit(0);

                default:
 
                    System.out.println("Invalid choice. Please try again.");
 
            }
 
        }
 
    }

    public static void managePatients() {

        while (true) {

            System.out.println("Manage Patients:");

            System.out.println("1. Add Patient");

            System.out.println("2. View All Patients");

            System.out.println("3. Update Patient");

            System.out.println("4. Delete Patient");

            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
 
            scanner.nextLine(); 

            try {
 
                switch (choice) {
 
                    case 1:

                        addPatient();

                        break;

                    case 2:

                        viewAllPatients();

                        break;
 
                    case 3:

                        updatePatient();

                        break;
 
                    case 4:

                        deletePatient();

                        break;
 
                    case 5:

                        return; 

                    default:
 
                        System.out.println("Invalid choice. Please try again.");
 
                }
 
            } catch (SQLException e) {

                e.printStackTrace();
 
            }
 
        }
 
    }

    private static void addPatient() throws SQLException {
 
        System.out.println("Enter first name:");

        String fname = scanner.nextLine();

        System.out.println("Enter last name:");

        String lname = scanner.nextLine();

        System.out.println("Enter age:");

        int age = scanner.nextInt();

        scanner.nextLine(); 

        System.out.println("Enter gender:");
 
        String gender = scanner.nextLine();
 
        System.out.println("Enter contact number:");

        String contactNumber = scanner.nextLine();

        Patient patient = new Patient(0, fname, lname, age, gender, contactNumber);

        patientDAO.addPatient(patient);

        System.out.println("Patient added successfully.");
 
    }

    private static void viewAllPatients() throws SQLException {
 
        List<Patient> patients = patientDAO.getAllPatients();
 
        for (Patient patient : patients) {
 
            System.out.println(patient);
 
        }
 
    }

    private static void updatePatient() throws SQLException {
 
        System.out.println("Enter patient ID to update:");
 
        int id = scanner.nextInt();
 
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new first name:");
 
        String fname = scanner.nextLine();
 
        System.out.println("Enter new last name:");
 
        String lname = scanner.nextLine();
 
        System.out.println("Enter new age:");
 
        int age = scanner.nextInt();
 
        scanner.nextLine(); // Consume newline
 
        System.out.println("Enter new gender:");
 
        String gender = scanner.nextLine();
 
        System.out.println("Enter new contact number:");
 
        String contactNumber = scanner.nextLine();

        Patient patient = new Patient(id, fname, lname, age, gender, contactNumber);
 
        patientDAO.updatePatient(patient);
 
        System.out.println("Patient updated successfully.");
 
    }
 


  private static void deletePatient() throws SQLException {
 
        System.out.println("Enter patient ID to delete:");
 
        int id = scanner.nextInt();

        patientDAO.deletePatient(id);
 
        System.out.println("Patient deleted successfully.");
 
    }

    public static void manageDoctors() {
 
        while (true) {
 
            System.out.println("Manage Doctors:");
 
            System.out.println("1. Add Doctor");
 
            System.out.println("2. View All Doctors");
 
            System.out.println("3. Update Doctor");
 
            System.out.println("4. Delete Doctor");
 
     
 
   System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
 
            scanner.nextLine(); // Consume newline

            try {
 
                switch (choice) {
 
                    case 1:
 
                        addDoctor();
 
                        break;
 
                    case 2:
 
                        viewAllDoctors();
 
                        break;
 
                    case 3:
 
                        updateDoctor();
 
                        break;
 
                    case 4:
 
                        deleteDoctor();
 
                        break;
 
                    case 5:
 
                        return; // Exit the method to go back to the main menu
 
                    default:
 
                        System.out.println("Invalid choice. Please try again.");
 
                }
 
            } catch (SQLException e) {
 
                e.printStackTrace();
 
            }
 
        }
 
    }

    private static void addDoctor() throws SQLException {
 
        System.out.println("Enter name:");
 
        String name = scanner.nextLine();
 
        System.out.println("Enter specialty:");
 
        String specialty = scanner.nextLine();
 
        System.out.println("Enter contact:");
 
        String contact = scanner.nextLine();

        Doctor doctor = new Doctor(0,name, specialty, contact);
 
        doctorDAO.addDoctor(doctor);
 
        System.out.println("Doctor added successfully.");
 
    }

    private static void viewAllDoctors() throws SQLException {
 
        List<Doctor> doctors = doctorDAO.getAllDoctors();
 
        for (Doctor doctor : doctors) {
 
            System.out.println(doctor);
 
        }
 
    }

    private static void updateDoctor() throws SQLException {
 
        System.out.println("Enter doctor ID to update:");
 
        int id = scanner.nextInt();
 
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new name:");
 
        String name = scanner.nextLine();
 
        System.out.println("Enter new specialty:");
 
        String specialty = scanner.nextLine();
 
        System.out.println("Enter new contact:");
 
        String contact = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, specialty, contact);
 
        doctorDAO.updateDoctor(doctor);
 
        System.out.println("Doctor updated successfully.");
 
    }

    private static void deleteDoctor() throws SQLException {
 
        System.out.println("Enter doctor ID to delete:");
 
        int id = scanner.nextInt();

        doctorDAO.deleteDoctor(id);
 
        System.out.println("Doctor deleted successfully.");
 
    }
 
    public static void manageAppointments() {
 
        while (true) {
 
            System.out.println("Manage Appointments:");
 
            System.out.println("1. Book an Appointment");
 
            System.out.println("2. View All Appointments");
 
            System.out.println("3. Cancel an Appointment");
 
            System.out.println("4. Back to Main Menu");

            int choice = scanner.nextInt();
 
            scanner.nextLine(); // Consume newline

            try {
 
                switch (choice) {
 
                    case 1:
 
                        bookAppointment();
 
                        break;
 
                    case 2:
 
                        viewAllAppointments();
 
                        break;
 
                    case 3:
 
                        cancelAppointment();
 
                        break;
 
                    case 4:
 
                        return; // Exit the method to go back to the main menu
 
                    default:
 
                        System.out.println("Invalid choice. Please try again.");
 
                }
 
            } catch (SQLException e) {
 
                e.printStackTrace();
 
            }
 
        }
 
    }

    private static void bookAppointment() throws SQLException {
 
        System.out.println("Enter patient ID:");
 
        int patientId = scanner.nextInt();
 
        System.out.println("Enter doctor ID:");
 
        int doctorId = scanner.nextInt();
 
        scanner.nextLine(); // Consume newline
 
        System.out.println("Enter appointment date (YYYY-MM-DD):");
 
        String appointmentDate = scanner.nextLine();
 
        System.out.println("Enter reason for appointment:");
 
        String reason = scanner.nextLine();

        Appointment appointment = new Appointment(0, patientId, doctorId, appointmentDate, reason);
 
        appointmentDAO.bookAppointment(appointment);
 
        System.out.println("Appointment booked successfully.");
 
    }

    private static void viewAllAppointments() throws SQLException {
 
        List<Appointment> appointments = AppointmentDAO.getAllAppointments();
 
        for (Appointment appointment : appointments) {
 
            System.out.println(appointment);
 
        }
 
    }

    private static void cancelAppointment() throws SQLException {
 
        System.out.println("Enter appointment ID to cancel:");
 
        int id = scanner.nextInt();

        appointmentDAO.cancelAppointment(id);
 
        System.out.println("Appointment canceled successfully.");
 
    }

    public static void manageStaff() {
 
        while (true) {
 
            System.out.println("Manage Staff:");
 
            System.out.println("1. Add Staff");
 
            System.out.println("2. View All Staff");
 
            System.out.println("3. Update Staff");
 
            System.out.println("4. Delete Staff");
 
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
 
            scanner.nextLine(); // Consume newline

            try {
 
                switch (choice) {
 
                    case 1:
 
                        addStaff();
 
                        break;
 
                    case 2:
 
                        viewAllStaff();
 
                        break;
 
                    case 3:
 
                        updateStaff();
 
                        break;
 
                    case 4:
 
                        deleteStaff();
 
                        break;
 
                    case 5:
 
                        return; // Exit the method to go back to the main menu
 
                    default:
 
                        System.out.println("Invalid choice. Please try again.");
 
                }
 
            } catch (SQLException e) {
 
                e.printStackTrace();
 
            }
 
        }
 
    }

    private static void addStaff() throws SQLException {
 
        System.out.println("Enter name:");
 
        String name = scanner.nextLine();
 
        System.out.println("Enter role:");
 
        String role = scanner.nextLine();

        System.out.println("Enter contact number:");

        String contactNumber = scanner.nextLine();

        Staff staff = new Staff(0, name, role, contactNumber);

        StaffDAO.addStaff(staff);

        System.out.println("Staff added successfully.");
 
    }

    private static void viewAllStaff() throws SQLException {

        List<Staff> staffList = StaffDAO.getAllStaff();

        for (Staff Staff : staffList) {

            System.out.println(Staff);
 
        }
 
    }

    private static void updateStaff() throws SQLException {

        System.out.println("Enter staff ID to update:");

        int id = scanner.nextInt();
 
        scanner.nextLine();

        System.out.println("Enter new name:");

        String name = scanner.nextLine();

        System.out.println("Enter new role:");

        String role = scanner.nextLine();

        System.out.println("Enter new contact number:");

        String contactNumber = scanner.nextLine();

        Staff staff = new Staff(id, name, role, contactNumber);

        StaffDAO.updateStaff(staff);

        System.out.println("Staff updated successfully.");
 
    }

    private static void deleteStaff() throws SQLException {

        System.out.println("Enter staff ID to delete:");

        int id = scanner.nextInt();

        StaffDAO.deleteStaff(id);

        System.out.println("Staff deleted successfully.");
 
    }
 
}
 