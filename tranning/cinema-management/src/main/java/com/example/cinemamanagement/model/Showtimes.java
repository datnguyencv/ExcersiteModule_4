package com.example.cinemamanagement.model;

import javax.persistence.*;

@Entity
public class Showtimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private String dateStream;
    private Integer quantityTicket;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movies;

    public Showtimes() {
    }

    public Showtimes(Integer id, String code, String name, String dateStream, Integer quantityTicket, Movie movies) {
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
}
