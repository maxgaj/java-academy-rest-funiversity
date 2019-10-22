package be.mc.maxgaj.funiversity.api.mappers.dtos;

public class ProfessorDto {
    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public ProfessorDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ProfessorDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ProfessorDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
