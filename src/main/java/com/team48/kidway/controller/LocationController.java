package com.team48.kidway.controller;

import com.team48.kidway.dto.LocationDTO;
import com.team48.kidway.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO) {
        LocationDTO newLocation = locationService.createLocation(locationDTO);
        return ResponseEntity.ok(newLocation);
    }
}