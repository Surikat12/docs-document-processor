package com.surikat.docs.documentprocessor.service.service;

import com.surikat.docs.common.exception.BadArgumentException;
import com.surikat.docs.common.exception.DocsServiceException;
import com.surikat.docs.documentprocessor.common.model.DocumentType;
import com.surikat.docs.documentprocessor.common.model.response.UploadDocumentResponse;
import org.apache.commons.lang3.StringUtils;
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
    public UploadDocumentResponse store(String name, DocumentType type, MultipartFile multipartFile) throws DocsServiceException {

        if (StringUtils.isBlank(name)) {
            throw new BadArgumentException("name must not be blank");
        }
        if (StringUtils.contains(name, '_')) {
            throw new BadArgumentException("name must not contain '_'");
        }
        if (type == null) {
            throw new BadArgumentException("type must not be null");
        }
        if (multipartFile == null) {
            throw new BadArgumentException("document must not be null");
        }

        UUID uuid = UUID.randomUUID();
        name = composeName(name, uuid, type);
        storageService.store(name, multipartFile);
        return new UploadDocumentResponse().withDocumentName(name).withDocumentId(uuid);
    }

    private String composeName(String name, UUID uuid, DocumentType type) {
        return String.format(DOCUMENT_NAME_FORMAT, name, uuid, type.toString().toLowerCase());
    }
}
