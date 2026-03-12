package model;

public class Appointment {
    private int appointment_ID;
    private int patient_ID;
    private int doctor_ID;
    private String appointment_Date;

    public Appointment(int appointment_ID,int patient_ID,int doctor_ID,String appointment_Date) {
        this.appointment_ID = appointment_ID;
        this.patient_ID = patient_ID;
        this.doctor_ID = doctor_ID;
        this.appointment_Date = appointment_Date;
    }

    public int getAppointmentID() {
        return appointment_ID;
    }

    public int getPatientID() {
        return patient_ID;
    }

    public int getDoctorID() {
        return doctor_ID;
    }

    public String getAppointmentDate() {
        return appointment_Date;
    }

    public void displayAppointmentInfo() {
        System.out.println("Appointment ID : " + appointment_ID + " | Patient ID : " + patient_ID + " | Doctor ID : " + doctor_ID + " | Appointment Date : " + appointment_Date);
    }

}
