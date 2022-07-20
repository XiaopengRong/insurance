package com.management.claim.exception;

import java.util.NoSuchElementException;

public class ClaimNotFoundException extends NoSuchElementException{
	private final Long ClaimId;

    public ClaimNotFoundException(Long ClaimId) {
        super("No Claim record for id = " + ClaimId);
        this.ClaimId = ClaimId;
    }

}
