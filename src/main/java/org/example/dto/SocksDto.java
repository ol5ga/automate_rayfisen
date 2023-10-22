package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SocksDto {
    @NotBlank
    String color;
    @Size(min = 0, max = 100)
    int cottonPart;
    @Positive
    int quantity;
}
