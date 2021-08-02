package com.tenniscourts.guests;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * The type Guest dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class GuestDTO {

    private Long id;

    @NotBlank
    private String name;
}