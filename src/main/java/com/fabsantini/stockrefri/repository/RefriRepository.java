package com.fabsantini.stockrefri.repository;

import com.fabsantini.stockrefri.entity.Refri;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public class RefriRepository extends JpaRepository<Refri, Long> {

    Optional<Refri> findByName(String name);

}
