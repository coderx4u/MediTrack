package main.java.com.airtribe.meditrack.service;

import main.java.com.airtribe.meditrack.constants.AppointmentStatus;
import main.java.com.airtribe.meditrack.constants.Availability;
import main.java.com.airtribe.meditrack.entity.Appointment;
import main.java.com.airtribe.meditrack.entity.Doctor;
import main.java.com.airtribe.meditrack.entity.Patient;

public class AppointmentService {

    //appointment notifications (console reminders)
    //Appointments: create, view, cancel. Use AppointmentStatus enum.

    public Appointment bookAppointment(Doctor doctor, Patient patient, String date) {
        Appointment appointment = new Appointment();
        if (doctor.getAvailability().equals(Availability.AVAILABLE)) {
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
            appointment.setDate(date);
            appointment.setAppointmentStatus(AppointmentStatus.CONFIRMED);
            doctor.setAvailability(Availability.NOT_AVAILABLE);
            return appointment;
        } else {
            appointment.setAppointmentStatus(AppointmentStatus.PENDING);
        }
        return appointment;
    }
}
