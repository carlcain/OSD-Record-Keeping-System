package com.osd.prefect.system.data.dao.prefect.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.model.prefect.Prefect;
import oracle.jdbc.proxy.annotation.Pre;
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
import static org.mockito.Mockito.mock;

class PrefectDaoImplTest {

    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private PrefectDaoImpl prefectDaoImpl;

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

//        usersDao = mock(UsersDao.class);
//        User user1 = new User("1007", "keith123","QUEVADA", "STUDENT");
//
//        when(usersDao.getUserbyID("1007")).thenReturn(user1);
//        when(usersDao.getUserbyID("1000")).thenReturn(null);
//        when(usersDao.getUserbyUsername("keith123")).thenReturn(user1);
//        when(usersDao.getUserbyUsername("unknown")).thenReturn(null);
//        when(usersDao.getUserbyRole("STUDENT")).thenReturn(List.of(user1));
//        when(usersDao.getUserbyRole("PREFECT")).thenReturn(Collections.emptyList());

    @Test
    void checkIfPrefectIdIsFound(){
        Prefect prefect = prefectDaoImpl.getPrefectByID("DO-001");
        assertNotNull(prefect);
        assertEquals("keith123", prefect.getUsername());
    }
    @Test
    void checkIfUserIdIsNotFound(){
        assertNull(usersDao.getUserbyID("1000"));
    }
    @Test
    void getUserByIdWithBlankIdShouldThrowException(){
        UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
        Exception exception = assertThrows(Exception.class, () -> usersDaoImpl.getUserbyID(""));
        assertEquals(exception.getMessage(), exception.getMessage());
    }
    @Test
    void checkIfUsernameIsFound(){
        User user = usersDao.getUserbyUsername("keith123");
        assertNotNull(user);
        assertEquals("1007", user.getUserID());
    }
    @Test
    void checkIfUsernameIsNotFound(){
        assertNull(usersDao.getUserbyUsername("unknown"));
    }
    @Test
    void getUsernameWithBlankUsernameShouldThrowException(){
        UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
        Exception exception = assertThrows(Exception.class, () -> usersDaoImpl.getUserbyUsername(""));
        assertEquals(exception.getMessage(), exception.getMessage());
    }

    @Test
    void checkRoleIfNotOnList() {
        List<User> result = usersDao.getUserbyRole("PREFECT");
        assertTrue(result.isEmpty());
    }

    @Test
    void checkRoleIfFoundOnList() {
        List<User> result = usersDao.getUserbyRole("STUDENT");
        assertFalse(result.isEmpty());
        assertEquals("keith123", result.get(0).getUsername());
    }
}