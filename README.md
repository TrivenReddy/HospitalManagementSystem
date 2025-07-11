


# 🏥 Hospital Management System

This is a Hospital Management System developed using **Spring Boot** and **Spring Tool Suite (STS)**. It helps manage hospital operations such as patient records, doctor details, appointments, and staff information.

## 🚀 Features

- CRUD operations for managing:
  - Patients
  - Doctors
  - Appointments
  - Staff
- RESTful APIs for interaction
- Layered Spring MVC architecture
- Maven-based project structure

## 🛠 Technologies Used

- Java
- Spring Boot
- Spring MVC
- Maven
- Spring Tool Suite (STS)

## 📁 Project Structure

- `src/main/java` - Java source code
- `src/main/resources` - Configuration files (e.g., `application.properties`)
- `pom.xml` - Maven build configuration



2. **Open in Spring Tool Suite (STS):**

   * Go to `File > Import > Existing Maven Projects`
   * Select the project folder
   * Finish the import

3. **Run the Application:**

   * Right-click on the main class (`HospitalManagementApplication.java`)
   * Select `Run As > Spring Boot App`

4. **Access API:**

   
   http://localhost:8080/
   

## ✅ Prerequisites

* Java 8 or above
* Maven 3.x
* Spring Tool Suite (STS)

## ✅  “Testing API with Postman”
* 📌 Example requests for:

  * Creating a patient (`POST`)
  * Getting patient data (`GET`)
  * Updating a patient (`PUT`)
  * Deleting a patient (`DELETE`)

---

## 📬 Testing the API with Postman

You can test the REST APIs using [Postman](https://www.postman.com/). Below are some common requests:

### 🔹 1 Add a New Patient
**Method:** `POST`  
**URL:** `http://localhost:8080/api/patients`  


### 🔹 2. Get All Patients

**Method:** `GET`
**URL:** `http://localhost:8080/api/patients`

---

### 🔹 3. Get Patient by ID

**Method:** `GET`
**URL:** `http://localhost:8080/api/patients/{id}`
*Replace `{id}` with the patient's ID*

---

### 🔹 4. Update Patient

**Method:** `PUT`
**URL:** `http://localhost:8080/api/patients/{id}`


Further we can connect frontend part by developing the website using frameworks like ReactJs.

