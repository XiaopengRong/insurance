package com.management.claim.service;

import com.management.claim.model.Claim;

import java.util.List;

public interface ClaimManagementService {
	Claim saveClaim(Claim claim);
	List<Claim> getAllClaims();
}
