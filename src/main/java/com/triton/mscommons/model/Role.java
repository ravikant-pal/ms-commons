package com.triton.mscommons.model;

import com.google.common.collect.Sets;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Builder
@Document("role")
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseModel {

    @Id
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @DBRef
    private Set<Permission> permissions;
}
