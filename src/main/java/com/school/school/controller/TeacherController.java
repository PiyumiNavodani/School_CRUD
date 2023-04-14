package com.school.school.controller;

import com.school.school.model.Teacher;
import com.school.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    //Create Teacher
    @PostMapping(path = "/addTeacher")
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }

    //Read Teacher
    @GetMapping(path ="/getTeacher")
    public List<Teacher> getTeacher(){
        return teacherService.getTeacher();
    }

    //Update Teacher
    @PutMapping("/updateTeacher/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
        Optional<Teacher> findTeacher = Optional.ofNullable((Teacher) teacherService.getTeacher());

        if(findTeacher.isPresent()){
            Teacher updateTeacher = findTeacher.get();
            updateTeacher.setFName(teacher.getFName());
            updateTeacher.setLName(teacher.getLName());
            updateTeacher.setAge(teacher.getAge());
            updateTeacher.setSubject(teacher.getSubject());
            return new ResponseEntity<>(teacherService.updateTeacherById(updateTeacher), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete Teacher
    @DeleteMapping("/deleteTeacher/{id}")
    public void deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
    }

}
