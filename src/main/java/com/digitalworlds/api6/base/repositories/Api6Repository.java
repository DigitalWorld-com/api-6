package com.digitalworlds.api6.base.repositories;

import com.digitalworlds.api6.base.entities.MuseoEntity;
import com.digitalworlds.api6.base.models.MuseoResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Api6Repository extends JpaRepository<MuseoEntity,Long> {
    static void saveAll(List<MuseoResultDTO> museos) {
    }
}
