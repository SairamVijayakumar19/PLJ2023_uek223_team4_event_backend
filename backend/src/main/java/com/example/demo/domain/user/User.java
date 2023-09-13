package com.example.demo.domain.user;

import com.example.demo.core.generic.AbstractEntity;
import com.example.demo.domain.event.Event;
import com.example.demo.domain.role.Role;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class User extends AbstractEntity {

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @Column(name = "password")
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Set<Role> roles = new HashSet<>();

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "event_users", joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"))
  private List<Event> eventList;

  public User(UUID id, String firstName, String lastName, String email, String password, Set<Role> roles, List<Event> eventList) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.roles = roles;
    this.eventList = eventList;
  }

}
