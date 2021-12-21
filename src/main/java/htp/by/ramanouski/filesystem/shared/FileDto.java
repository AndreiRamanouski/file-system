package htp.by.ramanouski.filesystem.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {
    private String fileId;
    private LocalDate dateOfSigning;
    private String companyName;
    private String content;
    private LocalDate dueDate;
    private EmployeeDto employeeData;
}
