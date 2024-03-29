package com.digitalworlds.api6.base.repositories;

import com.digitalworlds.api6.base.entities.MuseoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iMuseoRepository extends JpaRepository<MuseoEntity, Long> {
}
