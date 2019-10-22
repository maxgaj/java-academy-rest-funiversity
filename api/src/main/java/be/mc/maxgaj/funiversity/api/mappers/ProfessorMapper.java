package be.mc.maxgaj.funiversity.api.mappers;

import be.mc.maxgaj.funiversity.api.mappers.dtos.CreateProfessorDto;
import be.mc.maxgaj.funiversity.api.mappers.dtos.ProfessorDto;
import be.mc.maxgaj.funiversity.domain.Professor;

public class ProfessorMapper {

    public ProfessorDto mapToDto(Professor professor){
        return new ProfessorDto()
                .setFirstName(professor.getFirstName())
                .setLastName(professor.getLastName())
                .setId(professor.getId().toString());
    }

    public Professor mapToExistingDomain(CreateProfessorDto createProfessorDto, Professor professor) {
        professor.setFirstName(createProfessorDto.getFirstName());
        professor.setLastName(createProfessorDto.getLastName());
        return professor;
    }

    public Professor mapToNewDomain(CreateProfessorDto createProfessorDto) {
        return new Professor(
                createProfessorDto.getFirstName(),
                createProfessorDto.getLastName());
    }


}
