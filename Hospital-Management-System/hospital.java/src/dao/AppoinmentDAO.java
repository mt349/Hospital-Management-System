package dao;
import model.Appointment;
import db.DBConnection;
import java.sql.*;
import java.util.*;

public class AppoinmentDAO {
    public void addAppointment(Appointment appointment) throws SQLException {
        String query = "INSERT INTO appoinments(appointment_ID,patient_ID,doctor_ID,appoinment_Date)VALUES(?,?,?,?)";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, appointment.getAppointmentID());
                preparedStatement.setInt(2, appointment.getPatientID());
                preparedStatement.setInt(3, appointment.getDoctorID());
                preparedStatement.setString(4, appointment.getAppointmentDate());
                preparedStatement.executeUpdate();
                System.out.println("Appointment Booked Successfully!");
            }
    }

    // Retreive Data 
    public List <Appointment> getAllAppointments() throws SQLException {
        List <Appointment> list  = new ArrayList<>();
        String query = "SELECT * FROM appoinments";
        try(Connection connection = DBConnection.getConnection();
          Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery(query)) {
            while(resultSet.next()) {
                list.add(new Appointment ( 
                    resultSet.getInt("appointment_ID"),
                    resultSet.getInt("patient_ID"),
                    resultSet.getInt("doctor_ID"),
                    resultSet.getString("appointment_Date")
                ));
            }

          }
          return list;
    }
}
