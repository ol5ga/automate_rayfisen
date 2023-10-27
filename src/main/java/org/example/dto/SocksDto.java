package org.example.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SocksDto {
    @NotBlank
    String color;
    @Min(value = 0)
    @Max(value = 100)
    @NotNull
    int cottonPart;
    @Positive
    @NotNull
    int quantity;
}
