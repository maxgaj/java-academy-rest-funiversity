package be.mc.maxgaj.funiversity.api.mappers;

import be.mc.maxgaj.funiversity.api.dtos.CourseDto;
import be.mc.maxgaj.funiversity.api.dtos.CreateCourseDto;
import be.mc.maxgaj.funiversity.domain.Course;
import be.mc.maxgaj.funiversity.domain.Professor;
import be.mc.maxgaj.funiversity.service.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    private ProfessorRepository professorRepository;

    @Autowired
    public CourseMapper(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Course mapToNewDomain(CreateCourseDto createCourseDto) {
        Professor professor = professorRepository.findById(createCourseDto.getProfessorId());
        return new Course(
                createCourseDto.getName(),
                createCourseDto.getStudyPoints(),
                professor
        );
    }

    public CourseDto mapToDto(Course course) {
        return new CourseDto()
                .setId(course.getId().toString())
                .setName(course.getName())
                .setStudyPoints(course.getStudyPoints())
                .setProfessor(course.getProfessor());
    }
}
