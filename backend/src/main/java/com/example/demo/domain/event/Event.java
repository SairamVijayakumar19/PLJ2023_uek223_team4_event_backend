package com.example.demo.domain.event;

import com.example.demo.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer id;

    @ManyToMany
    @JoinTable(name = "event_users",
            joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"))
    private List<User> guestList;

    @Column
    private String eventName;

    @Column
    private String date;

    @Column
    private String location;

    public Event() {
    }

    public Event(List<User> guestList, String eventName, String date, String location) {
        this.guestList = guestList;
        this.eventName = eventName;
        this.date = date;
        this.location = location;
    }
}
