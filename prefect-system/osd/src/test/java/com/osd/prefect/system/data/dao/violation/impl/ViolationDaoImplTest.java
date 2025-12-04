package com.osd.prefect.system.data.dao.violation.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.violation.ViolationDao;
import com.osd.prefect.system.model.violation.Violation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        when(violationDao.getAllViolations()).thenReturn(Collections.emptyList());

    }

    @Test
    void checkIfViolationIsNotOnList(){
        List<Violation> roles = violationDao.getAllViolations();
        boolean checkRole = false;

        for (Violation v : roles) {
            if (v.getViolationID().equals("OFF-019")) {
                checkRole = true;
                break;
            }
        }
        assertFalse(checkRole, "Violation is not on list");
        assertEquals(0, roles.size());
    }
}