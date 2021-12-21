package htp.by.ramanouski.filesystem.service.implementation;

import htp.by.ramanouski.filesystem.base.IntegrationBaseTest;
import htp.by.ramanouski.filesystem.service.FileService;
import htp.by.ramanouski.filesystem.service.exception.ServiceException;
import htp.by.ramanouski.filesystem.shared.FileDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Sql("/sql/file_data.sql")
class FileServiceImplTest extends IntegrationBaseTest {

    private static final String FILE_ID = "oLDGRaCLtlY3QDkVdyLnfqh9sn87c1";
    public static final String FAKE_FILE_ID = "dsdkvmwobvrnqib";
    private static final String COMPANY_NAME = "Microsoft";
    public static final int PAGE = 0;

    @Autowired
    private FileService fileService;

    @Test
    void findAllFiles(){
        List<FileDto> entities = fileService.findAll(PAGE);
        assertFalse(entities.isEmpty());
    }

    @Test
    void deleteFileByFileId(){
        FileDto fileDto = fileService.deleteFileByFileId(FILE_ID);
        assertNotNull(fileDto);
    }
    @Test
    void deleteFieldByFieldId_ThrowsFileServiceException(){
        assertThrows(ServiceException.class,
                () ->  fileService.deleteFileByFileId(FAKE_FILE_ID));
    }

    @Test
    void findFileByFileId() {
        FileDto fileDto = fileService.findFileByFileId(FILE_ID);
        assertNotNull(fileDto);
    }
    @Test
    void findFileByFileId_ThrowsFileServiceException(){
        assertThrows(ServiceException.class,
                () ->  fileService.findFileByFileId(FAKE_FILE_ID));
    }
    @Test
    void findFileByFileIdAndCheckTheCompanyName() {
        FileDto fileDto = fileService.findFileByFileId(FILE_ID);
        assertEquals(COMPANY_NAME,fileDto.getCompanyName());
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

}