package com.osd.prefect.system.data.dao.violation.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.violation.ViolationDao;
import com.osd.prefect.system.model.student.Student;
import com.osd.prefect.system.model.violation.Violation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ViolationDaoImplTest {

    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private ViolationDao violationDao;

    private static MockedStatic<ConnectionHelper> connectionHelper;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        connection = mock(Connection.class);
        preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        connectionHelper = Mockito.mockStatic(ConnectionHelper.class);
        connectionHelper.when(ConnectionHelper::getConnection).thenReturn(connection);

        violationDao = mock(ViolationDao.class);
        List<Violation> mockList = new ArrayList<>();
        Violation violation = new Violation("V-001", "S-001", "DO-001", "OFF-002",
                Date.valueOf("2025-07-28"), "D-001",Date.valueOf("2025-08-04"), "8 hours of Community service", "IN PROGRESS");
        mockList.add(violation);
        when(violationDao.getAllViolations()).thenReturn(mockList);
    }

    @Test
    void checkIfViolationIsNotOnList(){
        List<Violation> violations = violationDao.getAllViolations();
        assertNotNull(violations);
        assertEquals(1, violations.size());
        assertEquals("V-001", violations.get(0).getViolationID());
    }

}