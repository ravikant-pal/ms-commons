package com.triton.mscommons.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseUser extends BaseModel {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @DBRef
    private Set<Role> roles;

}
