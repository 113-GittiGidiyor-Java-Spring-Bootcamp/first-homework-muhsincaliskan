package dev.patika.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseName;
    private String courseCode;
    private Number creditScore;



    @ManyToOne
    private Instructor instructor;
    @ManyToMany
    private List<Student> studentList;
    public Course() {
    }

    public Course(String courseName, String courseCode, Number creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Number getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Number creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return getCourseName().equals(course.getCourseName()) && getCourseCode().equals(course.getCourseCode()) && getCreditScore().equals(course.getCreditScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseName(), getCourseCode(), getCreditScore());
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", creditScore=" + creditScore +
                '}';
    }
}
