package htp.by.ramanouski.filesystem.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "files")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "file_id", nullable = false)
    private String fileId;

    @Column(name = "date_of_signing", nullable = false)
    private LocalDate dateOfSigning;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeData;


}
