package com.osd.prefect.system.data.dao.department_head.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.department_head.DepartmentHeadDao;
import com.osd.prefect.system.model.department_head.DepartmentHead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentHeadDaoImpl implements DepartmentHeadDao {
    @Override
    public DepartmentHead getDepartmentHeadById(String UserID) {
        DepartmentHead departmentHead = null;
        try (Connection con = ConnectionHelper.getConnection()){

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM department_head WHERE UserID = ?");
            stmt.setString(1, UserID);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                departmentHead = new DepartmentHead();
                departmentHead.setDepartmentheadID(rs.getString("departmentHeadID"));
                departmentHead.setUserID(rs.getString("UserID"));
                departmentHead.setPersonID(rs.getString("PersonID"));
                departmentHead.setDepartmentID(rs.getString("departmentID"));

            }

        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }

        return departmentHead;

    }
}
