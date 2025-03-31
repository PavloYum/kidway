package com.team48.kidway.service;

import com.team48.kidway.dto.OrganizationDTO;
import com.team48.kidway.model.Organization;
import com.team48.kidway.model.User;
import com.team48.kidway.repository.OrganizationRepository;
import com.team48.kidway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    public List<OrganizationDTO> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending()); // Пагинация + сортировка по имени
        Page<Organization> organizationPage = organizationRepository.findAll(pageable);
        return organizationPage.getContent().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private OrganizationDTO mapToDTO(Organization organization) {
        return new OrganizationDTO();
    }
}
