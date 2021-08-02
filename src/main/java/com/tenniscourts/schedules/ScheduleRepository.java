package com.tenniscourts.schedules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The interface Schedule repository.
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    /**
     * Find by tennis court id order by start date time list.
     *
     * @param id the id
     * @return the list
     */
    List<Schedule> findByTennisCourt_IdOrderByStartDateTime(Long id);

    /**
     * Find first by id schedule.
     *
     * @param scheduleId the schedule id
     * @return the schedule
     */
    Schedule findFirstById(Long scheduleId);

    /**
     * Find schedules between dates list.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the list
     */
    @Query("SELECT s FROM Schedule s WHERE s.startDateTime > (:startDate) AND s.endDateTime < (:endDate)")
    List<Schedule> findSchedulesBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
}