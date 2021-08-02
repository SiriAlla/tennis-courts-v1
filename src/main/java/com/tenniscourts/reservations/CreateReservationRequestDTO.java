package com.tenniscourts.reservations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * The type Create reservation request dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class CreateReservationRequestDTO {

    @NotNull
    private Long guestId;

    @NotNull
    private Long scheduleId;

}
