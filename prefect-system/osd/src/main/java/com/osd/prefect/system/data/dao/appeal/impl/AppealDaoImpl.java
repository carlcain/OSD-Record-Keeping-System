package com.osd.prefect.system.data.dao.appeal.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.appeal.AppealDao;
import com.osd.prefect.system.model.appeal.Appeal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AppealDaoImpl implements AppealDao {
    @Override
    public boolean addAppeal(String violationID, String studentID, String message) {
        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO APPEAL (violationID, studentID, message) VALUES (?, ?, ?)");
            stmt.setString(1,violationID);
            stmt.setString(2, studentID);
            stmt.setString(3, message);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }return false;
    }

    @Override
    public void editAppealStatus(Appeal appeal, String status) {

    }

    @Override
    public List<Appeal> getAllAppeals() {
        return null;
    }
}
