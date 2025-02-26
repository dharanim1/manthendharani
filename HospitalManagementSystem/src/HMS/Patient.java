package HMS;

public class Patient {
    private int id;
    private String fName;
    private String lName;
    private int age;
    private String gender;
    private String contactNumber;

    // Constructor overloading
    public Patient(String fName, String lName, int age, String gender, String contactNumber) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }

    public Patient(int id, String fName, String lName, int age, String gender, String contactNumber) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Patient [id=" + id + ", fName=" + fName + ", lName=" + lName + ", age=" + age + ", gender=" + gender
                + ", contactNumber=" + contactNumber + "]";
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
