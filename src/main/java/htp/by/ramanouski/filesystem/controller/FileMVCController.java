package htp.by.ramanouski.filesystem.controller;

import htp.by.ramanouski.filesystem.service.FileService;
import htp.by.ramanouski.filesystem.shared.FileDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileMVCController {

    private final FileService fileService;

    @Autowired
    public FileMVCController(FileService fileService) {
        this.fileService = fileService;
    }


    @GetMapping("/files")
    private String showFiles(@RequestParam(value="page", defaultValue = "0") int page,
                             Model model){
        model.addAttribute("files",fileService.findAll(page));
        return "files/files";
    }

    @GetMapping("/files/{fileId}")
    private String showFiles(Model model, @PathVariable("fileId") String fileId){
        FileDto returnedValue = fileService.findFileByFileId(fileId);
        model.addAttribute("singleFile", returnedValue);
        return "files/single-file";
    }

    @GetMapping("/create")
    private String showCreationForm(Model model){
        model.addAttribute("file", new FileDto());
        return "file-actions";
    }

}
