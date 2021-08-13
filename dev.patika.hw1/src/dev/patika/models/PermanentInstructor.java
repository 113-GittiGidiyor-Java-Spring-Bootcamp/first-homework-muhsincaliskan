package dev.patika.models;

import javax.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor{
    private Number fixedSalary;

    public PermanentInstructor() {
    }

    public PermanentInstructor(String name, String address, Number phoneNumber, Number fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public Number getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(Number fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
