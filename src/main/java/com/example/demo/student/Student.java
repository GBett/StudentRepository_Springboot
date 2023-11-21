package com.example.demo.student;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_email")
    private String email;

    @Column(name = "student_dob")
    private LocalDate dob;

    @Transient
    private int age;

    // Constructor
    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = calculateAge();
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Getter for dob
    public LocalDate getDob() {
        return dob;
    }

    // Calculate age based on the date of birth
    private int calculateAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    // Other properties and methods
}
