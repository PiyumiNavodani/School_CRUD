package com.school.school.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long id;

    @Column(name = "fName")
    public String fName;

    @Column(name = "lName")
    public String lName;

    @Column(name = "age")
    public int age;

    @Column(name = "subject")
    public String subject;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                '}';
    }
}
