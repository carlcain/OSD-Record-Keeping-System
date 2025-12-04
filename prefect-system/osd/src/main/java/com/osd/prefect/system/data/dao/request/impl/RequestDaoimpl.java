package com.osd.prefect.system.data.dao.request.impl;
import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.request.impl.RequestDao;
import com.osd.prefect.system.model.department_head.DepartmentHead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestDaoimpl implements RequestDao{

    @Override
    public void setRequest(String DepartmentID, String Details, String message) {
        try (Connection con = ConnectionHelper.getConnection()){

            PreparedStatement stmt = con.prepareStatement("INSERT INTO request (departmentHeadID, details, message) VALUES (?, ?, ?");
            stmt.setString(1, DepartmentID);
            stmt.setString(2, Details);
            stmt.setString(3, message);

            ResultSet rs = stmt.executeQuery();

        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }
    }
}
