package com.example.demo.domain.event;

import com.example.demo.core.generic.AbstractEntity;
import com.example.demo.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.AbstractCollection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
public class Event extends AbstractEntity {

    @ManyToMany
    @JoinTable(name = "event_users",
            joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"))
    private List<User> guestList;

    @NotNull
    @Column
    private String eventName;

    @NotNull
    @Column
    private String date;

    @NotNull
    @Column
    private String location;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User author;

    public Event() {
    }

    public Event(UUID id , List<User> guestList, String eventName, String date, String location, User author) {
        super(id);
        this.guestList = guestList;
        this.eventName = eventName;
        this.date = date;
        this.location = location;
        this.author = author;
    }
}
