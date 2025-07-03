package oop.finalexam.t2;

/**
 * Represents a learning course with title, prerequisites, and major topics.
 * This class encapsulates all the information about a specific course
 * that a student can take in the University Management System (UMS).
 *
 * @author Zaali Injgia
 * @version 1.0
 */
public class LearningCourse {

    /** The title/name of the learning course */
    private String title;

    /** Prerequisites required to accept/enroll in this course */
    private String acceptancePrerequisites;

    /** Major topics covered in this course */
    private String majorTopics;

    /**
     * Default constructor for LearningCourse.
     */
    public LearningCourse() {
    }

    /**
     * Parameterized constructor for LearningCourse.
     *
     * @param title The title of the course
     * @param acceptancePrerequisites Prerequisites for the course
     * @param majorTopics Major topics covered in the course
     */
    public LearningCourse(String title, String acceptancePrerequisites, String majorTopics) {
        this.title = title;
        this.acceptancePrerequisites = acceptancePrerequisites;
        this.majorTopics = majorTopics;
    }

    /**
     * Gets the title of the learning course.
     *
     * @return The course title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the learning course.
     *
     * @param title The course title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the acceptance prerequisites for the course.
     *
     * @return The acceptance prerequisites
     */
    public String getAcceptancePrerequisites() {
        return acceptancePrerequisites;
    }

    /**
     * Sets the acceptance prerequisites for the course.
     *
     * @param acceptancePrerequisites The prerequisites to set
     */
    public void setAcceptancePrerequisites(String acceptancePrerequisites) {
        this.acceptancePrerequisites = acceptancePrerequisites;
    }

    /**
     * Gets the major topics covered in the course.
     *
     * @return The major topics
     */
    public String getMajorTopics() {
        return majorTopics;
    }

    /**
     * Sets the major topics covered in the course.
     *
     * @param majorTopics The major topics to set
     */
    public void setMajorTopics(String majorTopics) {
        this.majorTopics = majorTopics;
    }

    /**
     * Returns a string representation of the learning course.
     *
     * @return String representation of the course
     */
    @Override
    public String toString() {
        return "LearningCourse{" +
                "title='" + title + '\'' +
                ", acceptancePrerequisites='" + acceptancePrerequisites + '\'' +
                ", majorTopics='" + majorTopics + '\'' +
                '}';
    }
}