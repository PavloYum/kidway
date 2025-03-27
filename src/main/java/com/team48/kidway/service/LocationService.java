package com.team48.kidway.service;

import com.team48.kidway.dto.LocationDTO;
import com.team48.kidway.model.Location;
import com.team48.kidway.model.Organization;
import com.team48.kidway.repository.LocationRepository;
import com.team48.kidway.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    public LocationDTO createLocation(LocationDTO locationDTO) {
        Location location = new Location();

        // Находим организацию по ID
        Organization organization = organizationRepository.findById(locationDTO.getOrganizationId())
                .orElseThrow(() -> new RuntimeException("Организация не найдена"));
        location.setOrganization(organization);

        Location savedLocation = locationRepository.save(location);
        return mapToDTO(savedLocation);
    }

    private LocationDTO mapToDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(location.getId());
        locationDTO.setOrganizationId(location.getOrganization() != null ? location.getOrganization().getId() : null);
        return locationDTO;
    }
}