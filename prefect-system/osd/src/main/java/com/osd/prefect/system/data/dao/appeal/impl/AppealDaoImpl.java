package com.osd.prefect.system.data.dao.appeal.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.appeal.AppealDao;
import com.osd.prefect.system.model.appeal.Appeal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppealDaoImpl implements AppealDao {
    @Override
    public boolean addAppeal(String violationID, String studentID, String message) {
        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO APPEAL (violationID, studentID, message, datefiled, status) VALUES (?, ?, ?, SYSDATE, ?)");
            stmt.setString(1,violationID);
            stmt.setString(2, studentID);
            stmt.setString(3, message);
            stmt.setString(4, "PENDING");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }return false;
    }

    @Override
    public boolean updateAppealStatus(String appealID, String newStatus) {
        try (Connection con = ConnectionHelper.getConnection()) {

            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE APPEAL SET status = ? WHERE appealID = ?"
            );

            stmt.setString(1, newStatus);
            stmt.setString(2, appealID);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
                System.out.println("SQL Exception (updateAppealStatus): " + e.getMessage());
        }
        return false;
    }


    @Override
    public List<Appeal> getAllAppeals() {
            List<Appeal> appealList = new ArrayList<>();

            try (Connection con = ConnectionHelper.getConnection()) {

                PreparedStatement stmt = con.prepareStatement("SELECT * FROM APPEAL");
                ResultSet rs = stmt.executeQuery();

                while(rs.next()) {
                    Appeal appeal = new Appeal();
                    appeal.setAppealID(rs.getString("appealID"));
                    appeal.setViolationID(rs.getString("violationID"));
                    appeal.setStudentID(rs.getString("studentID"));
                    appeal.setMessage(rs.getString("message"));
                    appeal.setDateFiled(rs.getDate("datefiled"));
                    appeal.setStatus(rs.getString("status"));

                    appealList.add(appeal);
                }

            } catch (SQLException e) {
                System.out.println("SQL Exception (getAllAppeals): " + e.getMessage());
            }
            return appealList;
        }

    }

