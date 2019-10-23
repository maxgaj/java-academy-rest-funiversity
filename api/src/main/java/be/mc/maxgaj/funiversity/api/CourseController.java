package be.mc.maxgaj.funiversity.api;

import be.mc.maxgaj.funiversity.api.dtos.CourseDto;
import be.mc.maxgaj.funiversity.api.dtos.CreateCourseDto;
import be.mc.maxgaj.funiversity.api.mappers.CourseMapper;
import be.mc.maxgaj.funiversity.service.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = CourseController.COURSES_CONTROLLER_RESOURCE_URL)
public class CourseController {

    public static final String COURSES_CONTROLLER_RESOURCE_URL = "/courses";
    private CourseRepository repository;
    private CourseMapper mapper;

    @Autowired
    public CourseController(CourseRepository repository, CourseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto createCourse(@RequestBody CreateCourseDto createCourseDto){
        return mapper.mapToDto(
                repository.persist(
                        mapper.mapToNewDomain(createCourseDto)));
    }

    @GetMapping(produces = "application/json")
    public List<CourseDto> getCourses(){
        return repository.findAll().stream()
                .map(course -> mapper.mapToDto(course))
                .collect(Collectors.toList());
    }
}
