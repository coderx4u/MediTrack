package main.java.com.airtribe.meditrack.test;

import main.java.com.airtribe.meditrack.constants.Specialization;
import main.java.com.airtribe.meditrack.entity.Appointment;
import main.java.com.airtribe.meditrack.entity.Doctor;
import main.java.com.airtribe.meditrack.entity.Patient;
import main.java.com.airtribe.meditrack.exception.PatientNotFoundException;
import main.java.com.airtribe.meditrack.service.AppointmentService;
import main.java.com.airtribe.meditrack.service.DoctorService;
import main.java.com.airtribe.meditrack.service.PatientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestRunner {

    public static void main(String[] args) throws PatientNotFoundException {
        Scanner sc = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();
        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();
        AppointmentService appointmentService = new AppointmentService();
        while (true) {
            System.out.println(" ");
            System.out.println(" --------- Doctor Categories --------- ");
            System.out.println(" ");
            System.out.println("1. Add Doctor Details");
            System.out.println("2. View All Doctor Details");
            System.out.println("3. View Doctor Details by Specialization");
            System.out.println("4. Update Doctor's Details by Id");
            System.out.println("5. Delete Doctor Details");
            System.out.println(" ");
            System.out.println(" --------- Patient Categories --------- ");
            System.out.println(" ");
            System.out.println("6. Add Patient Details");
            System.out.println("7. View All Patient Details");
            System.out.println("8. View Patient Details by Diseases");
            System.out.println("9. Update Patient Details by Id");
            System.out.println("10. Delete Patient Details by Id");
            System.out.println("11. Book Appointment");
            System.out.println("");
            System.out.println(" ");
            System.out.println("---------------------------------------");
            System.out.println(" ");
            System.out.println("SELECT YOUR CHOICE");
            switch (sc.nextInt()) {
                case 1:
                    sc.nextLine();
                    System.out.println("Enter Doctor's Full Name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter Doctor's EmailId : ");
                    String emailId = sc.next();
                    Specialization specialization = null;
                    while (specialization == null) {
                        System.out.println("Enter Doctor's specialization (CARDIOLOGY, DERMATOLOGY, NEUROLOGY, ORTHOPEDIC, PEDIATRIC) : ");
                        String input = sc.next();
                        try {
                            specialization = Specialization.valueOf(input.toUpperCase());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid specialization. Enter specialization again.");
                        }
                    }
                    System.out.println("Enter Doctor's Mobile Number : ");
                    String mobileNo = sc.next();
                    Doctor doctor = new Doctor(name, emailId, specialization, mobileNo);
                    doctorService.createDoctor(doctor);
                    System.out.println("---------------------------------------");
                    break;
                case 2:
                    System.out.println("Doctor's Details : ");
                    doctorService.showAllDoctorDetails();
                    System.out.println("---------------------------------------");
                    break;
                case 3:
                    Specialization specializations = null;
                    while (specializations == null) {
                        System.out.println("Enter Doctor's specialization (CARDIOLOGY, DERMATOLOGY, NEUROLOGY, ORTHOPEDIC, PEDIATRIC) : ");
                        String input = sc.next();
                        try {
                            specializations = Specialization.valueOf(input.toUpperCase());
                            doctorService.searchBySpecialization(specializations);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid specialization. Enter specialization again.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Update Doctor's Details by Id :- ");
                    System.out.println("Enter the Doctor's Id :- ");
                    long patientid = sc.nextLong();
                    Doctor doctor1 = doctorService.updateDoctorDetailById(patientid, sc);
                    doctorService.doctorsDetail(doctor1);
                    break;
                case 5:
                    System.out.println("Delete Doctor's Details by Id :- ");
                    System.out.println("Enter the Doctor's Id :- ");
                    long docId = sc.nextLong();
                    boolean status = doctorService.deleteDoctorDetailById(docId, sc);
                    if (status) {
                        System.out.println("Doctor with ID " + docId + " has been deleted");
                    } else {
                        System.out.println("Doctor with ID " + docId + " does not exists");
                    }
                    break;
                case 6:
                    sc.nextLine();
                    System.out.println("Enter Patient Full Name : ");
                    String patientName = sc.nextLine();
                    System.out.println("Enter Patient EmailId : ");
                    String patientEmailId = sc.next();
                    System.out.println("Enter Patient Disease : ");
                    sc.nextLine();
                    String patientDisease = sc.nextLine();
                    System.out.println("Enter Mobile Number : ");
                    String patientMobileNo = sc.next();
                    Patient patient = new Patient(patientName, patientDisease, patientEmailId, patientMobileNo);
                    patientService.createPatient(patient);
                    System.out.println("---------------------------------------");
                    break;
                case 7:
                    System.out.println("Patient's Details : ");
                    patientService.showAllPatientDetails();
                    System.out.println("---------------------------------------");
                    break;
                case 8:
                    System.out.println("Enter disease name : ");
                    String disease = sc.next();
                    List<Patient> patientList = patientService.findAllPatientWithDisease(disease);
                    patientService.showAllPatientDetails(patientList);
                    break;
                case 9:
                    System.out.println("Update Patient's Details by Id :- ");
                    System.out.println("Enter the Patient's Id :- ");
                    long patientId = sc.nextLong();
                    Patient patient1 = patientService.updatePatientDetailById(patientId, sc);
                    patientService.patientDetail(patient1);
                    break;
                case 10:
                    System.out.println("Delete Patient's Details by Id :- ");
                    System.out.println("Enter the Patient's Id :- ");
                    long patId = sc.nextLong();
                    boolean patStatus = patientService.deletePatientDetailById(patId);
                    if (patStatus) {
                        System.out.println("Patient's with ID " + patId + " has been deleted");
                    } else {
                        System.out.println("Patient's with ID " + patId + " does not exists");
                    }
                    break;
                case 11:
                    System.out.println("Book Appointment :- ");
                    System.out.println("Enter the Patient's Id :- ");
                    long patientIds = sc.nextLong();
                    Patient patient2 = patientService.searchPatient(patientIds);
                    System.out.println("Enter the Doctor's Id :- ");
                    long doctorIds = sc.nextLong();
                    Doctor doctor2 = doctorService.searchById(doctorIds);
                    Appointment appointment = appointmentService.bookAppointment(doctor2,patient2,"29-02-2026");
                    System.out.println("----------------------------");
                    System.out.println("Appoinment Booked :- " + appointment.getAppointmentStatus());
                    System.out.println("Patient Name - "+ patient2.getName());
                    System.out.println("Date - " + appointment.getDate());
                    System.out.println("Doctor Assigned - " + appointment.getDoctor());
                    System.out.println("-----------------------------");
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
}
