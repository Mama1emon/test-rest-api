package com.mama1emon.simplerestapi.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    @NotBlank
    private String name;
    @NotBlank
    private String login;
    @NotBlank
    private String password;

    private Set<RoleDTO> roles;
}
