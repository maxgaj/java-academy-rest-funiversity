package be.mc.maxgaj.funiversity.service;

import be.mc.maxgaj.funiversity.domain.Course;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CourseRepository {
    private ConcurrentHashMap<String, Course> course_db;

    public CourseRepository() {
        this.course_db = new ConcurrentHashMap<>();
    }

    public Course persist(Course course) {
        course_db.put(course.getId().toString(), course);
        return course;
    }

    public Collection<Course> findAll() {
        return course_db.values();
    }
}
