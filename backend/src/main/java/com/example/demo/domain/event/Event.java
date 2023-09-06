package com.example.demo.domain.event;

import com.example.demo.domain.user.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToMany
    private List<User> guestList;

    @Column
    private String eventName;

    @Column
    private Date date;

    @Column
    private String location;

    public Event() {
    }

    public Event(List<User> guestList, String eventName, Date date, String location) {
        this.guestList = guestList;
        this.eventName = eventName;
        this.date = date;
        this.location = location;
    }
}
