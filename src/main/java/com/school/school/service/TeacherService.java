package com.school.school.service;

import com.school.school.model.Teacher;
import com.school.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    //Create Teachers
    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    //Get Teachers
    public List<Teacher> getTeacher(){
        return teacherRepository.findAll();
    }

    //Get Teachers by Id
    public Teacher geTeacherByID(Long id){
        return teacherRepository.findById(id).orElse(null);
    }

    //Update Teachers
    public Teacher updateTeacherById(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    //Delete Teachers
    public void deleteTeacherById(Long id){
        teacherRepository.deleteById(id);
    }
}
