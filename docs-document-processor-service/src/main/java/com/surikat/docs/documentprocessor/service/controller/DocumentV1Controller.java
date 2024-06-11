package com.surikat.docs.documentprocessor.service.controller;

import com.surikat.docs.common.controller.AbstractApiController;
import com.surikat.docs.documentprocessor.common.model.DocumentType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

import static com.surikat.docs.documentprocessor.common.MethodConst.POST_DOCUMENT;

@RestController
@RequestMapping("/v1")
@Tag(name = "DocumentV1Controller", description = "Контроллер для работы с документами")
public class DocumentV1Controller extends AbstractApiController {

    @Operation(description = "Загрузить файл")
    @PostMapping(path = POST_DOCUMENT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UUID uploadDocument(
            @RequestParam("name") String name,
            @RequestParam("type") DocumentType type,
            @RequestParam("document") MultipartFile file) {
        // TODO: сохранение файла
        return UUID.randomUUID();
    }
}
