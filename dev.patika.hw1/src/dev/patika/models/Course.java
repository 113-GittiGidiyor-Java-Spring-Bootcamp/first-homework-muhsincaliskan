package dev.patika.models;

import java.util.Objects;

public class Course {
    private String courseName;
    private String courseCode;
    private Number creditScore;

    public Course() {
    }

    public Course(String courseName, String courseCode, Number creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
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
