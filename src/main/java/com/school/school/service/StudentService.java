package com.school.school.service;

import com.school.school.model.Student;
import com.school.school.model.Teacher;
import com.school.school.repository.StudentRepository;
import com.school.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //Create Student
    public Student createStudent(Student student){

        return studentRepository.save(student);
    }

    //Read Student
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    //Update Student
    public Student updateStudentById(Student student){
        return studentRepository.save(student);
    }

    //Delete Student
    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }
}
