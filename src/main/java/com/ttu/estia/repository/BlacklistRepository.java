package com.ttu.estia.repository;

import com.ttu.estia.entity.BlacklistedSite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistRepository extends JpaRepository<BlacklistedSite, Integer> {
}
