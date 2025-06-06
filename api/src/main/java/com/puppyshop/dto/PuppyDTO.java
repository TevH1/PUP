package com.puppyshop.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record PuppyDTO(
        @NotBlank String name,
        @NotBlank String breed,
        @Positive BigDecimal priceUsd,
        @PastOrPresent LocalDate birthDate,
        @Pattern(regexp="MALE|FEMALE") String sex
) {}

