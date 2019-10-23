package be.mc.maxgaj.funiversity.service;

import be.mc.maxgaj.funiversity.domain.Course;
import be.mc.maxgaj.funiversity.domain.Professor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryTest {

    @Test
    void persist_givenCourse_thenReturnCourseSaved() {
        Professor professor = new Professor("Max", "Gaj");
        Course course = new Course("course", 6, professor);
        CourseRepository repository = new CourseRepository();
        Course savedCourse = repository.persist(course);
        Assertions.assertThat(savedCourse).isEqualTo(course);
    }

    @Test
    void findAll_givenCoursesAlreadySaved_returnCorrectCollectionOfCourses() {
        Professor professor1 = new Professor("Max", "Gaj");
        Professor professor2 = new Professor("Max", "Test");
        Course course1 = new Course("course", 6, professor1);
        Course course2 = new Course("course2", 4, professor2);
        CourseRepository repository = new CourseRepository();
        repository.persist(course1);
        repository.persist(course2);
        Assertions.assertThat(repository.findAll()).containsExactlyInAnyOrder(course1, course2);
    }

}