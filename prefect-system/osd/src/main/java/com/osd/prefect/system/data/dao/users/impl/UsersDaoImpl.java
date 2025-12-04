package com.osd.prefect.system.data.dao.users.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.users.UsersDao;
import com.osd.prefect.system.model.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao
{
    @Override
    public User getUserbyID(String userId)
    {
        User user = null;

        try (Connection con = ConnectionHelper.getConnection())
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE USERID = ?");
            stmt.setString(1, userId);

            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            {
                user = new User();
                user.setUserID(rs.getString("userID"));
                user.setUsername(rs.getString("username"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setUserRole(rs.getString("userRole"));
            }

        }
        catch (SQLException e)
        {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }

        return user;
    }

    @Override
    public User getUserbyUsername(String username)
    {
        User user = null;

        try (Connection con = ConnectionHelper.getConnection())
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            {
                user = new User();
                user.setUserID(rs.getString("userID"));
                user.setUsername(rs.getString("username"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setUserRole(rs.getString("userRole"));
            }

        }
        catch (SQLException e)
        {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }

        return user;
    }

    @Override
    public List<User> getUserbyRole(String role)
    {
        List<User> itemList = new ArrayList<>();

        try (Connection con = ConnectionHelper.getConnection())
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE userRole = ?");
            stmt.setString(1, role);

            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                User user = new User();
                user.setUserID(rs.getString("userID"));
                user.setUsername(rs.getString("username"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setUserRole(rs.getString("userRole"));
                itemList.add(user);
            }

        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }
        return itemList;
    }
}

//     test
//     feel free to delete
//    ConnectionHelper connectionHelper = new ConnectionHelper();
//
//    UsersDaoImpl usersDao1 = new UsersDaoImpl();
//    User user1 = usersDao1.getUserbyID("1002");
//        System.out.println("sample1: "+user1.getUserID());
//        System.out.println("sample1: "+user1.getUsername());
//        System.out.println("sample1: "+user1.getUserPassword());
//        System.out.println("sample1: "+user1.getUserRole());
//
//    UsersDaoImpl usersDao2 = new UsersDaoImpl();
//    User user2 = usersDao2.getUserbyUsername("cj123");
//        System.out.println("sample2: "+user2.getUserID());
//        System.out.println("sample2: "+user2.getUsername());
//        System.out.println("sample2: "+user2.getUserPassword());
//        System.out.println("sample2: "+user2.getUserRole());
//
//    UsersDaoImpl usersDao3 = new UsersDaoImpl();
//    List<User> array = usersDao3.getUserbyRole("STUDENT");
//        for(int i = 0; i < array.size(); i++)
//    {
//        User user3 = array.get(i);
//        System.out.println("==================================");
//        System.out.println("sample3: "+user3.getUserID());
//        System.out.println("sample3: "+user3.getUsername());
//        System.out.println("sample3: "+user3.getUserPassword());
//        System.out.println("sample3: "+user3.getUserRole());
//    }