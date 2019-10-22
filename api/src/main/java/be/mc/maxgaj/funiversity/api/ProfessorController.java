package be.mc.maxgaj.funiversity.api;

import be.mc.maxgaj.funiversity.api.mappers.ProfessorMapper;
import be.mc.maxgaj.funiversity.api.mappers.dtos.CreateProfessorDto;
import be.mc.maxgaj.funiversity.api.mappers.dtos.ProfessorDto;
import be.mc.maxgaj.funiversity.domain.Professor;
import be.mc.maxgaj.funiversity.service.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = ProfessorController.PROFESSOR_CONTROLLER_RESOURCE_URL)
public class ProfessorController {

    public static final String PROFESSOR_CONTROLLER_RESOURCE_URL = "/professors";
    private ProfessorRepository repository;
    private ProfessorMapper mapper;

    @Autowired
    public ProfessorController(ProfessorRepository repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping(produces = "application/json")
    public List<ProfessorDto> getProfessors() {
        return repository.findAll().stream()
                .map(professor -> mapper.mapToDto(professor))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ProfessorDto getProfessor(@PathVariable("id") String id) {
        return mapper.mapToDto(
                repository.findById(id));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDto createProfessor(@RequestBody CreateProfessorDto createProfessorDto){
        return mapper.mapToDto(
                repository.persist(
                        mapper.mapToNewDomain(createProfessorDto)));
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ProfessorDto updateProfessor(@PathVariable("id") String id, @RequestBody CreateProfessorDto createProfessorDto){
        return mapper.mapToDto(
                repository.persist(
                        mapper.mapToExistingDomain(
                                createProfessorDto,
                                repository.findById(id))));
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ProfessorDto deleteProfessor(@PathVariable("id") String id){
        return mapper.mapToDto(
                repository.remove(
                        repository.findById(id)));
    }

}
