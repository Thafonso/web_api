package org.github.thafonso.project_api_springboot.web.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record ProductRequest(@NotBlank @Size(max = 20) String productName, @NotNull @DecimalMin(value = "0.00") Long productPrice, @NotNull String category) {

}
