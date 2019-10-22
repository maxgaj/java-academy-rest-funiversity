package be.mc.maxgaj.funiversity.domain;

import be.mc.maxgaj.funiversity.domain.Professor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ProfessorTest {
    @Test
    void givenNothing_whenCreateNewProfessor_thenProfessorGetAnID() {
        Professor professor = new Professor("Michel", "Dubois");
        Assertions.assertThat(professor.getId()).isNotNull();
    }

    @Test
    void givenNothing_whenCreateNewProfessor_thenProfessorHasFirstNameAndLastName() {
        Professor professor = new Professor("Michel", "Dubois");
        Assertions.assertThat(professor.getFirstName()).isEqualTo("Michel");
        Assertions.assertThat(professor.getLastName()).isEqualTo("Dubois");
    }
}