package com.epam.spring.homework3.dto;

import com.epam.spring.homework3.validation.EmailConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserDto {

    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @EmailConstraint
    private String email;

    @NotEmpty
    @Length(min = 6,max = 30)
    private String password;

    private boolean isAdmin;

    private List<TicketDto> tickets;
}
