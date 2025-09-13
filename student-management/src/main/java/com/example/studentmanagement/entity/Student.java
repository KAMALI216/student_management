package com.example.studentmanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_username")
    private String username;

    @Column(name = "student_email")
    private String email;

    @Column(name = "student_phone")
    private String phone;

    @Column(name = "student_gender")
    private String gender;

    @Column(name = "student_dob")
    private LocalDate dob;

    @Column(name = "student_branch")
    private String branch;

    @Column(name = "student_percentage")
    private float percentage;

    // ✅ Default Constructor
    public Student() {}

    // ✅ Constructor with all fields (you can omit rollNo for insert operations)
    public Student(String name, String username, String email, String phone, String gender,
                   LocalDate dob, String branch, float percentage) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.branch = branch;
        this.percentage = percentage;
    }

    // ✅ Getters and Setters
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", branch='" + branch + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
