package com.example.soccer.dto;

import com.example.soccer.model.Teams;
import com.example.utils.annotation.YearOldValid;

import javax.validation.constraints.*;

public class SoccerPlayerDTO {
    private Integer id;
    @NotBlank
    @Pattern(regexp = "^\\d{3}$")
    private String code;
    @Size(min = 5, max = 100, message = "Only from 5 to 100 characters")
    @NotBlank(message = "Enter Name please")
    @Pattern(regexp = "^[\\p{Lu}][\\p{Ll}]*([\\s][\\p{Lu}][\\p{Ll}]*)*$", message = "Name Player need format. Ex: Nguyen Van A, Nguyễn Văn A")
    private String name;
    @YearOldValid
    private String dateOfBirth;
    @Min(value = 1, message = "Only positive integer greater than 0")
    @NotNull(message = "Please enter experience. Ex: 10")
    private Integer experience;
    @Size(max = 45)
    @NotBlank(message = "Please enter position")
    @Pattern(regexp ="^(Tiền Đạo|Tiền Vệ|Hậu Vệ|Trung Vệ|Thủ Môn)$", message = "Name only format. Ex:Tiền Đạo|Tiền Vệ|Hậu Vệ|Trung Vệ or Thủ Môn)")
    private String position;
    @NotBlank(message = "Please enter Avatar Url")
    private String urlImg;
    private Teams teams;
    private boolean status;

    public SoccerPlayerDTO() {
    }

    public SoccerPlayerDTO(Integer id, String code, String name, String dateOfBirth, Integer experience, String position, String urlImg, Teams teams, boolean status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.position = position;
        this.urlImg = urlImg;
        this.teams = teams;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }
}
