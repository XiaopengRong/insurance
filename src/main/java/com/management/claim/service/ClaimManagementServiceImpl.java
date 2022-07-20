package com.management.claim.service;


import com.management.claim.comtroller.ClaimManagementController;
import org.springframework.stereotype.Service;

import com.management.claim.model.Claim;
import com.management.claim.repository.ClaimManagementRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ClaimManagementServiceImpl implements ClaimManagementService{
	private final ClaimManagementRepository claimRepository;

	Logger logger = Logger.getLogger(ClaimManagementController.class.getName());

	@Override
	public Claim saveClaim(Claim claim) {
		claimRepository.save(claim);
		logger.info("Claim Saved.");
		return claim;
	}

	@Override
	public List<Claim> getAllClaims() {
		return claimRepository.findAll();
	}
}
