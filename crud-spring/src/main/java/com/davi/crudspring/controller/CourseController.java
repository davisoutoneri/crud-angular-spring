package com.davi.crudspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public List<Course> list() {
        return courseRepository.findAll();
    }

    //@RequestMapping(method = RequestMethod.POST)
    //http status 201 = ResponseEntity / boas práticas
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) // mais eficiente e simplificado,clean code
    public /*ResponseEntity<Course>*/Course create(@RequestBody Course course) {
        //System.out.println(course.getName());
        return courseRepository.save(course);
        //return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    //http status 201

}
