package com.osd.prefect.system.data.dao.guardian.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.guardian.GuardianDao;
import com.osd.prefect.system.model.guardian.Guardian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GuardianDaoImpl implements GuardianDao {

    @Override
    public Guardian getGuardianByStudentID(String studentID) {
        Guardian guardian = null;

        try (Connection con = ConnectionHelper.getConnection()){

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM GUARDIAN WHERE GUARDIANID = ?");
            stmt.setString(1, studentID);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                guardian = new Guardian();
                guardian.setPersonID(rs.getString("PersonID"));
                guardian.setContactNumber(rs.getString("contactnumber"));
                guardian.setRelationship(rs.getString("relationship"));
                guardian.setStudentID(rs.getString("studentID"));
            }

        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }

        return guardian;

    }
}
