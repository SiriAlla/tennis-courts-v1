package com.tenniscourts.schedules;

import org.mapstruct.Mapper;

import java.util.List;

/**
 * The interface Schedule mapper.
 */
@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    /**
     * Map schedule.
     *
     * @param source the source
     * @return the schedule
     */
    Schedule map(ScheduleDTO source);

    /**
     * Map schedule dto.
     *
     * @param source the source
     * @return the schedule dto
     */
    ScheduleDTO map(Schedule source);

    /**
     * Map list.
     *
     * @param source the source
     * @return the list
     */
    List<ScheduleDTO> map(List<Schedule> source);
}
