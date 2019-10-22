package be.mc.maxgaj.funiversity.domain;

import java.util.UUID;

public class Course {
    private UUID id;
    private String name;
    private int studyPoints;
    private Professor professor;

    public Course(String name, int studyPoints, Professor professor) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.studyPoints = studyPoints;
        this.professor = professor;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public Professor getProfessor() {
        return professor;
    }
}
