package htp.by.ramanouski.filesystem.service.implementation;

import htp.by.ramanouski.filesystem.entity.EmployeeEntity;
import htp.by.ramanouski.filesystem.entity.FileEntity;
import htp.by.ramanouski.filesystem.service.EmployeeService;
import htp.by.ramanouski.filesystem.service.exception.ServiceException;
import htp.by.ramanouski.filesystem.repository.FileRepository;
import htp.by.ramanouski.filesystem.service.FileService;
import htp.by.ramanouski.filesystem.service.util.ServiceUtils;
import htp.by.ramanouski.filesystem.shared.EmployeeDto;
import htp.by.ramanouski.filesystem.shared.FileDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@Slf4j
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;
    private final ServiceUtils serviceUtils;
    private final EmployeeService employeeService;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository, ServiceUtils serviceUtils,
                           EmployeeService employeeService) {
        this.fileRepository = fileRepository;
        this.serviceUtils = serviceUtils;
        this.employeeService = employeeService;
    }


    @Override
    public List<FileDto> findAll(int page) {

        if(page > 0){page--;}

        Pageable pageable = PageRequest.of(page, 10);

        Page<FileEntity> fileEntityPage = fileRepository.findAll(pageable);
        List<FileEntity> entities = fileEntityPage.getContent();
        if (entities == null) {
            throw new ServiceException("Could not find the files");
        }
        Type listType = new TypeToken<List<FileDto>>() {
        }.getType();
        ModelMapper mapper = new ModelMapper();
        List<FileDto> returnedValue = mapper.map(entities, listType);
        return returnedValue;
    }

    @Override
    public FileDto findFileByFileId(String fileId) {
        FileEntity entity = fileRepository.findByFileId(fileId);

        if (entity == null) {
            throw new ServiceException("File was not found");
        }

        ModelMapper mapper = new ModelMapper();
        FileDto returnedValue = mapper.map(entity, FileDto.class);

        return returnedValue;
    }

    @Override
    public FileDto deleteFileByFileId(String fileId) {
        FileEntity entity = fileRepository.findByFileId(fileId);

        if (entity == null) {
            throw new ServiceException("File was not found");
        }

        ModelMapper mapper = new ModelMapper();
        FileDto returnedValue = mapper.map(entity, FileDto.class);

        fileRepository.delete(entity);
        return returnedValue;

    }

    @Override
    public FileDto saveFileByUserId(FileDto fileDto, String userId) {

        EmployeeDto employee = employeeService.findByUserId(userId);

        ModelMapper mapper = new ModelMapper();
        FileEntity fileEntity = mapper.map(fileDto, FileEntity.class);


        fileEntity.setFileId(serviceUtils.generateFileId(30));
        if (employee != null) {
            fileEntity.setEmployeeData(mapper.map(employee,EmployeeEntity.class));
        } else {
            log.warn("There in no such employee: " + userId);
            log.warn("Setting up a default value");
            fileEntity.setEmployeeData(null);
        }

        FileEntity savedFile = fileRepository.save(fileEntity);
        FileDto returnedValue = mapper.map(savedFile, FileDto.class);

        return returnedValue;
    }
}
