package htp.by.ramanouski.filesystem.ui.model.response.file;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FileRest {
    private String fileId;
    private LocalDate dateOfSigning;
    private String companyName;
    private String content;
    private LocalDate dueDate;
    private EmployeeFileRest employeeData;
}
