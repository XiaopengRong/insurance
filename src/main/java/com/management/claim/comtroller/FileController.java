package com.management.claim.comtroller;

import com.management.claim.model.FileEntity;
import com.management.claim.payload.UploadFileResponse;
import com.management.claim.service.FileService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import java.util.logging.Logger;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FileController {

    private final FileService fileService;
    
    
    @PostMapping("/uploadFile/{id}")
    public UploadFileResponse uploadFile(@PathVariable(value = "id") Long id, @RequestParam("file") MultipartFile file) {
    	
        FileEntity fileEntity = fileService.storeFile(file, id);
        
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileEntity.getFileId())
                .toUriString();
 
        return new UploadFileResponse(fileEntity.getName(), fileDownloadUri,
                file.getContentType(),fileEntity.getDIR_location(), file.getSize());
    }

//    @GetMapping("/downloadFile/{id}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
//        // Load file from database
//        FileEntity fileEntity = fileService.getFile(fileId);
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(fileEntity.getType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
//               ;
//    }
}
