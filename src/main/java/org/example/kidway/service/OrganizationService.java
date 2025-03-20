package org.example.kidway.service;


import org.example.kidway.Entity.Organization;
import org.example.kidway.exception.ResourceNotFoundException;
import org.example.kidway.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Бизнес-логика для работы с организациями
 */
@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    /**
     * Получить список всех организаций
     */
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    /**
     * Получить организацию по ID
     */
    public Organization getOrganizationById(Long id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Организация не найдена с ID: " + id));
    }

    /**
     * Создать новую организацию
     */
    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    /**
     * Обновить существующую организацию
     */
    public Organization updateOrganization(Long id, Organization updatedOrganization) {
        Organization organization = getOrganizationById(id);
        organization.setName(updatedOrganization.getName());
        organization.setDescription(updatedOrganization.getDescription());
        organization.setLat(updatedOrganization.getLat());
        organization.setLon(updatedOrganization.getLon());
        organization.setPhoto(updatedOrganization.getPhoto());
        return organizationRepository.save(organization);
    }

    /**
     * Удалить организацию по ID
     */
    public void deleteOrganization(Long id) {
        Organization organization = getOrganizationById(id);
        organizationRepository.delete(organization);
    }
}
