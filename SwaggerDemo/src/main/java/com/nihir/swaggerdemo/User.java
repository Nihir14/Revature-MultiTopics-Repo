package com.nihir.swaggerdemo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "User model")
public class User {

    @Schema(description = "User id", example = "1")
    private Long id;

    @NotBlank
    @Size(min = 3, max = 20)
    @Schema(description = "user name", example = "Nihir")
    private String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
