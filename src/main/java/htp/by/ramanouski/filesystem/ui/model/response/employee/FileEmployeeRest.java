package htp.by.ramanouski.filesystem.ui.model.response.employee;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FileEmployeeRest {
    private String fileId;
    private LocalDate dateOfSigning;
    private String companyName;
    private String content;
    private LocalDate dueDate;
}
