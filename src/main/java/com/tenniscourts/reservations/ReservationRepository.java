package com.tenniscourts.reservations;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The interface Reservation repository.
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
