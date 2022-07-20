package com.management.claim.service;

import com.management.claim.model.Claim;
import com.management.claim.model.FileEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileEntity storeFile(MultipartFile file, Long id);
    FileEntity getFile(String fileId);
}
