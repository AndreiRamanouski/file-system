package htp.by.ramanouski.filesystem.service;

import htp.by.ramanouski.filesystem.shared.FileDto;

import java.util.List;

public interface FileService {
    List<FileDto> findAll(int page);

    FileDto findFileByFileId(String fileId);

    FileDto deleteFileByFileId(String fileId);

    FileDto saveFileByUserId(FileDto fileDto, String userId);
}
