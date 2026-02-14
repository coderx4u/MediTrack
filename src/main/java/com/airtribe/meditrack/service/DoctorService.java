package main.java.com.airtribe.meditrack.service;

import main.java.com.airtribe.meditrack.constants.Availability;
import main.java.com.airtribe.meditrack.constants.Specialization;
import main.java.com.airtribe.meditrack.entity.Doctor;
import main.java.com.airtribe.meditrack.interfaces.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService implements Searchable<Doctor, Doctor> {


    //Filter doctors by specialization,
    //compute average fee,
    //analytics (appointments per doctor) using streams.
    List<Doctor> doctorList = new ArrayList<>();

    public void createDoctor(Doctor doctor) {
        doctor.setAvailability(Availability.AVAILABLE);
        doctorList.add(doctor);
    }

    public void doctorsDetail(Doctor doctor) {
        System.out.println("---------------------------------------");
        System.out.println("Doctor Id : " + doctor.getId());
        System.out.println("Name : " + doctor.getName());
        System.out.println("EmailId : " + doctor.getEmailId());
        System.out.println("Specialization : " + doctor.getSpecialization());
        System.out.println("Mobile No : " + doctor.getMobileNo());
        System.out.println("Availability Status : " + doctor.getAvailability());
        System.out.println("---------------------------------------");
    }

    public void showAllDoctorDetails() {
        for (Doctor doctor : doctorList) {
            doctorsDetail(doctor);
        }
    }

    public void searchBySpecialization(Specialization specialization) {
        if (!doctorList.isEmpty()) {
            for (Doctor doctor : doctorList) {
                if (doctor.getSpecialization().equals(specialization)) {
                    doctorsDetail(doctor);
                }
            }
        }
    }

    public Doctor searchById(long id) {
        return doctorList.stream()
                .filter(d ->
                        d.getId() == id).findFirst().get();
    }

    public Doctor updateDoctorDetailById(long id,Scanner sc) {
        for (Doctor doctor : doctorList) {
            if (doctor.getId() == (id)) {
                int index = doctorList.indexOf(doctor);
                sc.nextLine();
                System.out.println("Enter Doctor's Full Name : ");
                String name = sc.nextLine();
                doctor.setName(name);
                System.out.println("Enter Doctor's EmailId : ");
                String emailId = sc.next();
                doctor.setEmailId(emailId);
                Specialization specialization = null;
                while (specialization == null) {
                    System.out.println("Enter Doctor's specialization (CARDIOLOGY, DERMATOLOGY, NEUROLOGY, ORTHOPEDIC, PEDIATRIC) : ");
                    String input = sc.next();
                    try {
                        specialization = Specialization.valueOf(input.toUpperCase());
                        doctor.setSpecialization(specialization);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid specialization. Enter specialization again.");
                    }
                }
                System.out.println("Enter Doctor's Mobile Number : ");
                String mobileNo = sc.next();
                doctor.setMobileNo(mobileNo);
                System.out.println("---------------------------------------");
                doctorList.set(index,doctor);
                return doctor;
            }
        }
        return null;
    }

    public boolean deleteDoctorDetailById(long id, Scanner sc) {
        for (Doctor doctor : doctorList) {
            if (doctor.getId() == (id)) {
               return doctorList.remove(doctor);
            }
        }
        return false;
    }

    @Override
    public List<Doctor> search(List<Doctor> list, Doctor criteria) {
        return List.of();
    }
}
