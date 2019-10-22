package be.mc.maxgaj.funiversity.service;

import be.mc.maxgaj.funiversity.domain.Professor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProfessorRepository {
    private ConcurrentHashMap<String, Professor> professor_db;

    public ProfessorRepository() {
        this.professor_db = new ConcurrentHashMap<>();
    }

    public Collection<Professor> findAll() {
        return professor_db.values();
    }

    public Professor findById(String id) {
        if (professor_db.containsKey(id)) {
            return professor_db.get(id);
        }
        throw new IllegalArgumentException("There is no professor for the id " + id);
    }

    public Professor persist(Professor professor) {
        professor_db.put(professor.getId().toString(), professor);
        return professor;
    }

    public Professor remove(Professor professor) {
        if (professor_db.contains(professor)){
            professor_db.remove(professor.getId().toString());
        }
        return professor;
    }
}
