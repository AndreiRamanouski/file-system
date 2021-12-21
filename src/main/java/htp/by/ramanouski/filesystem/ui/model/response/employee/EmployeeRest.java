package htp.by.ramanouski.filesystem.ui.model.response.employee;

import htp.by.ramanouski.filesystem.shared.FileDto;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeRest {
    private String userId;
    private String email;
    private String encryptedPassword;
    private String firstName;
    private String lastName;
    private List<FileEmployeeRest> files;
}
