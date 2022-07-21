package com.management.claim.service;

import com.management.claim.model.Claim;

import java.util.List;
import java.util.Optional;

public interface ClaimManagementService {
	Claim saveClaim(Claim claim);
	List<Claim> getAllClaims();
	Optional<Claim> getClaim(Long id);
}
