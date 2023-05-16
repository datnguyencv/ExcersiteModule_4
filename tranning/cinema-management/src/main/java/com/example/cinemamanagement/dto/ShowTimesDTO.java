package com.example.cinemamanagement.dto;

import com.example.cinemamanagement.model.Movie;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ShowTimesDTO implements Validator {
    private Integer id;
    @Pattern(regexp = "^(CI-)\\d{4}$", message = "Code wrong format Exp:CI-0001")
    private String code;
    @NotBlank
    private String name;
    @NotBlank
    private String dateStream;
    private Integer quantityTicket;
    private Movie movies;


    public ShowTimesDTO() {
    }

    public ShowTimesDTO(Integer id, String code, String name, String dateStream, Integer quantityTicket, Movie movies) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dateStream = dateStream;
        this.quantityTicket = quantityTicket;
        this.movies = movies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateStream() {
        return dateStream;
    }

    public void setDateStream(String dateStream) {
        this.dateStream = dateStream;
    }

    public Integer getQuantityTicket() {
        return quantityTicket;
    }

    public void setQuantityTicket(Integer quantityTicket) {
        this.quantityTicket = quantityTicket;
    }

    public Movie getMovies() {
        return movies;
    }

    public void setMovies(Movie movies) {
        this.movies = movies;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ShowTimesDTO showTimesDTO = (ShowTimesDTO) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate dateStream = LocalDate.parse(showTimesDTO.getDateStream(), formatter);
            LocalDate date = LocalDate.now();
            if (dateStream.isBefore(date)) {
                errors.reject("dateStream", "You can change the date stream after today.");
            }
        } catch (DateTimeParseException e) {
            errors.reject("dateStream", "DateStream format not supported, Please check and try again!");
        }

    }
}
