package htp.by.ramanouski.filesystem.service.implementation;

import htp.by.ramanouski.filesystem.base.IntegrationBaseTest;
import htp.by.ramanouski.filesystem.entity.EmployeeEntity;
import htp.by.ramanouski.filesystem.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@Sql("/sql/employee_data.sql")
class EmployeeRepositoryTest extends IntegrationBaseTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static final String USER_ID = "xNEXVPuCBJI7ThORRSLXDgtv51i0B1";
    public static final String FAKE_USER_ID = "FAKEID";
    public static final String USER_LAST_NAME = "Reva";


    @Test
    public void findByUserId() {
        EmployeeEntity employee = employeeRepository.findByUserId(USER_ID);
        assertNotNull(employee);
        assertEquals(USER_LAST_NAME,employee.getLastName());
    }

    @Test
    public void findByUserIdNull() {
        EmployeeEntity employee = employeeRepository.findByUserId(FAKE_USER_ID);
        assertNull(employee);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}