package htp.by.ramanouski.filesystem.service;

import htp.by.ramanouski.filesystem.shared.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    EmployeeDto findByUserId(String userId);
}
