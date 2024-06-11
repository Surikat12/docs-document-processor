package com.surikat.docs.documentprocessor.service.service;

import com.surikat.docs.common.exception.StorageException;
import com.surikat.docs.documentprocessor.common.model.DocumentType;
import com.surikat.docs.documentprocessor.common.model.response.UploadDocumentResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@Service
public class DocumentServiceImpl implements DocumentService {

    public static final String DOCUMENT_NAME_FORMAT = "%s_%s.%s";
    private final StorageService storageService;

    public DocumentServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public UploadDocumentResponse store(String name, DocumentType type, MultipartFile multipartFile) throws StorageException {
        UUID uuid = UUID.randomUUID();
        name = composeName(name, uuid, type);
        storageService.store(name, multipartFile);
        return new UploadDocumentResponse().withDocumentName(name).withDocumentId(uuid);
    }

    private String composeName(String name, UUID uuid, DocumentType type) {
        return String.format(DOCUMENT_NAME_FORMAT, name, uuid, type.toString().toLowerCase());
    }
}
