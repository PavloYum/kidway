package org.example.kidway.repository;



import org.example.kidway.Entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с организациями
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> findByUserId(Long userId); // Найти организации по владельцу (пользователю)
}
