package htp.by.ramanouski.filesystem.ui.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileRequestDetails {
    private LocalDate dateOfSigning;
    private String companyName;
    private String content;
    private LocalDate dueDate;
    private String userId;
}
