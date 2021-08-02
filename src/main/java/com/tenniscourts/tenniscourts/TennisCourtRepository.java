package com.tenniscourts.tenniscourts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Tennis court repository.
 */
public interface TennisCourtRepository extends JpaRepository<TennisCourt, Long> {
}
