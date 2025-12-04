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
                return user;
            }

        }
        catch (SQLException e)
        {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }

   return null;
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