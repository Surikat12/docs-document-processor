package com.surikat.docs.documentprocessor.common.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UploadDocumentResponse {

    @JsonProperty("file_name")
    private String fileName;
    private UUID id;

    public String getName() {
        return fileName;
    }

    public UploadDocumentResponse withName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public UploadDocumentResponse withProcessId(UUID processId) {
        this.id = processId;
        return this;
    }

    @Override
    public String toString() {
        return "UploadDocumentResponse{" +
                "fileName='" + fileName + '\'' +
                ", id=" + id +
                '}';
    }
}
