package com.example.demo.domain.event.dto;

import com.example.demo.core.generic.AbstractDTO;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.dto.UserDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class EventDTO extends AbstractDTO {
    private UUID id;
    private List<UserDTO> guestList;
    private String eventName;
    private String date;
    private String location;
    private User author;
}
