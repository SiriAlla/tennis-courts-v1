package com.tenniscourts.reservations;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface Reservation mapper.
 */
@Mapper(componentModel = "spring")
public interface ReservationMapper {

    /**
     * Map reservation.
     *
     * @param source the source
     * @return the reservation
     */
    Reservation map(ReservationDTO source);

    /**
     * Map reservation dto.
     *
     * @param source the source
     * @return the reservation dto
     */
    @InheritInverseConfiguration
    ReservationDTO map(Reservation source);

    /**
     * Map reservation.
     *
     * @param source the source
     * @return the reservation
     */
    @Mapping(target = "guest.id", source = "guestId")
    @Mapping(target = "schedule.id", source = "scheduleId")
    Reservation map(CreateReservationRequestDTO source);
}
