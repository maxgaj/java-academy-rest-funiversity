package be.mc.maxgaj.funiversity.service;

import be.mc.maxgaj.funiversity.domain.Professor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorRepositoryTest {

    @Test
    void persist_givenProfessor_thenReturnProfessorSaved() {
        Professor professor = new Professor("Max", "Gaj");
        ProfessorRepository repository = new ProfessorRepository();
        Professor savedProfessor = repository.persist(professor);
        Assertions.assertThat(savedProfessor).isEqualTo(professor);
    }

    @Test
    void findById_givenValidId_returnCorrectprofessor() {
        Professor professor = new Professor("Max", "Gaj");
        ProfessorRepository repository = new ProfessorRepository();
        repository.persist(professor);
        Professor fetchedProfessor = repository.findById(professor.getId().toString());
        Assertions.assertThat(fetchedProfessor).isEqualTo(professor);
    }

    @Test
    void findById_givenInvalidId_thenThrowsException() {
        ProfessorRepository repository = new ProfessorRepository();
        Assertions.assertThatThrownBy(() -> repository.findById("INVALID")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void findAll_givenProfessorsAlreadySaved_returnCorrectCollectionOfProfessors() {
        Professor professor1 = new Professor("Max", "Gaj");
        Professor professor2 = new Professor("Max", "Test");
        ProfessorRepository repository = new ProfessorRepository();
        repository.persist(professor1);
        repository.persist(professor2);
        Assertions.assertThat(repository.findAll()).containsExactlyInAnyOrder(professor1, professor2);
    }

    @Test
    void remove_givenValidId_thenCorrectProfessorIsReturned() {
        Professor professor = new Professor("Max", "Gaj");
        ProfessorRepository repository = new ProfessorRepository();
        repository.persist(professor);
        Professor returnedProfessor = repository.remove(professor);
        Assertions.assertThat(returnedProfessor).isEqualTo(professor);
    }
}