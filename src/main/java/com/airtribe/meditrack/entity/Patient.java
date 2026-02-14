package main.java.com.airtribe.meditrack.entity;

import main.java.com.airtribe.meditrack.util.IdGenerator;

public class Patient extends Person {

    private long id;
    private String disease;

    public Patient(String name, String disease, String emailId, String mobileNo) {
        super(name, emailId, mobileNo);
        this.id = IdGenerator.generateId("PAT-");
        this.disease = disease;
    }

    public long getId() {
        return id;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Patient {" +
                "name='" + super.getName() + '\'' +
                ", disease='" + this.disease + '\'' +
                ", emailId='" + super.getEmailId() + '\'' +
                ", mobileNo='" + super.getMobileNo() + '\'' +
                '}';
    }

}
