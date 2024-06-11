package com.surikat.docs.documentprocessor.service.service;

import com.surikat.docs.common.exception.StorageException;
import com.surikat.docs.documentprocessor.common.model.DocumentType;
import com.surikat.docs.documentprocessor.common.model.response.UploadDocumentResponse;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

    UploadDocumentResponse store(String name, DocumentType type, MultipartFile multipartFile) throws StorageException;
}
