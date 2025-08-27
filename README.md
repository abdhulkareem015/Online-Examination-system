# Online-Examination-system

Description: 

   The Online Examination System is a Java-based application designed to conduct exams digitally. It automates the traditional examination process, allowing students to take exams online and administrators (teachers) to create, manage, and evaluate exams efficiently.

   The system uses Object-Oriented Programming (OOP) concepts in Java to organize different functionalities into classes like User, Student, Admin, Exam, Question, and Result. With database integration using MySQL, the system ensures that exam details, student information, and results are stored securely and can be retrieved at any time.

Key Features:

  For Students:

1. Register/Login to the system.

2. View available exams.

3. Take an exam with multiple-choice or true/false questions.

4. Submit answers within a time limit.

5. View results and feedback after submission.

  For Admin/Teachers:

1. Create and manage exams.

2. Add, edit, or delete questions.

3. Assign exams to students.

4. View student performance and generate reports.

OOP Concepts Applied:

1. Encapsulation → Private fields like password, score are accessed via getters/setters.

2. Inheritance → Student and Admin inherit common features from User.

3. Polymorphism → Methods like login() and checkAnswer() work differently depending on the object.

4. Abstraction → Abstract classes (User, Question) define common behaviors without exposing unnecessary details.

System Workflow:

1. Admin logs in → Creates Exam → Adds Questions.

2. Student logs in → Selects Exam → Answers Questions → Submits.

3. System evaluates answers automatically (for objective questions).

4. Result is stored in the database and displayed to the student.

