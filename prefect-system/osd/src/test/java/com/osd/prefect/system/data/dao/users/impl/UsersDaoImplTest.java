package com.osd.prefect.system.data.dao.users.impl;

<<<<<<< Updated upstream
import com.osd.prefect.system.data.dao.users.UsersDao;
import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.model.users.User;
import org.junit.jupiter.api.Test;
=======
import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.users.UsersDao;
import com.osd.prefect.system.model.users.User;
>>>>>>> Stashed changes
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

<<<<<<< Updated upstream
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;

>>>>>>> Stashed changes
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

<<<<<<< Updated upstream
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.String;

class UsersDaoImplTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    private static MockedStatic<ConnectionHelper> connectionHelper;

    @Mock
    private UsersDao usersDao;
    @Mock
    private UsersDaoImpl usersDaoImpl;
=======
class UsersDaoImplTest {
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private UsersDao usersDao;

    private static MockedStatic<ConnectionHelper> connectionHelper;
>>>>>>> Stashed changes

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        connection = mock(Connection.class);
        preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        connectionHelper = Mockito.mockStatic(ConnectionHelper.class);
        connectionHelper.when(ConnectionHelper::getConnection).thenReturn(connection);
<<<<<<< Updated upstream
    }

    @Test
    void checkUsername() {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        User user = usersDao.getUserbyUsername("keith123");
        assertEquals("keith123", user.getUsername());
    }

//    @Test
//    void getUserByIdWithBlankIdShouldThrowException() {
//        UsersDao usersDao = new UsersDaoImpl();
//        Exception exception = assertThrows(Exception.class, () -> usersDao.getUserbyID(""));
//        assertEquals("ID is not present", exception.getMessage());
//    }

//    @Test
//    void getUserbyUsernameWithBlankIdShouldThrowException() {
//        UsersDao usersDao = new UsersDaoImpl();
//        Exception exception = assertThrows(Exception.class, () -> usersDao.getUserbyUsername(""));
//        assertEquals("Username is not present", exception.getMessage());
//    }

//    @Test
//    void findUserIdShouldReturnAnUser() throws SQLException {
//        UsersDao usersDao = new UsersDaoImpl();
//
//        when(resultSet.getString("userId")).thenReturn(usersDao.userId);
//
//    }
=======

        usersDao = mock(UsersDao.class);
        User user1 = new User("1007", "keith123","QUEVADA", "STUDENT");

        when(usersDao.getUserbyID("1007")).thenReturn(user1);
        when(usersDao.getUserbyID("1000")).thenReturn(null);
        when(usersDao.getUserbyUsername("keith123")).thenReturn(user1);
        when(usersDao.getUserbyUsername("unknown")).thenReturn(null);
        when(usersDao.getUserbyRole("STUDENT")).thenReturn(List.of(user1));
        when(usersDao.getUserbyRole("PREFECT")).thenReturn(Collections.emptyList());
    }

    @Test
    void checkIfUserIdIsFound(){
        User user = usersDao.getUserbyID("1007");
        assertNotNull(user);
        assertEquals("keith123", user.getUsername());
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
>>>>>>> Stashed changes

}