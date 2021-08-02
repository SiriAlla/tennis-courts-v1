package com.tenniscourts.config;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.annotations.ApiIgnore;

import java.net.URI;

/**
 * The type Base rest controller.
 */
@ApiIgnore
public class BaseRestController {

    /**
     * Location by entity uri.
     *
     * @param entityId the entity id
     * @return the uri
     */
    protected URI locationByEntity(Long entityId){
        return ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(entityId).toUri();
    }
}
