package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "National")
public class National {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NationalId")
    private Long nationalId;

    @Column(name = "NationalName", length = 100)
    private String nationalName;

    // Getter & Setter
    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }

    @Override
    public String toString() {
        return "National{" +
                "nationalId=" + nationalId +
                ", nationalName='" + nationalName + '\'' +
                '}';
    }
}
