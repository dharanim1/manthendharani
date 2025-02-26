package HMS;

public class Appointment {
	private int id;
	private int patient_id;
	private int doctor_id;
	private String appointment_date;
	private String reason;
	public Appointment(int id, int patient_id, int doctor_id, String appointment_date, String reason) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.appointment_date = appointment_date;
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", patient_id=" + patient_id + ", doctor_id=" + doctor_id
				+ ", appointment_date=" + appointment_date + ", reason=" + reason + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getAppointment_date() {
		return appointment_date;
	}
	public void setAppointment_date(String appointment_date) {
		this.appointment_date = appointment_date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
 
 

}