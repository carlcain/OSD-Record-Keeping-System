package com.osd.prefect.system.data.dao.prefect.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.prefect.PrefectDao;
import com.osd.prefect.system.model.prefect.Prefect;
import com.osd.prefect.system.model.users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PrefectDaoImplTest {

    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private PrefectDaoImpl prefectDaoImpl;
    @Mock
    private PrefectDao prefectDao;

    private static MockedStatic<ConnectionHelper> connectionHelper;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        connection = mock(Connection.class);
        preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        connectionHelper = Mockito.mockStatic(ConnectionHelper.class);
        connectionHelper.when(ConnectionHelper::getConnection).thenReturn(connection);

        prefectDao = new PrefectDaoImpl();
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }

    @Test
    void getPrefectIdByIdIfFound() throws Exception {
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getString("prefectID")).thenReturn("DO-002");
        when(resultSet.getString("departmentID")).thenReturn("shs-3002");

        Prefect prefect = prefectDao.getPrefectByID("DO-012");

        assertNotNull(prefect);
        assertEquals("DO-002", prefect.getPrefectID());
        assertEquals("shs-3002", prefect.getDepartmentID());
    }

    @Test
    void getPrefectIdByIdIfNotFound() throws Exception {
        when(resultSet.next()).thenReturn(false);

        Prefect prefect = prefectDao.getPrefectByID("DO-002");

        assertNull(prefect);
    }

    @Test
    void getPrefectByIdWithBlankIdShouldThrowException() {
        Exception e = assertThrows(Exception.class, () -> prefectDao.getPrefectByID(""));
        assertEquals("Prefect ID is blank", e.getMessage());
    }

}