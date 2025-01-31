package com.casdeveloper.core.repository;

import com.casdeveloper.core.entity.Registration;
import com.casdeveloper.core.entity.RegistrationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, RegistrationId> {
}
