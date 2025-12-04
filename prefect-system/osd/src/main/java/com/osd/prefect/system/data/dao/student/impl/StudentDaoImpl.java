package com.osd.prefect.system.data.dao.student.impl;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.student.StudentDao;
import com.osd.prefect.system.model.student.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao
{
    //TODO: i tanong kung departmentid ba yung kailangan o yung departmentName

    @Override
    public Student getStudentByID(String userID)
    {
        Student student;
        try (Connection con = ConnectionHelper.getConnection())
        {
            PreparedStatement stmt = con.prepareStatement("select * from student where UserID = ?");

            stmt.setString(1, userID);
            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            {
                student = new Student();
                student.setStudentID(rs.getString("studentID"));
                student.setUserID(rs.getString("userID"));
                student.setPersonID(rs.getString("personID"));
                student.setStudentLevel(rs.getString("studentlevel"));
                student.setSection(rs.getString("section"));
                student.setDepartmentID(rs.getString("departmentID"));
                return student;
            }
        }
        catch (SQLException e)
        {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Student> getStudentsByDepartmentID(String DepartmentID)
    {
        List<Student> itemList = new ArrayList<>();

        try (Connection con = ConnectionHelper.getConnection())
        {
            PreparedStatement stmt = con.prepareStatement("select * from student where DepartmentID = ?");

            stmt.setString(1, DepartmentID);
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                Student student = new Student();
                student.setStudentID(rs.getString("studentID"));
                student.setUserID("userID");
                student.setPersonID("personID");
                student.setStudentLevel(rs.getString("studentlevel"));
                student.setSection(rs.getString("section"));
                student.setDepartmentID(rs.getString("departmentID"));
                itemList.add(student);
            }

        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }
        return itemList;
    }

    @Override
    public List<Student> getStudentsBySection(String section)
    {
        List<Student> itemList = new ArrayList<>();

        try (Connection con = ConnectionHelper.getConnection())
        {
            PreparedStatement stmt = con.prepareStatement("select * from student where section = ?");

            stmt.setString(1, section);
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                Student student = new Student();
                student.setStudentID(rs.getString("studentID"));
                student.setUserID("userID");
                student.setPersonID("personID");
                student.setStudentLevel(rs.getString("studentlevel"));
                student.setSection(rs.getString("section"));
                student.setDepartmentID(rs.getString("departmentID"));
                itemList.add(student);
            }

        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }
        return itemList;
    }

    @Override
    public List<Student> getStudentsByStudentLevel(String studentLevel)
    {
        List<Student> itemList = new ArrayList<>();

        try (Connection con = ConnectionHelper.getConnection())
        {
            PreparedStatement stmt = con.prepareStatement("select * from student where studentLevel = ?");

            stmt.setString(1, studentLevel);
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                Student student = new Student();
                student.setStudentID(rs.getString("studentID"));
                student.setUserID("userID");
                student.setPersonID("personID");
                student.setStudentLevel(rs.getString("studentlevel"));
                student.setSection(rs.getString("section"));
                student.setDepartmentID(rs.getString("departmentID"));
                itemList.add(student);
            }

        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }
        return itemList;
    }
}