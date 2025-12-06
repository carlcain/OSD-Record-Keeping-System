package com.osd.prefect.system.data.dao.request.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.request.RequestDao;
import com.osd.prefect.system.model.department_head.DepartmentHead;
import com.osd.prefect.system.model.request.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestDaoImpl implements RequestDao {

    @Override
    public void setRequest(String deptHeadID, String details, String message, String type) {
        try (Connection con = ConnectionHelper.getConnection()){

            PreparedStatement stmt = con.prepareStatement("INSERT INTO request (departmentHeadID, details, message, type, status) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, deptHeadID);
            stmt.setString(2, details);
            stmt.setString(3, message);
            stmt.setString(4, type);


            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }

    }
    public List<Request> getAllRequests() {
        List<Request> requestList = new ArrayList<>();

        String sql = "SELECT * FROM REQUEST";

        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Request r = new Request();
                r.setRequestID(rs.getString("requestID"));
                r.setDepartmentHeadID(rs.getString("departmentHeadID"));
                r.setDetails(rs.getString("details"));
                r.setMessage(rs.getString("message"));
                r.setType(rs.getString("type"));
                r.setStatus(rs.getString("status"));

                requestList.add(r);
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception (getAllRequests): " + e.getMessage());
        }

        return requestList;
    }
    public boolean updateRequestStatus(String requestID, String newStatus) {
        String sql = "UPDATE REQUEST SET status = ? WHERE requestID = ?";

        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, newStatus);
            stmt.setString(2, requestID);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("SQL Exception (updateRequestStatus): " + e.getMessage());
        }

        return false;
    }

}
