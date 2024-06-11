package com.surikat.docs.documentprocessor.common.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UploadDocumentResponse {

    @JsonProperty("document_id")
    private UUID documentId;
    @JsonProperty("document_name")
    private String documentName;

    public String getDocumentName() {
        return documentName;
    }

    public UploadDocumentResponse withDocumentName(String documentName) {
        this.documentName = documentName;
        return this;
    }

    public UUID getDocumentId() {
        return documentId;
    }

    public UploadDocumentResponse withDocumentId(UUID documentId) {
        this.documentId = documentId;
        return this;
    }

    @Override
    public String toString() {
        return "UploadDocumentResponse{" +
                "fileName='" + documentName + '\'' +
                ", id=" + documentId +
                '}';
    }
}
