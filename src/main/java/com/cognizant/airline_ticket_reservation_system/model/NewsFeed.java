package com.cognizant.airline_ticket_reservation_system.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class NewsFeed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "{error.newsFeed.date}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    @NotBlank(message = "{error.newsFeed.news}")
    private String news;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "NewsFeed{" +
                "id=" + id +
                ", date=" + date +
                ", news='" + news + '\'' +
                '}';
    }
}
