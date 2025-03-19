package org.example.kidway.service;



import org.example.kidway.Entity.Organization;
import org.example.kidway.dto.OrganizationDTO;
import org.example.kidway.exception.ResourceNotFoundException;
import org.example.kidway.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Бизнес-логика для работы с организациями, используя DTO.
 */
@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    /**
     * Получить все организации (DTO)
     */
    public List<OrganizationDTO> getAllOrganizations() {
        return organizationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Получить организацию по ID (DTO)
     */
    public OrganizationDTO getOrganizationById(Long id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Организация не найдена с ID: " + id));
        return convertToDTO(organization);
    }

    /**
     * Создать новую организацию (из DTO)
     */
    public OrganizationDTO createOrganization(OrganizationDTO organizationDTO) {
        Organization organization = convertToEntity(organizationDTO);
        return convertToDTO(organizationRepository.save(organization));
    }

    /**
     * Обновить организацию по ID (из DTO)
     */
    public OrganizationDTO updateOrganization(Long id, OrganizationDTO updatedDTO) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Организация не найдена с ID: " + id));

        organization.setName(updatedDTO.getName());
        organization.setDescription(updatedDTO.getDescription());
        organization.setLat(updatedDTO.getLat());
        organization.setLon(updatedDTO.getLon());
        organization.setPhoto(updatedDTO.getPhoto());

        return convertToDTO(organizationRepository.save(organization));
    }

    /**
     * Удалить организацию по ID
     */
    public void deleteOrganization(Long id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Организация не найдена с ID: " + id));
        organizationRepository.delete(organization);
    }

    /**
     * Преобразовать Entity -> DTO
     */
    private OrganizationDTO convertToDTO(Organization organization) {
        OrganizationDTO dto = new OrganizationDTO();
        dto.setId(organization.getId());
        dto.setName(organization.getName());
        dto.setDescription(organization.getDescription());
        dto.setLat(organization.getLat());
        dto.setLon(organization.getLon());
        dto.setPhoto(organization.getPhoto());
        return dto;
    }

    /**
     * Преобразовать DTO -> Entity
     */
    private Organization convertToEntity(OrganizationDTO dto) {
        Organization organization = new Organization();
        organization.setName(dto.getName());
        organization.setDescription(dto.getDescription());
        organization.setLat(dto.getLat());
        organization.setLon(dto.getLon());
        organization.setPhoto(dto.getPhoto());
        return organization;
    }
}

