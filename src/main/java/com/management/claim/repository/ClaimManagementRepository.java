package com.management.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.claim.model.Claim;

//import java.util.List;

@Repository
public interface ClaimManagementRepository extends JpaRepository<Claim, Long> {
//	List<ClaimManagementRepository> findByTitleContaining(String title);
}
