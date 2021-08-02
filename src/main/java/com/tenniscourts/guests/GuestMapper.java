package com.tenniscourts.guests;

import com.tenniscourts.reservations.CreateReservationRequestDTO;
import com.tenniscourts.reservations.Reservation;
import com.tenniscourts.reservations.ReservationDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface Guest mapper.
 */
@Mapper(componentModel = "spring")
public interface GuestMapper {

    /**
     * Map guest.
     *
     * @param source the source
     * @return the guest
     */
    Guest map(GuestDTO source);

    /**
     * Map guest dto.
     *
     * @param source the source
     * @return the guest dto
     */
    @InheritInverseConfiguration
    GuestDTO map(Guest source);
}
