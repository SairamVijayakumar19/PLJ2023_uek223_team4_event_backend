package com.example.demo.domain.user;

import com.example.demo.core.generic.AbstractRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.event.Event;
import com.example.demo.domain.user.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<User> {
  Optional<User> findByEmail(String email);

  List<User> findByEventList_Id(UUID eventId);

}
