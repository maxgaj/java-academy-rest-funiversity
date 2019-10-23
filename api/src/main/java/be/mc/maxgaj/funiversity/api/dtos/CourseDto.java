package be.mc.maxgaj.funiversity.api.dtos;

import be.mc.maxgaj.funiversity.domain.Professor;

import java.util.UUID;

public class CourseDto {
    private String id;
    private String name;
    private int studyPoints;
    private Professor professor;

    public String getId() {
        return id;
    }

    public CourseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public CourseDto setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
        return this;
    }

    public Professor getProfessor() {
        return professor;
    }

    public CourseDto setProfessor(Professor professor) {
        this.professor = professor;
        return this;
    }
}
