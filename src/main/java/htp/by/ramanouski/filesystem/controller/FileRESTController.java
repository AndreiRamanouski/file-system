package htp.by.ramanouski.filesystem.controller;

import htp.by.ramanouski.filesystem.controller.exception.ControllerException;
import htp.by.ramanouski.filesystem.service.EmployeeService;
import htp.by.ramanouski.filesystem.service.FileService;
import htp.by.ramanouski.filesystem.shared.EmployeeDto;
import htp.by.ramanouski.filesystem.shared.FileDto;
import htp.by.ramanouski.filesystem.ui.model.request.FileRequestDetails;
import htp.by.ramanouski.filesystem.ui.model.response.employee.EmployeeRest;
import htp.by.ramanouski.filesystem.ui.model.response.file.FileRest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FileRESTController {

    private final FileService fileService;
    private final EmployeeService employeeService;

    @Autowired
    public FileRESTController(FileService fileService, EmployeeService employeeService) {
        this.fileService = fileService;
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/files",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<FileRest> showFiles(@RequestParam(value = "page", defaultValue = "0") int page) {
        List<FileDto> filesDto = fileService.findAll(page);

        if (filesDto == null && filesDto.isEmpty()) {
            throw new ControllerException("Files are empty");
        }
        Type listType = new TypeToken<List<FileRest>>() {
        }.getType();
        ModelMapper mapper = new ModelMapper();
        List<FileRest> returnedValue = mapper.map(filesDto, listType);

        return returnedValue;
    }

    @GetMapping(path = "/files/{fileId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public FileRest showFileByFileId(@PathVariable("fileId") String fileId) {
        FileDto fileDto = fileService.findFileByFileId(fileId);

        ModelMapper mapper = new ModelMapper();
        FileRest returnedValue = mapper.map(fileDto, FileRest.class);

        return returnedValue;
    }

    @DeleteMapping(path = "/files/{fileId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public FileRest deleteFileByFileId(@PathVariable("fileId") String fileId) {

        FileDto fileDto = fileService.deleteFileByFileId(fileId);

        ModelMapper mapper = new ModelMapper();
        FileRest returnedValue = mapper.map(fileDto, FileRest.class);

        return returnedValue;
    }

    @PostMapping(path = "/files",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public FileRest createFile(@RequestBody FileRequestDetails fileRequestDetails) {

        if (fileRequestDetails.getDateOfSigning() == null || fileRequestDetails.getCompanyName() == null
                || fileRequestDetails.getContent() == null || fileRequestDetails.getDueDate() == null) {
            throw new ControllerException("No field should be empty");
        }

        FileDto fileDto = new FileDto();
        BeanUtils.copyProperties(fileRequestDetails, fileDto);
        String userId = fileRequestDetails.getUserId();

        FileDto savedFile = fileService.saveFileByUserId(fileDto, userId);
        ModelMapper mapper = new ModelMapper();
        FileRest returnedValue = mapper.map(savedFile, FileRest.class);

        return returnedValue;
    }

    @GetMapping("users/{userId}")
    public EmployeeRest showAllFilesByUserId(@PathVariable("userId") String userId) {
        EmployeeDto employeeDto = employeeService.findByUserId(userId);
        ModelMapper mapper = new ModelMapper();
        EmployeeRest returnedValue = mapper.map(employeeDto,EmployeeRest.class);
        return returnedValue;

    }

}
