package com.coding.todoapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" ,referencedColumnName = "user_id")
    private User user;



    public Todo(int id, String title, Date schedule, User user) {
        this.id = id;
        this.title = title;
        this.schedule = schedule;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getSchedule() {
        return schedule;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", schedule=" + schedule +
                ", user=" + user +
                '}';
    }
    public Todo(){

    }
}
