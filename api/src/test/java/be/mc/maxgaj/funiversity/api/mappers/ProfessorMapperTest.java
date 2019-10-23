package be.mc.maxgaj.funiversity.api.mappers;

import be.mc.maxgaj.funiversity.api.dtos.CreateProfessorDto;
import be.mc.maxgaj.funiversity.api.dtos.ProfessorDto;
import be.mc.maxgaj.funiversity.domain.Professor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProfessorMapper.class)
class ProfessorMapperTest {
    @Test
    void mapToDto_givenProfessor_returnCorrectDto(@Autowired ProfessorMapper professorMapper) {
        Professor professor = new Professor("TOM", "TOMSON");
        ProfessorDto dto = professorMapper.mapToDto(professor);
        Assertions.assertThat(dto.getFirstName()).isEqualTo("TOM");
        Assertions.assertThat(dto.getLastName()).isEqualTo("TOMSON");
        Assertions.assertThat(dto.getId()).isNotNull();
    }

    @Test
    void mapToExistingDomain_givenCreateProfessorDtoAndExistingProfessor_returnCorrectDto(@Autowired ProfessorMapper professorMapper) {
        Professor professor = new Professor("TOM", "TOMSON");
        CreateProfessorDto createProfessorDto = new CreateProfessorDto();
        createProfessorDto.setFirstName("JIM");
        createProfessorDto.setLastName("JIMSON");
        Professor mappedProfessor = professorMapper.mapToExistingDomain(createProfessorDto, professor);
        Assertions.assertThat(mappedProfessor.getFirstName()).isEqualTo("JIM");
        Assertions.assertThat(mappedProfessor.getLastName()).isEqualTo("JIMSON");
        Assertions.assertThat(mappedProfessor.getId()).isNotNull();
    }

    @Test
    void mapToNewDomain_givenCreateProfessorDto_returnCorrectDto(@Autowired ProfessorMapper professorMapper) {
        CreateProfessorDto createProfessorDto = new CreateProfessorDto();
        createProfessorDto.setFirstName("JIM");
        createProfessorDto.setLastName("JIMSON");
        Professor mappedProfessor = professorMapper.mapToNewDomain(createProfessorDto);
        Assertions.assertThat(mappedProfessor.getFirstName()).isEqualTo("JIM");
        Assertions.assertThat(mappedProfessor.getLastName()).isEqualTo("JIMSON");
        Assertions.assertThat(mappedProfessor.getId()).isNotNull();
    }
}
