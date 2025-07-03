package oop.finalexam.t2;

import java.util.ArrayList;
import java.util.List;

/**
 * University Management System (UMS) - Main class that manages students and their courses.
 * This system maintains a list of students and provides functionality to display
 * student information including their enrolled learning courses.
 *
 * @author Zaali injgia
 * @version 1.0
 */
public class UMS {

    /** List of students in the University Management System */
    private List<Student> students;

    /**
     * Default constructor for UMS.
     * Initializes the students list.
     */
    public UMS() {
        this.students = new ArrayList<>();
    }

    /**
     * Gets the list of students in the UMS.
     *
     * @return The list of students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Sets the list of students in the UMS.
     *
     * @param students The list of students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Adds a student to the University Management System.
     *
     * @param student The student to add
     */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    /**
     * Removes a student from the University Management System.
     *
     * @param student The student to remove
     * @return true if the student was removed, false otherwise
     */
    public boolean removeStudent(Student student) {
        return this.students.remove(student);
    }

    /**
     * Prints detailed information about a specific student including all their learning courses.
     * The UMS displays clear output showing which learning courses belong to which student.
     * All properties of each learning course are displayed.
     *
     * @param student The student whose data should be printed
     */
    public void printStudentData(Student student) {
        if (student == null) {
            System.out.println("Error: Student is null");
            return;
        }

        System.out.println("=====================================");
        System.out.println("           STUDENT INFORMATION       ");
        System.out.println("=====================================");
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Major: " + student.getMajor());
        System.out.println("Number of Courses: " + student.getLearningCourses().size());
        System.out.println();

        System.out.println("=====================================");
        System.out.println("    LEARNING COURSES FOR STUDENT    ");
        System.out.println("    " + student.getFirstName() + " " + student.getLastName());
        System.out.println("=====================================");

        List<LearningCourse> courses = student.getLearningCourses();
        if (courses.isEmpty()) {
            System.out.println("No learning courses enrolled.");
        } else {
            for (int i = 0; i < courses.size(); i++) {
                LearningCourse course = courses.get(i);
                System.out.println("Course #" + (i + 1) + ":");
                System.out.println("  Title: " + course.getTitle());
                System.out.println("  Prerequisites: " + course.getAcceptancePrerequisites());
                System.out.println("  Major Topics: " + course.getMajorTopics());
                System.out.println();
            }
        }
        System.out.println("=====================================");
    }

    /**
     * Creates and returns  my actual Argus courses.
     */
    private Student createYourself() {
        Student myself = new Student(
                "Zaali",
                "Injgia",
                "3970104684x",
                "zaali.injgia.1@gmail.com",
                "Computer Science"
        );

        LearningCourse course1 = new LearningCourse(
                "Object-Oriented Programming",
                "CS50",
                "Java syntax and data structures"
        );

        LearningCourse course2 = new LearningCourse(
                "Calculus 2",
                "Calculus 1",
                "Antiderivatives.\n" +
                        "Definite integrals.\n" +
                        "Techniques and applications of integration.\n" +
                        "Improper integrals.\n" +
                        "Infinite series."
        );

        LearningCourse course3 = new LearningCourse(
                "Computer Organization",
                "CS50\n",
                "Representing and manipulating information;\n" +
                        "Machine-level representations of programs;\n" +
                        "Optimizing program Performance;\n" +
                        "The memory hierarchy\n"
        );

        LearningCourse course4 = new LearningCourse(
                "English C1-2",
                "English C1-1\n",
                "Globalization and Its Impact, Environmental Issues and Technology and Society."
        );

        LearningCourse course5 = new LearningCourse(
                "Mathematical Foundation of Computing",
                "Calculus I, CS50 Introduction to Programming",
                "Mathematical logic;\n" +
                        "Elements of Discrete Mathematics;\n" +
                        "Elements of Sets Theory;\n" +
                        "Elements of Graph Theory;\n" +
                        "Elements of Combinatorics;\n" +
                        "Elements of Digital Systems\n"
        );

        myself.addLearningCourse(course1);
        myself.addLearningCourse(course2);
        myself.addLearningCourse(course3);
        myself.addLearningCourse(course4);
        myself.addLearningCourse(course5);

        return myself;
    }

    /**
     * Finds a student by their student ID in the UMS.
     *
     * @param studentId The student ID to search for
     * @return The student with the given ID, or null if not found
     */
    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Main method to demonstrate the University Management System.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        UMS ums = new UMS();

        Student myself = ums.createYourself();
        ums.addStudent(myself);

        Student student1 = new Student("John", "Doe", "STU001", "john.doe@university.edu", "Computer Science");
        Student student2 = new Student("Jane", "Smith", "STU002", "jane.smith@university.edu", "Information Technology");

        student1.addLearningCourse(new LearningCourse(
                "Introduction to Programming",
                "High School Mathematics",
                "Variables, Control Structures, Functions, Basic Data Types"
        ));

        student1.addLearningCourse(new LearningCourse(
                "Web Development",
                "Introduction to Programming, HTML/CSS Basics",
                "HTML, CSS, JavaScript, React, Node.js, Database Integration"
        ));

        // Add sample courses to student2
        student2.addLearningCourse(new LearningCourse(
                "Network Security",
                "Computer Networks, Cryptography Fundamentals",
                "Firewalls, Intrusion Detection, Encryption, Security Protocols"
        ));

        ums.addStudent(student1);
        ums.addStudent(student2);

        System.out.println("=== UNIVERSITY MANAGEMENT SYSTEM ===");
        System.out.println();

        System.out.println("Printing data for myself (from Argus):");
        ums.printStudentData(myself);

        System.out.println("\nPrinting data for sample student 1:");
        ums.printStudentData(student1);

        System.out.println("\nPrinting data for sample student 2:");
        ums.printStudentData(student2);

        System.out.println("\n=== STUDENT SEARCH FUNCTIONALITY ===");
        System.out.println("Finding student by ID 'STU001':");
        Student foundStudent = ums.findStudentById("STU001");
        if (foundStudent != null) {
            System.out.println("Found: " + foundStudent.getFirstName() + " " + foundStudent.getLastName());
        } else {
            System.out.println("Student not found.");
        }

        System.out.println("\nTotal students in UMS: " + ums.getStudents().size());
    }
}