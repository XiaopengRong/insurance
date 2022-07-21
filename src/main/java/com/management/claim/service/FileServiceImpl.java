package com.management.claim.service;

import com.management.claim.exception.FileStorageException;
import com.management.claim.exception.MyFileNotFoundException;
import com.management.claim.model.Claim;
import com.management.claim.model.FileEntity;
import com.management.claim.repository.ClaimManagementRepository;
import com.management.claim.repository.FileRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {


    private final FileRepository fileRepository;
    
    private final ClaimManagementRepository claimManagementRepository;
    
    private final String UPLOAD_DIR = "C:\\Users\\74189\\Downloads\\claim-dev\\claim\\src\\main\\java\\uploads\\";
    
    @Override
    public FileEntity storeFile(MultipartFile file, Long id) {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {

            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
            Claim claim = claimManagementRepository.findById(id).
            		orElseThrow(() -> new MyFileNotFoundException("File not found with id " + id));
            
//            FileEntity fileEntity = new FileEntity(fileName, file.getContentType(), file.getBytes(), claim);
            
       
  
           Path path = Paths.get(UPLOAD_DIR + fileName);
           Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
           
           FileEntity fileEntity = FileEntity.builder()
           		.name(fileName).type(file.getContentType()).DIR_location(file.getOriginalFilename()).claim(claim)
           		.build();
      
            return fileRepository.save(fileEntity);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    @Override
    public FileEntity getFile(String fileId) {
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
