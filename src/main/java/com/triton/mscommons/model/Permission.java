package com.triton.mscommons.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("permission")
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseModel {
    @Id
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
