import dao.PatientsDAO;
import dao.DoctorsDAO;
import dao.AppoinmentDAO;
import model.Patient;
import model.Doctor;
import model.Appointment;

import java.sql.SQLException;
import java.util.Scanner;

public class Hospital {
 public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PatientsDAO patientsDAO = new PatientsDAO();
    DoctorsDAO doctorsDAO = new DoctorsDAO();
    AppoinmentDAO appoinmentDAO = new AppoinmentDAO();

    boolean running = true;
    while(running) {
        System.out.println("----HOSPITAL MANAGEMENT SYSTEM-----");
        System.out.println("1. ADD Patient : ");
        System.out.println("2. ADD Doctor : ");
        System.out.println("3. View All Patients : ");
        System.out.println("4. View All Doctors : ");
        System.out.println("5. View Waiting List : ");
        System.out.println("6. Book Appointment : ");
        System.out.println("7. Log Out : ");
        System.out.println("Enter User Choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            case 1 :
                System.out.println("Enter Patient ID : ");
                int patient_ID = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Patient Name : ");
                String patientname = scanner.nextLine();
                System.out.println("Enter Patient Age : ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Patient Gender : ");
                String gender = scanner.nextLine();
                try {
                patientsDAO.addPatient(new Patient(patient_ID, patientname, age, gender));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

           case 2 :
                    System.out.println("Enter Doctor ID : ");
                    int doctor_ID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Doctor Name :  ");
                    String doctorname = scanner.nextLine();
                    System.out.println("Enter Specialization : ");
                    String specialization = scanner.nextLine();   
                    try {                                                                                                                                                                                                                                           
               doctorsDAO.addDoctor(new Doctor(doctor_ID, doctorname, specialization));
                   } catch (SQLException e) {
                 e.printStackTrace();
                }
              break;

              case 3 :
                    System.out.println("---- VIEW PATIENTS ----");
                  try {
                  patientsDAO.getAllPatient().forEach(patient -> patient.displayPatientInfo());
                    } catch ( SQLException e) {
                       e.printStackTrace();
                    }
                       break;

              case 4 :
                        System.out.println("--- VIEW DOCTORS ---");
                        try {
                         doctorsDAO.getAllDoctors().forEach(doctor -> doctor.displayDoctorInfo());
                     } catch (SQLException e) {
                            e.printStackTrace();
                           }
                     break;

              case 5 :
                           System.out.println("----- WAITING PATIENTS -----");
                          try {
                          patientsDAO.getAllPatient().forEach(patient -> patient.displayPatientInfo());
                             System.out.println(" -------- AVAILABLE DOCTOR'S --------");
                          doctorsDAO.getAllDoctors().forEach(doctor -> doctor.displayDoctorInfo());
                        } catch (SQLException e) {
                            e.printStackTrace();
                            }
                             break;

                case 6 : 
                      System.out.println("Enter Name : ");
                           String name = scanner.nextLine();
                           System.out.println("Enter Patient ID : ");
                            int patientID = scanner.nextInt();
                           scanner.nextLine();   
                           System.out.println("Enter Doctor ID : ");
                           int doctorID = scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("Enter Appointment Date : ");
                         String appoinment_Date = scanner.nextLine();     
                         try {
                            appoinmentDAO.addAppointment(new Appointment(0, patientID, doctorID, appoinment_Date));                              } catch (SQLException e) {
                              e.printStackTrace();
                         }
                         break;

                 case 7 :
                        System.out.println("Logging out.......");
                          running = false;
                           break;

    } 
}
 }
}
