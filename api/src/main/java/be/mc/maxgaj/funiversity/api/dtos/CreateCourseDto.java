package be.mc.maxgaj.funiversity.api.dtos;

import be.mc.maxgaj.funiversity.domain.Professor;

import java.util.UUID;

public class CreateCourseDto {
    private String name;
    private int studyPoints;
    private String professorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public void setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }
}
