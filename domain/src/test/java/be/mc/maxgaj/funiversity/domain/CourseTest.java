package be.mc.maxgaj.funiversity.domain;

import be.mc.maxgaj.funiversity.domain.Course;
import be.mc.maxgaj.funiversity.domain.Professor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CourseTest {
    @Test
    void givenProfessor_whenCreateNewCourse_thenCourseGetAnID() {
        Professor professor = new Professor("Michel", "Dubois");
        Course course = new Course("RESTful API", 6, professor);
        Assertions.assertThat(course.getId()).isNotNull();
    }

    @Test
    void givenProfessor_whenCreateNewCourse_thenCourseHasCorrectField() {
        Professor professor = new Professor("Michel", "Dubois");
        Course course = new Course("RESTful API", 6, professor);
        Assertions.assertThat(course.getName()).isEqualTo("RESTful API");
        Assertions.assertThat(course.getStudyPoints()).isEqualTo(6);
        Assertions.assertThat(course.getProfessor()).isEqualTo(professor);
    }

}