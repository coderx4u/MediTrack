package main.java.com.airtribe.meditrack.entity;

import main.java.com.airtribe.meditrack.constants.Availability;
import main.java.com.airtribe.meditrack.constants.Specialization;
import main.java.com.airtribe.meditrack.util.IdGenerator;

public class Doctor extends Person {

    private long id;
    private Specialization specialization;
    private Availability availability;

    public Doctor(String name,String emailId,Specialization specialization,String mobileNo){
        super(name,emailId,mobileNo);
        this.id = IdGenerator.generateId("DOC-");
        this.specialization = specialization;
        this.availability = availability;
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + super.getName() + '\'' +
                ", specialization='" + this.specialization + '\'' +
                ", emailId='" + super.getEmailId() + '\'' +
                ", mobileNo='" + super.getMobileNo() + '\'' +
                '}';
    }
}
