package htp.by.ramanouski.filesystem.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String userId;
    private String email;
    private String encryptedPassword;
    private String firstName;
    private String lastName;
    private List<FileDto> files;
}
