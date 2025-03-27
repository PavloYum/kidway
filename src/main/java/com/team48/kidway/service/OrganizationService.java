package com.team48.kidway.service;

import com.team48.kidway.dto.OrganizationDTO;
import com.team48.kidway.model.Organization;
import com.team48.kidway.model.User;
import com.team48.kidway.repository.OrganizationRepository;
import com.team48.kidway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private UserRepository userRepository;

    public OrganizationDTO createOrganization(OrganizationDTO organizationDTO) {
        Organization organization = new Organization();
        organization.setName(organizationDTO.getName());
        organization.setDescription(organizationDTO.getDescription());
        organization.setLat(organizationDTO.getLat());
        organization.setLongi(organizationDTO.getLongi());
        organization.setPhoto(organizationDTO.getPhoto());

        // Находим пользователя по ID
        User user = userRepository.findById(organizationDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        organization.setUser(user);

        Organization savedOrganization = organizationRepository.save(organization);
        return mapToDTO(savedOrganization);
    }

    public OrganizationDTO findById(Long id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Организация не найдена"));
        return mapToDTO(organization);
    }

    private OrganizationDTO mapToDTO(Organization organization) {
        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setId(organization.getId());
        organizationDTO.setName(organization.getName());
        organizationDTO.setDescription(organization.getDescription());
        organizationDTO.setLat(organization.getLat());
        organizationDTO.setLongi(organization.getLongi());
        organizationDTO.setPhoto(organization.getPhoto());
        organizationDTO.setUserId(organization.getUser() != null ? organization.getUser().getId() : null);
        return organizationDTO;
    }
}