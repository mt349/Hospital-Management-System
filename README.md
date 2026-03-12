# 🏥 Hospital Management System

A Java console application to manage patients, doctors, and appointments using a MySQL database — built with a clean **DAO (Data Access Object) architecture**.

---

## 🚀 Features

- ➕ Add Patients
- ➕ Add Doctors
- 📋 View All Patients
- 📋 View All Doctors
- ⏳ View Waiting List & Available Doctors
- 📅 Book Appointments

---

## 🛠️ Tech Stack

- **Java** — Core application logic
- **MySQL** — Database
- **JDBC** — Java Database Connectivity (MySQL Connector/J)

---

## 📁 Project Structure

```
src/
├── Hospital.java          ← Main menu & entry point
├── db/
│   └── DBConnection.java  ← Database connection handler
├── model/
│   ├── Patients.java      ← Patient data model
│   ├── Doctor.java        ← Doctor data model
│   └── Appointment.java   ← Appointment data model
└── dao/
    ├── PatientsDAO.java   ← Patient database operations
    ├── DoctorsDAO.java    ← Doctor database operations
    └── AppoinmentDAO.java ← Appointment database operations
```

---

## ⚙️ Setup & Installation

### 1. Clone the repository
```bash
git clone https://github.com/mt349/Hospital-Management-System.git
cd Hospital-Management-System
```

### 2. Set up the MySQL Database
```sql
CREATE DATABASE hospital_db;
USE hospital_db;

CREATE TABLE patients (
    patient_ID INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(10)
);

CREATE TABLE doctors (
    doctor_ID INT PRIMARY KEY,
    name VARCHAR(100),
    specialization VARCHAR(100)
);

CREATE TABLE appoinments (
    appointment_ID INT PRIMARY KEY AUTO_INCREMENT,
    patient_ID INT,
    doctor_ID INT,
    appoinment_date VARCHAR(20),
    FOREIGN KEY (patient_ID) REFERENCES patients(patient_ID),
    FOREIGN KEY (doctor_ID) REFERENCES doctors(doctor_ID)
);
```

### 3. Set Environment Variables
```bash
# Windows
set DB_URL=jdbc:mysql://localhost:3306/hospital_db
set DB_USER=your_username
set DB_PASS=your_password

# Mac/Linux
export DB_URL=jdbc:mysql://localhost:3306/hospital_db
export DB_USER=your_username
export DB_PASS=your_password
```

### 4. Add MySQL Connector/J
- Download from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)
- Place the `.jar` file in the `lib/` folder
- Add it to your classpath in VS Code via `Ctrl+Shift+P` → **Java: Configure Classpath**

### 5. Compile & Run
```bash
# Windows
javac -cp .;lib/mysql-connector-j-x.x.x.jar src/*.java src/db/*.java src/model/*.java src/dao/*.java
java -cp .;lib/mysql-connector-j-x.x.x.jar Hospital

# Mac/Linux (replace ; with :)
javac -cp .:lib/mysql-connector-j-x.x.x.jar src/*.java src/db/*.java src/model/*.java src/dao/*.java
java -cp .:lib/mysql-connector-j-x.x.x.jar Hospital
```

---

## 📸 Usage

```
----HOSPITAL MANAGEMENT SYSTEM-----
1. ADD Patient
2. ADD Doctor
3. View All Patients
4. View All Doctors
5. View Waiting List
6. Book Appointment
7. Log Out
Enter User Choice:
```

---

## 🏗️ Architecture

This project follows the **DAO (Data Access Object)** pattern:

- **Model layer** — Plain Java classes representing data (Patient, Doctor, Appointment)
- **DAO layer** — Handles all database queries, keeping SQL out of main logic
- **DB layer** — Single class managing the database connection
- **Main class** — Only handles user input and calls DAO methods

---

## 🙋‍♀️ Author

Built by **Mahnoor Tariq (mt349)** — started as a beginner Java project and refactored to DAO architecture 💪

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
