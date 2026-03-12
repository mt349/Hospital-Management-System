package dao;
import model.Doctor;
import db.DBConnection;
import java.sql.*;
import java.util.*;

public class DoctorsDAO {
    public void addDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO doctors(doctor_ID,name,specialization)VALUES(?,?,?)";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, doctor.getDoctorID());
                preparedStatement.setString(2, doctor.getName());
                preparedStatement.setString(3, doctor.getSpecialization());
                preparedStatement.executeUpdate();
                System.out.println("Doctor Added Successfully!");
            }
        }

                
    public List<Doctor> getAllDoctors() throws SQLException {
        List <Doctor> list = new ArrayList<>();
        String query = "SELECT * FROM doctors";
        try(Connection connection = DBConnection.getConnection();
          Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery(query)) {
            while(resultSet.next()) {
                list.add(new Doctor( 
                    resultSet.getInt("doctor_ID"),
                    resultSet.getString("name"),
                    resultSet.getString("specialization")
                ));
            }
          }
       return list;
    }

} 
     