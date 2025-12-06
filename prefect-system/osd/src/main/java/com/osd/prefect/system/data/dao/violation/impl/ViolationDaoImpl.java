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
    public boolean addViolation(String studentId, String prefectID, String offenseID,
                                String actionID, String remarks) {
        String sql = "INSERT INTO VIOLATION " +
                "(studentID, prefectID, offenseID, dateOfViolation, actionID, dateOfResolution, remarks, status) " +
                "VALUES (?, ?, ?, SYSDATE, ?, NULL, ?, 'PENDING')";

        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, studentId);
            stmt.setString(2, prefectID);
            stmt.setString(3, offenseID);
            stmt.setString(4, actionID);
            stmt.setString(5, remarks);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("SQL Exception (addViolation): " + e.getMessage());
        }

        return false;
    }


    @Override
    public List<Violation> getAllViolationsPerStudent(String studentID) {
        List<Violation> violationList = new ArrayList<>();

        try (Connection con = ConnectionHelper.getConnection()) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM VIOLATION WHERE studentID = ?");
            stmt.setString(1, studentID);
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



}
