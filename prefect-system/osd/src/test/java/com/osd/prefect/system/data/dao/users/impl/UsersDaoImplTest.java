package com.osd.prefect.system.data.dao.users.impl;

import com.osd.prefect.system.data.dao.users.UsersDao;
import com.osd.prefect.system.data.connection.ConnectionHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class UsersDaoImplTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    private static MockedStatic<ConnectionHelper> connectionHelper;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        connection = mock(Connection.class);
        preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        connectionHelper = Mockito.mockStatic(ConnectionHelper.class);
        connectionHelper.when(ConnectionHelper::getConnection).thenReturn(connection);
    }

    @Test
    void getUserByIdAndUsernameWithBlankIdShouldThrowException() {
        UsersDao usersDao = new UsersDaoImpl();
        Exception exception = assertThrows(Exception.class, () -> usersDao.getUserbyID(""));
        exception = assertThrows(Exception.class, () -> usersDao.getUserbyUsername(""));
        assertEquals("ID is not present", exception.getMessage());
        assertEquals("ID is not present", exception.getMessage());
    }

//    @Test
//    void getUserbyUsername() {
//        UsersDao usersDao = new UsersDaoImpl();
//
//    }

}