package com.tenniscourts.reservations;

import com.tenniscourts.config.BaseRestController;
import com.tenniscourts.guests.GuestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Reservation controller.
 */
@Api("Reservation")
@AllArgsConstructor
@RestController
@RequestMapping("/reservation")
public class ReservationController extends BaseRestController {

    private final ReservationService reservationService;

    /**
     * Book reservation response entity.
     *
     * @param createReservationRequestDTO the create reservation request dto
     * @return the response entity
     */
    @PostMapping(value = "/book")
    @ApiOperation(value="Book a Reservation")
    @ApiResponse(code = 201, message = "Reservation created")
    public ResponseEntity<Void> bookReservation(@Valid @RequestBody CreateReservationRequestDTO createReservationRequestDTO) {
        return ResponseEntity.created(locationByEntity(reservationService.bookReservation(createReservationRequestDTO).getId())).build();
    }

    /**
     * Find reservation response entity.
     *
     * @param reservationId the reservation id
     * @return the response entity
     */
    @GetMapping(value = "/find/{reservationId}")
    @ApiOperation(value="Find a Reservation by ID")
    @ApiResponse(code = 200, message = "Reservation found")
    public ResponseEntity<ReservationDTO> findReservation(@PathVariable("reservationId") Long reservationId) {
        return ResponseEntity.ok(reservationService.findReservation(reservationId));
    }

    /**
     * Cancel reservation response entity.
     *
     * @param reservationId the reservation id
     * @return the response entity
     */
    @PutMapping(value = "/cancel/{reservationId}")
    @ApiOperation(value="Cancel a Reservation")
    @ApiResponse(code = 200, message = "Reservation cancelled")
    public ResponseEntity<ReservationDTO> cancelReservation(@PathVariable("reservationId") Long reservationId) {
        return ResponseEntity.ok(reservationService.cancelReservation(reservationId));
    }

    /**
     * Reschedule reservation response entity.
     *
     * @param reservationId the reservation id
     * @param scheduleId    the schedule id
     * @return the response entity
     */
    @PutMapping(value = "/reschedule/{reservationId}", params = {"scheduleId"})
    @ApiOperation(value="Reschedule a Reservation")
    @ApiResponse(code = 200, message = "Reservation cancelled")
    public ResponseEntity<ReservationDTO> rescheduleReservation(@PathVariable("reservationId") Long reservationId, Long scheduleId) {
        return ResponseEntity.ok(reservationService.rescheduleReservation(reservationId, scheduleId));
    }

    /**
     * Find all reservations response entity.
     *
     * @return the response entity
     */
    @GetMapping(value = "/history")
    @ApiOperation(value="See history of all previous Reservations")
    @ApiResponse(code = 200, message = "Reservation(s) found")
    public ResponseEntity<List<ReservationDTO>> findAllReservations() {
        return ResponseEntity.ok(reservationService.findAllReservations());
    }
}
