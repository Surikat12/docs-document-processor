package com.surikat.docs.documentprocessor.service.controller;

import com.surikat.docs.common.controller.AbstractApiController;
import com.surikat.docs.common.exception.StorageException;
import com.surikat.docs.documentprocessor.common.model.DocumentType;
import com.surikat.docs.documentprocessor.common.model.response.UploadDocumentResponse;
import com.surikat.docs.documentprocessor.service.service.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.surikat.docs.documentprocessor.common.MethodConst.POST_DOCUMENT;

@RestController
@RequestMapping("/v1")
@Tag(name = "DocumentV1Controller", description = "Контроллер для работы с документами")
public class DocumentV1Controller extends AbstractApiController {

    private final DocumentService documentsService;

    public DocumentV1Controller(DocumentService documentsService) {
        this.documentsService = documentsService;
    }

    @Operation(description = "Загрузить файл")
    @PostMapping(path = POST_DOCUMENT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UploadDocumentResponse uploadDocument(@RequestParam("name") String name,
                                                 @RequestParam("type") DocumentType type,
                                                 @RequestParam("document") MultipartFile file) throws StorageException {
        return documentsService.store(name, type, file);
    }
}
