package org.example.kidway.controller;


import org.example.kidway.dto.OrganizationDTO;
import org.example.kidway.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления организациями через DTO.
 */
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    /**
     * Получить список всех организаций
     */
    @GetMapping
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    /**
     * Получить организацию по ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDTO> getOrganizationById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.getOrganizationById(id));
    }

    /**
     * Создать новую организацию
     */
    @PostMapping
    public ResponseEntity<OrganizationDTO> createOrganization(@RequestBody OrganizationDTO organizationDTO) {
        return ResponseEntity.ok(organizationService.createOrganization(organizationDTO));
    }

    /**
     * Обновить организацию по ID
     */
    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDTO> updateOrganization(
            @PathVariable Long id,
            @RequestBody OrganizationDTO organizationDTO) {
        return ResponseEntity.ok(organizationService.updateOrganization(id, organizationDTO));
    }

    /**
     * Удалить организацию по ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }
}
