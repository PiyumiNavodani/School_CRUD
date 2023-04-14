package com.school.school.controller;

import com.school.school.model.Student;
import com.school.school.model.Teacher;
import com.school.school.service.StudentService;
import com.school.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    //Create Student
    @PostMapping(path = "/addStudent")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    //Read Student
    @GetMapping(path ="/getStudent")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    //Update Student
    @PutMapping("/updateStudent")
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        Optional<Student> findStudent = Optional.ofNullable((Student) studentService.getStudent());

        if(findStudent.isPresent()){
            Student updateStudent = findStudent.get();
            updateStudent.setFName(student.getFName());
            updateStudent.setLName(student.getLName());
            updateStudent.setAge(student.getAge());
            updateStudent.setGrade(student.getAge());
            return new ResponseEntity<>(studentService.updateStudent(updateStudent), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete Student
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }

}

