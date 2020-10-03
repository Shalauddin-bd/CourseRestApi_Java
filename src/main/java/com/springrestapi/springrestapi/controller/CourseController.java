package com.springrestapi.springrestapi.controller;

import com.springrestapi.springrestapi.entities.Course;
import com.springrestapi.springrestapi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    public CourseService courseService;

    @GetMapping("/home")
    public  String home(){
        return "This is homepage.";
    }

    //Get all the courses
    @GetMapping("/courses")
    //@RequestMapping(path = "/courses",method = RequestMethod.GET)
    public List<Course> getCourses()
    {
        return  this.courseService.getCourse();
    }

    //Get single course
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId)
    {
        return  this.courseService.getCourse(Long.parseLong(courseId));
    }

    //Save single course
    @PostMapping("/courses")
    //@PostMapping(path = "/courses", consumes = "application/json")
    public Course addCourse(@RequestBody Course course)
    {
        return  this.courseService.addCourse(course);
    }

    //Update single course
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course)
    {
        return  this.courseService.updateCourse(course);
    }

    //Update single course
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
    {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
