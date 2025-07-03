# University Management System (UMS)

## Project Description

This project implements a simple University Management System (UMS) that manages students and their enrolled learning courses. The system maintains a list of students, and each student has a list of learning courses they are taking.

Each learning course contains information about its title, acceptance prerequisites, and major topics covered in the course.

The system provides functionality to print detailed information about any student along with their enrolled courses.

---

## Classes Overview

### UMS

- Manages a list of `Student` objects.
- Methods to add and remove students.
- Method `printStudentData(Student student)` prints full details of a student and their courses.
- Contains a method to create a predefined "myself" student with Argus courses.
- Has a method to find a student by their student ID.

---

### Student

- Represents a university student.
- Fields:
  - `firstName`: String
  - `lastName`: String
  - `studentId`: String
  - `email`: String
  - `major`: String
  - `learningCourses`: List of `LearningCourse`
- Methods to add and remove learning courses.
- Getters and setters for all fields.

---

### LearningCourse

- Represents a course that a student can enroll in.
- Fields:
  - `title`: String
  - `acceptancePrerequisites`: String
  - `majorTopics`: String
- Getters and setters for all fields.

---

## Example Course Description

**Calculus 2**

- **Prerequisites:** Calculus 1
- **Major Topics:**
  - Antiderivatives
  - Definite integrals
  - Techniques and applications of integration
  - Improper integrals
  - Infinite series

---

## UML Diagram
![image](https://github.com/user-attachments/assets/aba2689a-6f2d-43b7-8aea-6383f4a77d0f)


The UML diagram illustrates the structure and relationships between the classes `UMS`, `Student`, and `LearningCourse`.

- Each class is represented as a table with:
  - Class name
  - Fields (attributes)
  - Methods (functions)
- Arrows indicate associations:
  - `UMS` *has many* `Student` objects.
  - `Student` *has many* `LearningCourse` objects.


## Author

Zaali Injgia

---

