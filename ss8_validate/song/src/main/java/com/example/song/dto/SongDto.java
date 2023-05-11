package com.example.song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.util.regex.Pattern;

public class SongDto implements Validator {
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String artist;

    @NotNull
    private String genre;

    public SongDto() {
    }

    public SongDto(Integer id, String name, String artist, String genre) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SongDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;

        String nameDto = songDto.getName().trim();
        String artistDto = songDto.getArtist().trim();
        String genreDto = songDto.getGenre().trim();

        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "artist", "artist.empty");
        ValidationUtils.rejectIfEmpty(errors, "genre", "genre.empty");

        if (nameDto.length() > 800) {
            errors.rejectValue("name", "name.length");
        } else if (!Pattern.matches("^[a-zA-Z\\s]{1,800}$", nameDto)) {
            errors.rejectValue("name", "name.char");
        }

        if (artistDto.length() > 300) {
            errors.rejectValue("artist", "artist.length");
        } else if (!Pattern.matches("^[a-zA-Z\\s]{1,300}$", artistDto)) {
            errors.rejectValue("artist", "artist.char");
        }

        //[\p{L}]+ : một hoặc nhiều ký tự là chữ cái hoặc ký tự tiếng Việt có dấu
        //(,[\p{L}\p{Mn}\p{Nd}\p{Pc}]+)* : (nhiều lần) một dấu phẩy , theo sau là một
        // hoặc nhiều ký tự là chữ cái hoặc ký tự tiếng Việt có dấu, ký tự số, ký tự đặc biệt
        if (genreDto.length() > 1000) {
            errors.rejectValue("genre", "genre.length");
        } else if ((!Pattern.matches("^[\\p{L}]++(,[\\p{L}]++)*$", genreDto))) {
            errors.rejectValue("genre", "genre.char");
        }

    }
}
