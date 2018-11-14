package com.woodystudio.api.repository;

import com.woodystudio.api.entity.Butterfly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ButterflyRepository extends JpaRepository<Butterfly, Long> {
}
