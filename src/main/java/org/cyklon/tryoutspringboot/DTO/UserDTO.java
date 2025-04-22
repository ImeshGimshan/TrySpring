package org.cyklon.tryoutspringboot.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    private String role;
}
