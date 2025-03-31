package com.team48.kidway.controller;

import com.team48.kidway.dto.OrganizationDTO;
import com.team48.kidway.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public ResponseEntity<OrganizationDTO> createOrganization(@RequestBody OrganizationDTO organizationDTO) {
        OrganizationDTO newOrganization = organizationService.createOrganization(organizationDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newOrganization.getId())
                .toUri();
        return ResponseEntity.created(location).body(newOrganization);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDTO> getOrganizationById(@PathVariable Long id) {
        OrganizationDTO organization = organizationService.findById(id);
        return organization != null ? ResponseEntity.ok(organization) : ResponseEntity.notFound().build();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations(int page, int size) {
        List<OrganizationDTO> organizations = organizationService.findAll(page, size);
        return ResponseEntity.ok(organizations);
    }

}
