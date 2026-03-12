package dao;

import db.DBConnection;
import model.Patient;
import java.sql.*;
import java.util.*;


public class PatientsDAO {
    public void addPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO patients(patient_ID,name,age,gender)VALUES(?,?,?,?)";
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, patient.getPatientID());
        preparedStatement.setString(2, patient.getName());
        preparedStatement.setInt(3, patient.getAge());
        preparedStatement.setString(4, patient.getGender());
        preparedStatement.executeUpdate();
        System.out.println("Patient Added Successfully!");
    
        }
    }

    public List <Patient> getAllPatient() throws SQLException {
        List <Patient> list = new ArrayList<>();
        String query = "SELECT * FROM patients";
        try(Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {
            while(resultSet.next()) {
                list.add(new Patient (
                    resultSet.getInt("patient_ID"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getString("gender")
                ));
            }
        }
         return list;
    }

}
