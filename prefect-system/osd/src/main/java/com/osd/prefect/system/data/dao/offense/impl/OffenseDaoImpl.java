package com.osd.prefect.system.data.dao.offense.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.offense.OffenseDao;
import com.osd.prefect.system.model.disciplinary_action.DisciplinaryAction;
import com.osd.prefect.system.model.offense.Offense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OffenseDaoImpl implements OffenseDao {
    @Override
    public List<Offense> getAllOffense() {
        List<Offense> offenseList = new ArrayList<>();
        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM OFFENSE");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Offense offense = new Offense();
                offense.setOffenseID(rs.getString("offenseID"));
                offense.setOffense(rs.getString("offense"));
                offense.setRemarks(rs.getString("remarks"));
                offenseList.add(offense);
            }
        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }
        return offenseList;
    }
}



