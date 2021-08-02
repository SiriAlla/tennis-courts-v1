package com.tenniscourts.tenniscourts;

import com.tenniscourts.exceptions.EntityNotFoundException;
import com.tenniscourts.schedules.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The type Tennis court service.
 */
@Service
@AllArgsConstructor
public class TennisCourtService {

    private final TennisCourtRepository tennisCourtRepository;

    private final ScheduleService scheduleService;

    private final TennisCourtMapper tennisCourtMapper;

    /**
     * Add tennis court tennis court dto.
     *
     * @param tennisCourt the tennis court
     * @return the tennis court dto
     */
    public TennisCourtDTO addTennisCourt(TennisCourtDTO tennisCourt) {
        return tennisCourtMapper.map(tennisCourtRepository.saveAndFlush(tennisCourtMapper.map(tennisCourt)));
    }

    /**
     * Find tennis court by id tennis court dto.
     *
     * @param id the id
     * @return the tennis court dto
     */
    public TennisCourtDTO findTennisCourtById(Long id) {
        return tennisCourtRepository.findById(id).map(tennisCourtMapper::map).orElseThrow(() -> {
            throw new EntityNotFoundException("Tennis Court not found.");
        });
    }

    /**
     * Find tennis court with schedules by id tennis court dto.
     *
     * @param tennisCourtId the tennis court id
     * @return the tennis court dto
     */
    public TennisCourtDTO findTennisCourtWithSchedulesById(Long tennisCourtId) {
        TennisCourtDTO tennisCourtDTO = findTennisCourtById(tennisCourtId);
        tennisCourtDTO.setTennisCourtSchedules(scheduleService.findSchedulesByTennisCourtId(tennisCourtId));
        return tennisCourtDTO;
    }
}
