# NOU-e-Gyan-Portal
This is a web-based application built using Java, Spring Boot, Hibernate, and MySQL that helps college administrators upload and share study materials or assignments with students.

🚀 Features
👨‍🏫 Admin Panel:
Can add study materials or assignments.
Materials include: Program, Branch, Year, Subject, Topic, File, etc.
Admin can upload PDFs, notes, and assignments.
Admin can manage all the uploaded materials.
Manage Profiles
Change Passwords
Log Out from Admin Panel

👩‍🎓 Student Panel:
Students can register and log in.
After logging in, students can:
View study materials filtered by Program, Branch, and Year.
Download materials (like assignments, notes, etc.).
User-friendly dashboard to view all study files shared by admin.

📩 Contact Form with SMS Notification
This project includes a contact/enquiry form where users (students or visitors) can enter:

Name
Email
Phone Number
Enquiry Type
Message
Once submitted, the admin receives the enquiry directly on their phone via SMS.

🔧 Technologies Used
Java(Core/Advance)
Spring Boot
Hibernate/JPA
MySQL
Thymeleaf (for frontend templates)
Maven

📁 How to Run the Project
Clone the repository

bash
Copy code
git clone <your_repo_link>
cd <your_project_folder>
Open in your IDE (like IntelliJ or Eclipse)

Configure the database
In application.properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=root
spring.datasource.password=your_password
Run the project
Start NouappApplication.java as a Spring Boot application.
Access the app

Admin: http://localhost:8080/admin

Student: http://localhost:8080/student

🔐 Login Credentials (example)
You can create users from the database or from the registration page.

✅ Future Improvements
Chat Bot for students
Add file preview option.
Add categories for materials (e.g. notes, live classes).
Mobile responsive design.


-----------------------------------------

🙋‍♀ Author
Shreya Nigam
Feel free to contact for queries or collaborations.
