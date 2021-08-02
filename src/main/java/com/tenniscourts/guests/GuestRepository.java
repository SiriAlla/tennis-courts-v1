package com.tenniscourts.guests;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Guest repository.
 */
public interface GuestRepository extends JpaRepository<Guest, Long> {

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    List<Guest> findByName(String name);
}
