package oop.finalexam.t2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student in the University Management System (UMS).
 * Each student has personal information and a list of learning courses.
 *
 * @author Zaali Injgia
 * @version 1.0
 */
public class Student {

    /** Student's first name */
    private String firstName;

    /** Student's last name */
    private String lastName;

    /** Student's unique identification number */
    private String studentId;

    /** Student's email address */
    private String email;

    /** Student's major/field of study */
    private String major;

    /** List of learning courses the student is enrolled in */
    private List<LearningCourse> learningCourses;

    /**
     * Default constructor for Student.
     * Initializes the learning courses list.
     */
    public Student() {
        this.learningCourses = new ArrayList<>();
    }

    /**
     * Parameterized constructor for Student.
     *
     * @param firstName Student's first name
     * @param lastName Student's last name
     * @param studentId Student's ID
     * @param email Student's email
     * @param major Student's major
     */
    public Student(String firstName, String lastName, String studentId, String email, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.email = email;
        this.major = major;
        this.learningCourses = new ArrayList<>();
    }

    /**
     * Gets the student's first name.
     *
     * @return The first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name.
     *
     * @param firstName The first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the student's last name.
     *
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     *
     * @param lastName The last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the student's ID.
     *
     * @return The student ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Sets the student's ID.
     *
     * @param studentId The student ID to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets the student's email.
     *
     * @return The email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student's email.
     *
     * @param email The email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the student's major.
     *
     * @return The major/field of study
     */
    public String getMajor() {
        return major;
    }

    /**
     * Sets the student's major.
     *
     * @param major The major/field of study to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Gets the list of learning courses for this student.
     *
     * @return The list of learning courses
     */
    public List<LearningCourse> getLearningCourses() {
        return learningCourses;
    }

    /**
     * Sets the list of learning courses for this student.
     *
     * @param learningCourses The list of learning courses to set
     */
    public void setLearningCourses(List<LearningCourse> learningCourses) {
        this.learningCourses = learningCourses;
    }

    /**
     * Adds a learning course to the student's course list.
     *
     * @param course The learning course to add
     */
    public void addLearningCourse(LearningCourse course) {
        this.learningCourses.add(course);
    }

    /**
     * Removes a learning course from the student's course list.
     *
     * @param course The learning course to remove
     * @return true if the course was removed, false otherwise
     */
    public boolean removeLearningCourse(LearningCourse course) {
        return this.learningCourses.remove(course);
    }

    /**
     * Returns a string representation of the student.
     *
     * @return String representation of the student
     */
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", learningCourses=" + learningCourses.size() + " courses" +
                '}';
    }
}