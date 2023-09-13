package com.example.demo.domain.event.dto;

import com.example.demo.core.generic.AbstractDTO;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.dto.UserDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class EventDTO extends AbstractDTO {
    private UUID id;
    private List<UserDTO> guestList;
    @NotNull
    private String eventName;
    @NotNull
    private String date;
    @NotNull
    private String location;
    private User author;
}
