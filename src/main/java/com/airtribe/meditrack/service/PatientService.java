package main.java.com.airtribe.meditrack.service;

import main.java.com.airtribe.meditrack.entity.Patient;
import main.java.com.airtribe.meditrack.exception.PatientNotFoundException;
import main.java.com.airtribe.meditrack.interfaces.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatientService implements Searchable<Patient, Patient> {

    List<Patient> patientList = new ArrayList<>();

    public void createPatient(Patient patient) {
        patientList.add(patient);
    }

    public Patient searchPatient(long id) throws PatientNotFoundException {
        for (Patient patient : patientList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        throw new PatientNotFoundException("Patient with the id " + id + " Not Found");
    }


    public Patient searchPatient(String name) throws PatientNotFoundException {
        for (Patient patient : patientList) {
            if (patient.getName().equalsIgnoreCase(name)) {
                return patient;
            }
        }
        throw new PatientNotFoundException("Patient with the name " + name + " Not Found");
    }

    public Patient searchPatient(int age) throws PatientNotFoundException {
        for (Patient patient : patientList) {
            if (patient.getAge() == age) {
                return patient;
            }
        }
        throw new PatientNotFoundException("Patient with the age " + age + " Not Found");
    }

    @Override
    public List<Patient> search(List<Patient> list, Patient criteria) {
        return list.stream().filter(d -> criteria.getId() == 0|| d.getId() == criteria.getId()).
                filter(patient -> criteria.getName() == null || patient.getName().equalsIgnoreCase(criteria.getName())).toList();
    }

    public void showAllPatientDetails(List<Patient> patientList) {
        System.out.println("Patient Details : ");
        for (Patient p : patientList) {
            patientDetail(p);
        }
        System.out.println("---------------------------------------");
    }

    public void showAllPatientDetails() {
        System.out.println("Patient Details : ");
        for (Patient p : patientList) {
            patientDetail(p);
        }
        System.out.println("---------------------------------------");
    }

    public void patientDetail(Patient patient) {
        System.out.println("---------------------------------------");
        System.out.println("Patient Id : "+patient.getId());
        System.out.println("Name : " + patient.getName());
        System.out.println("EmailId : " + patient.getEmailId());
        System.out.println("Patient Disease  : " + patient.getDisease());
        System.out.println("Mobile No : " + patient.getMobileNo());
        System.out.println("---------------------------------------");
    }

    public List<Patient> findAllPatientWithDisease(String disease) {
        List<Patient> patients = new ArrayList<>();
        for (Patient p : patientList) {
            if (p.getDisease().equalsIgnoreCase(disease)) {
                patients.add(p);
            }
        }
        return patients;
    }

    public Patient updatePatientDetailById(long id, Scanner sc) {
        for (Patient patient : patientList) {
            if (patient.getId() == (id)) {
                int index = patientList.indexOf(patient);
                sc.nextLine();
                System.out.println("Enter Patient Full Name : ");
                String patientName = sc.nextLine();
                patient.setName(patientName);
                System.out.println("Enter Patient EmailId : ");
                String patientEmailId = sc.next();
                patient.setEmailId(patientEmailId);
                System.out.println("Enter Patient Disease : ");
                String patientDisease = sc.next();
                patient.setDisease(patientDisease);
                System.out.println("Enter Mobile Number : ");
                String patientMobileNo = sc.next();
                patient.setMobileNo(patientMobileNo);
                return patientList.set(index, patient);
            }
        }
        return null;
    }

    public boolean deletePatientDetailById(long id) {
        for (Patient patient : patientList) {
            if (patient.getId() == (id)) {
                return patientList.remove(patient);
            }
        }
        return false;
    }

}
