package model;

public class Patient {
    private int patient_ID;
    private String name;
    private int age;
    private String gender;

    public Patient(int patient_ID,String name,int age,String gender) {
        this.patient_ID = patient_ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getPatientID() {
        return patient_ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void displayPatientInfo() {
        System.out.println("Patient ID : " + patient_ID + " | Name : " + name + " | Age : " + age + " | Gender : " + gender);
    }

}
