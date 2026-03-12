package model;

public class Doctor {
    private int doctor_ID;
    private String name;
    private String specialization;

    public Doctor(int doctor_ID,String name,String specialization) {
        this.doctor_ID = doctor_ID;
        this.name = name;
        this.specialization = specialization;
    }

    public int getDoctorID() {
        return doctor_ID;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void displayDoctorInfo() {
        System.out.println("Doctor ID : " + doctor_ID + " | Name : " + name + " | Specialization : " + specialization);
    }

}
