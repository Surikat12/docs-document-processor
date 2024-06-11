package com.surikat.docs.documentprocessor.service.service;

import com.surikat.docs.common.exception.StorageException;
import com.surikat.docs.documentprocessor.service.configuration.FileSystemStorageProperties;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    public FileSystemStorageService(FileSystemStorageProperties properties) throws StorageException {

        if(Strings.isEmpty(properties.getLocation())){
            throw new StorageException("File upload location can not be empty.");
        }

        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void store(String name, MultipartFile file) throws StorageException {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file");
            }
            Path destinationFile = rootLocation.resolve(Paths.get(name)).normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(rootLocation.toAbsolutePath())) {
                throw new StorageException("Cannot store file outside current directory");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (StorageException e) {
            throw e;
        }
        catch (Exception e) {
            throw new StorageException("Failed to store file", e);
        }
    }
}
