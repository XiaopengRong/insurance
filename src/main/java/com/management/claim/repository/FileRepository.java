package com.management.claim.repository;

import com.management.claim.model.FileEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, String> {
	List<FileEntity> findByClaimId(Long claimId);
}
