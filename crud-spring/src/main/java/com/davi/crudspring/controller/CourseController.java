package com.davi.crudspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davi.crudspring.model.Course;
import com.davi.crudspring.repository.CourseRepository;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor        //Comando para que o Lombok crie o Constructor
public class CourseController {
    
    private final CourseRepository courseRepository;

    /* 
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    */

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Course> list(){
    return courseRepository.findAll();
  }

}
