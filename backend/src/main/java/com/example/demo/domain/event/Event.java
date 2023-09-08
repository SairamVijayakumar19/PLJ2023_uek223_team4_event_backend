package com.example.demo.domain.event;

import com.example.demo.core.generic.AbstractEntity;
import com.example.demo.domain.user.User;
import jakarta.persistence.*;
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

    @Column
    private String eventName;

    @Column
    private String date;

    @Column
    private String location;

    public Event() {
    }

    public Event(UUID id , List<User> guestList, String eventName, String date, String location) {
        super(id);
        this.guestList = guestList;
        this.eventName = eventName;
        this.date = date;
        this.location = location;
    }
}
