package com.tenniscourts.tenniscourts;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * The interface Tennis court mapper.
 */
@Mapper(componentModel = "spring")
public interface TennisCourtMapper {
    /**
     * Map tennis court dto.
     *
     * @param source the source
     * @return the tennis court dto
     */
    TennisCourtDTO map(TennisCourt source);

    /**
     * Map tennis court.
     *
     * @param source the source
     * @return the tennis court
     */
    @InheritInverseConfiguration
    TennisCourt map(TennisCourtDTO source);
}
