package com.osd.prefect.system.data.dao.disciplinary_action.impl;

import com.osd.prefect.system.model.disciplinary_action.DisciplinaryAction;
import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.disciplinary_action.DisciplinaryActionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaryActionDaoImpl implements DisciplinaryActionDao {

    @Override
    public List<DisciplinaryAction> getAllDisciplinaryAction() {
        List<DisciplinaryAction> itemList = new ArrayList<>();
        try (Connection con = ConnectionHelper.getConnection()) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM DISCIPLINARYACTION");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                DisciplinaryAction item = new DisciplinaryAction();
                item.setActionID(rs.getString("actionID"));
                item.setAction(rs.getString("action"));
                item.setDescription(rs.getString("description"));
                itemList.add(item);
            }
        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }
        return itemList;
    }
}
