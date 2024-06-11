package com.surikat.docs.documentprocessor.service.service;

import com.surikat.docs.common.exception.StorageException;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void store(String name, MultipartFile multipartFile) throws StorageException;
}
