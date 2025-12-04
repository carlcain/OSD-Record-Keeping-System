package com.osd.prefect.system.data.dao.violation.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.violation.ViolationDao;
import com.osd.prefect.system.model.violation.Violation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViolationDaoImpl implements ViolationDao {
    @Override
    public List<Violation> getAllViolations() {
        List<Violation> violationList = new ArrayList<>();

        try (Connection con = ConnectionHelper.getConnection()) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM VIOLATION");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Violation v = new Violation();
                v.setViolationID(rs.getString("violationID"));
                v.setStudentID(rs.getString("studentID"));
                v.setPrefectID(rs.getString("prefectID"));
                v.setOffenseID(rs.getString("offenseID"));
                v.setDateofViolation(rs.getDate("DateofViolation"));
                v.setActionID(rs.getString("actionID"));
                v.setDateofResolution(rs.getDate("DateofResolution"));
                v.setRemarks(rs.getString("remarks"));
                v.setStatus(rs.getString("status"));

                violationList.add(v);
            }

        } catch (SQLException e) {
            System.out.println("SQL ERROR (getAllViolations): " + e.getMessage());
        }

        return violationList;
    }

    @Override
    public void addViolation(String studentId, String prefectID, String offenseID, Date dateOfViolation, String actionID, Date dateOfResolution, String remarks, String status) {

    }

    @Override
    public void editViolation(Violation violation) {

    }

}
