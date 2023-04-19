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
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    //Create Student
    @PostMapping(path = "/addStudent")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    //Get Student
    @GetMapping(path ="/getStudent")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }

    //Get Student By ID
    @GetMapping(path = "/getStudentById/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long id){
        Optional<Student> findStudent =Optional.ofNullable(studentService.getStudentById(id));
        if(findStudent.isPresent()){
            return ResponseEntity.ok().body(findStudent);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Update Student
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable Long id){
        Optional<Student> findStudent = Optional.ofNullable(studentService.getStudentById(id));

        if(findStudent.isPresent()){
            Student updateStudent = findStudent.get();
            updateStudent.setFirstName(student.getFirstName());
            updateStudent.setLastName(student.getLastName());
            updateStudent.setAge(student.getAge());
            updateStudent.setGrade(student.getGrade());
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

