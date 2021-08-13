package dev.patika.models;

import javax.persistence.Entity;

@Entity
public class VisitingResearches extends Instructor{
    private Number hourlySalary;

    public VisitingResearches() {
    }

    public VisitingResearches(String name, String address, Number phoneNumber, Number hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public Number getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(Number hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
