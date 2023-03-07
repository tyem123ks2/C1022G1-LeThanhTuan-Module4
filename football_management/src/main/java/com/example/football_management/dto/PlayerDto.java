package com.example.football_management.dto;

import com.example.football_management.model.Nation;
import com.example.football_management.model.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PlayerDto implements Validator {
    private int id;
    @NotBlank(message = "Player names cannot be left blank")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "The name cannot contain numbers and special characters")
    private String name;
    private String dateOfBirth;
    @NotBlank(message = "Age  cannot be left blank")
    @Min(value = 16, message = "Age > 16")
    @Max(value = 100, message = "Age < 100")
    private int age;
    @NotBlank(message = "Experience cannot be left blank")
    @Pattern(regexp = "^[1-9]\\d*$", message = "EXP must be a positive integer")
    private int experience;
    private Position position;
    private Nation nation;

    public PlayerDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PlayerDto playerDto = (PlayerDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        try {
            LocalDate dateOfBirth1 = LocalDate.parse(playerDto.dateOfBirth, formatter);
        } catch (DateTimeParseException e) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Date of birth must be in the correct format: dd/MM/YYYY");
        }
    }
}
