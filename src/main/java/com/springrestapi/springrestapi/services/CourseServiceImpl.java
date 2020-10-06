package com.springrestapi.springrestapi.services;

import com.springrestapi.springrestapi.dao.CourseDao;
import com.springrestapi.springrestapi.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    //region Crud using temp list
//    List<Course> list;
//
//    public CourseServiceImpl(){
//        list = new ArrayList<>();
//        list.add(new Course(111,"Java Se","Java Se fundamentals"));
//        list.add(new Course(112,"Android","Android fundamentals"));
//    }
//
//    @Override
//    public List<Course> getCourse() {
//        return list;
//    }
//
//    @Override
//    public Course getCourse(long courseId) {
//        Course c = null;
//        for(Course course:list){
//            if(course.getId()== courseId){
//                c = course;
//                break;
//            }
//        }
//        return c;
//    }
//
//    @Override
//    public Course addCourse(Course course) {
//        list.add(course);
//        return course;
//    }
//
//    @Override
//    public Course updateCourse(Course course) {
//        list.forEach(c -> {
//            if(c.getId() == course.getId()){
//                course.setTitle(course.getTitle());
//                course.setDescription(course.getDescription());
//            }
//        });
//        return  course;
//    }
//
//    @Override
//    public void deleteCourse(long parseLong) {
//        list = this.list.stream().filter( c -> c.getId() != parseLong).collect(Collectors.toList());
//    }
    //endregion

@Autowired
private CourseDao courseDao;

    public CourseServiceImpl(){
    }

    @Override
    public List<Course> getCourse() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {

        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        courseDao.save(course);
        return  course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        Course entity = courseDao.getOne(parseLong);
        courseDao.delete(entity);
    }
}
