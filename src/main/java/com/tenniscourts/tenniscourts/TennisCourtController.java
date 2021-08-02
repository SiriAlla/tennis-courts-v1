package com.tenniscourts.tenniscourts;

import com.tenniscourts.config.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * The type Tennis court controller.
 */
@Api("Tennis Court")
@AllArgsConstructor
@RestController
@RequestMapping("/tennis-court")
public class TennisCourtController extends BaseRestController {

    private final TennisCourtService tennisCourtService;

    /**
     * Add tennis court response entity.
     *
     * @param tennisCourtDTO the tennis court dto
     * @return the response entity
     */
    @PostMapping(value = "/add")
    @ApiOperation(value="Add Tennis Court")
    @ApiResponse(code = 201, message = "Tennis Court created")
    public ResponseEntity<Void> addTennisCourt(@Valid TennisCourtDTO tennisCourtDTO) {
        return ResponseEntity.created(locationByEntity(tennisCourtService.addTennisCourt(tennisCourtDTO).getId())).build();
    }

    /**
     * Find tennis court by id response entity.
     *
     * @param tennisCourtId the tennis court id
     * @return the response entity
     */
    @GetMapping(value = "/find/{tennisCourtId}")
    @ApiOperation(value="Find Tennis Court by ID")
    @ApiResponse(code = 200, message = "Tennis Court found")
    public ResponseEntity<TennisCourtDTO> findTennisCourtById(@PathVariable("tennisCourtId") Long tennisCourtId) {
        return ResponseEntity.ok(tennisCourtService.findTennisCourtById(tennisCourtId));
    }

    /**
     * Find tennis court with schedules by id response entity.
     *
     * @param tennisCourtId the tennis court id
     * @return the response entity
     */
    @GetMapping(value = "/find-with-schedule/{tennisCourtId}")
    @ApiOperation(value="Find with schedule")
    @ApiResponse(code = 200, message = "Tennis Court with schedule found")
    public ResponseEntity<TennisCourtDTO> findTennisCourtWithSchedulesById(@PathVariable("tennisCourtId") Long tennisCourtId) {
        return ResponseEntity.ok(tennisCourtService.findTennisCourtWithSchedulesById(tennisCourtId));
    }
}
