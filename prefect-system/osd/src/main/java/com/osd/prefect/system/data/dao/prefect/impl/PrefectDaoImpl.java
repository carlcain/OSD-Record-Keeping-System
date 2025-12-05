package com.osd.prefect.system.data.dao.prefect.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.guardian.GuardianDao;
import com.osd.prefect.system.data.dao.prefect.PrefectDao;
import com.osd.prefect.system.model.disciplinary_action.DisciplinaryAction;
import com.osd.prefect.system.model.guardian.Guardian;
import com.osd.prefect.system.model.prefect.Prefect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrefectDaoImpl implements PrefectDao {

    @Override
    public Prefect getPrefectByID(String userID) {
        Prefect prefect = null;

        try (Connection con = ConnectionHelper.getConnection()) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM PREFECT WHERE USERID = ?");
            stmt.setString(1, userID);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                prefect = new Prefect();
                prefect.setPrefectID(rs.getString("prefectID"));
                prefect.setDepartmentID(rs.getString("departmentID"));
            }

        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }

        return prefect;

    }
}
