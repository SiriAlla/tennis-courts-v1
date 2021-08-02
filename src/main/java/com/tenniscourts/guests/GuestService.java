package com.tenniscourts.guests;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.tenniscourts.exceptions.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Guest service.
 */
@Service
@AllArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    private final GuestMapper guestMapper;

    /**
     * Add guest guest dto.
     *
     * @param guest the guest
     * @return the guest dto
     */
    public GuestDTO addGuest(GuestDTO guest) {
        if(guestRepository.findById(guest.getId()).stream().map(guestMapper::map).collect(Collectors.toList()).isEmpty()) {
            return guestMapper.map(guestRepository.saveAndFlush(guestMapper.map(guest)));
        }
        else {
            return findGuestById(guest.getId());
        }
    }

    /**
     * Find guest by id guest dto.
     *
     * @param guestId the guest id
     * @return the guest dto
     */
    public GuestDTO findGuestById(Long guestId) {
        return guestMapper.map(guestRepository.findById(guestId).orElseThrow(() -> new EntityNotFoundException("Guest was not found.")));
    }

    /**
     * Find all guests list.
     *
     * @return the list
     */
    public List<GuestDTO> findAllGuests() {
        return guestRepository.findAll().stream().map(guestMapper::map).collect(Collectors.toList());
    }

    /**
     * Find guest by name list.
     *
     * @param name the name
     * @return the list
     */
    public List<GuestDTO> findGuestByName(String name) {
        return guestRepository.findByName(name).stream().map(guestMapper::map).collect(Collectors.toList());
    }

    /**
     * Update guest guest dto.
     *
     * @param guestDTO the guest dto
     * @return the guest dto
     */
    public GuestDTO updateGuest(GuestDTO guestDTO) {
        return guestMapper.map(guestRepository.findById(guestDTO.getId())
                                              .map(guest -> {
                                                guest.setName(guestDTO.getName());
                                                    return guestRepository.save(guest);
                                                })
                                              .orElseThrow(() -> new EntityNotFoundException("Guest was not found.")));
    }

    /**
     * Delete guest by id.
     *
     * @param guestId the guest id
     */
    public void deleteGuestById(Long guestId) {
         Guest guest = guestRepository.findById(guestId)
                        .orElseThrow(() -> new EntityNotFoundException("Guest was not found."));

         guestRepository.delete(guest);
    }
}
