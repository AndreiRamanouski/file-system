package htp.by.ramanouski.filesystem.service.implementation;

import htp.by.ramanouski.filesystem.entity.EmployeeEntity;
import htp.by.ramanouski.filesystem.repository.EmployeeRepository;
import htp.by.ramanouski.filesystem.service.EmployeeService;
import htp.by.ramanouski.filesystem.service.exception.ServiceException;
import htp.by.ramanouski.filesystem.shared.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto findByUserId(String userId) {
        EmployeeEntity entity = employeeRepository.findByUserId(userId);

        if (entity == null) {
            throw new ServiceException("There is no user with userId: " + userId);
        }

        ModelMapper mapper = new ModelMapper();
        EmployeeDto returnedValue = mapper.map(entity, EmployeeDto.class);
        return returnedValue;
    }
}
