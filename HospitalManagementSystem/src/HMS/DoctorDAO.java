package HMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DoctorDAO {
    public void addDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO Doctor (name, speciality, contact) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setString(1, doctor.getName());
            psmt.setString(2, doctor.getSpeciality());
            psmt.setString(3, doctor.getContact());
            psmt.executeUpdate();
        }
    }
    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM Doctor";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Doctor doctor = new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("speciality"),
                        rs.getString("contact")
                );
                doctors.add(doctor);
            }
        }
        return doctors;
    }
    public void updateDoctor(Doctor doctor) throws SQLException {
        String query = "UPDATE Doctor SET name = ?, speciality = ?, contact = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setString(1, doctor.getName());
            psmt.setString(2, doctor.getSpeciality());
            psmt.setString(3, doctor.getContact());
            psmt.setInt(4, doctor.getId());
            psmt.executeUpdate();
        }
    }
    public void deleteDoctor(int id) throws SQLException {
        String query = "DELETE FROM Doctor WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(query)) {
            psmt.setInt(1, id);
            psmt.executeUpdate();
        }
    }
}