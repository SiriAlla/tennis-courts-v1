package com.tenniscourts.schedules;

import com.tenniscourts.exceptions.EntityNotFoundException;
import com.tenniscourts.tenniscourts.TennisCourt;
import com.tenniscourts.tenniscourts.TennisCourtRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Schedule service.
 */
@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final ScheduleMapper scheduleMapper;

    private final TennisCourtRepository tennisCourtRepository;

    /**
     * Add schedule schedule dto.
     *
     * @param tennisCourtId            the tennis court id
     * @param createScheduleRequestDTO the create schedule request dto
     * @return the schedule dto
     */
    public ScheduleDTO addSchedule(Long tennisCourtId, CreateScheduleRequestDTO createScheduleRequestDTO) {

        TennisCourt court = tennisCourtRepository.findById(tennisCourtId).orElseThrow(() -> {
            throw new EntityNotFoundException("Tennis Court not found.");
        });

        Schedule schedule = Schedule.builder()
                .tennisCourt(court)
                .startDateTime(createScheduleRequestDTO.getStartDateTime())
                .endDateTime(createScheduleRequestDTO.getStartDateTime().plusHours(1L))
                .build();

        return scheduleMapper.map(this.scheduleRepository.saveAndFlush(schedule));
    }

    /**
     * Find schedules by dates list.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the list
     */
    public List<ScheduleDTO> findSchedulesByDates(LocalDateTime startDate, LocalDateTime endDate) {
        return scheduleMapper.map(scheduleRepository.findSchedulesBetweenDates(startDate, endDate));
    }

    /**
     * Find schedule schedule dto.
     *
     * @param scheduleId the schedule id
     * @return the schedule dto
     */
    public ScheduleDTO findSchedule(Long scheduleId) {
        return scheduleMapper.map(scheduleRepository.findById(scheduleId)
                                                    .orElseThrow(() -> {
                                                        throw new EntityNotFoundException("Schedule not found.");
                                                    }));
    }

    /**
     * Find schedules by tennis court id list.
     *
     * @param tennisCourtId the tennis court id
     * @return the list
     */
    public List<ScheduleDTO> findSchedulesByTennisCourtId(Long tennisCourtId) {
        return scheduleMapper.map(scheduleRepository.findByTennisCourt_IdOrderByStartDateTime(tennisCourtId));
    }
}
