package org.example.kidway.controller;


import org.example.kidway.Entity.Organization;
import org.example.kidway.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления организациями
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
    public ResponseEntity<List<Organization>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    /**
     * Получить организацию по ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Organization> getOrganizationById(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.getOrganizationById(id));
    }

    /**
     * Создать новую организацию
     */
    @PostMapping
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.createOrganization(organization));
    }

    /**
     * Обновить организацию по ID
     */
    @PutMapping("/{id}")
    public ResponseEntity<Organization> updateOrganization(
            @PathVariable Long id,
            @RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.updateOrganization(id, organization));
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
