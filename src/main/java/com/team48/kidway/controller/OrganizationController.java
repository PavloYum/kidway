package com.team48.kidway.controller;

import com.team48.kidway.dto.OrganizationDTO;
import com.team48.kidway.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public ResponseEntity<OrganizationDTO> createOrganization(@RequestBody OrganizationDTO organizationDTO) {
        OrganizationDTO newOrganization = organizationService.createOrganization(organizationDTO);
        return ResponseEntity.ok(newOrganization);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDTO> getOrganizationById(@PathVariable Long id) {
        OrganizationDTO organization = organizationService.findById(id);
        return ResponseEntity.ok(organization);
    }
}