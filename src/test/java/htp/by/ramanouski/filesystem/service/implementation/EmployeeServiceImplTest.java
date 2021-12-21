package htp.by.ramanouski.filesystem.service.implementation;

import htp.by.ramanouski.filesystem.base.IntegrationBaseTest;
import htp.by.ramanouski.filesystem.service.EmployeeService;
import htp.by.ramanouski.filesystem.service.exception.ServiceException;
import htp.by.ramanouski.filesystem.shared.EmployeeDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@Sql("/sql/employee_data.sql")
class EmployeeServiceImplTest extends IntegrationBaseTest {

    public static final String USER_ID = "xNEXVPuCBJI7ThORRSLXDgtv51i0B1";
    public static final String FAKE_USER_ID = "FAKEID";

    @Autowired
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void findByUserId() {
        EmployeeDto byUserId = employeeService.findByUserId(USER_ID);
        assertNotNull(byUserId);
    }

    @Test
    void findFilesByUserId() {
        EmployeeDto byUserId = employeeService.findByUserId(USER_ID);
        assertThat(byUserId.getFiles(), hasSize(2));
    }

    @Test
    void findByUserId_ThrowsServiceException() {
        assertThrows(ServiceException.class,
                ()-> employeeService.findByUserId(FAKE_USER_ID));
    }
}