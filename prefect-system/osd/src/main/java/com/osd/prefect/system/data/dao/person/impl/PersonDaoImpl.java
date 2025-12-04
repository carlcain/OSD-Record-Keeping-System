package com.osd.prefect.system.data.dao.person.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.person.PersonDao;
import com.osd.prefect.system.model.person.Person;
import com.osd.prefect.system.model.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDaoImpl implements PersonDao {

    @Override
    public Person getByPersonId(String personID) {
        Person person = null;

        try (Connection con = ConnectionHelper.getConnection())
        {
            PreparedStatement stmt = con.prepareStatement("select * from person where PersonID = ?");
            stmt.setString(1, personID);

            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            {
                person = new Person();
                person.setPersonId(rs.getString("personID"));
                person.setFirstName(rs.getString("FirstName"));
                person.setMiddleName(rs.getString("MiddleName"));
                person.setLastName(rs.getString("LastName"));
            }

        }
        catch (SQLException e)
        {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }
        return person;
    }
}
