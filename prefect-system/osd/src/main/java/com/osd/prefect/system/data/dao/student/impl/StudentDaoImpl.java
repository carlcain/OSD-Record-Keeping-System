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
            PreparedStatement stmt = con.prepareStatement("select * from student where StudentID = ?");

            stmt.setString(1, userID);
            ResultSet rs = stmt.executeQuery();

            if(rs.next())
            {
                student = new Student();
                student.setStudentID(rs.getString("studentID"));
                student.setUserID("userID");
                student.setPersonID("personID");
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

//    test
//     feel free to delete
//    StudentDaoImpl studentDao = new StudentDaoImpl();
//    Student student = studentDao.getStudentByID("S-001");
//        System.out.println("sample1 "+student.getStudentID());
//        System.out.println("sample1 "+student.getSurname());
//        System.out.println("sample1 "+student.getFirstName());
//        System.out.println("sample1 "+student.getMiddleName());
//        System.out.println("sample1 "+student.getStudentLevel());
//        System.out.println("sample1 "+student.getSection());
//        System.out.println("sample1 "+student.getDepartmentID());
//
//    List<Student> itemList1 = studentDao.getStudentsByDepartmentID("jhs-3001");
//        for(int i = 0; i < itemList1.size(); i++)
//    {
//        Student student1 = itemList1.get(i);
//        System.out.println("===========================");
//        System.out.println("sample2 "+student1.getStudentID());
//        System.out.println("sample2 "+student1.getSurname());
//        System.out.println("sample2 "+student1.getFirstName());
//        System.out.println("sample2 "+student1.getMiddleName());
//        System.out.println("sample2 "+student1.getStudentLevel());
//        System.out.println("sample2 "+student1.getSection());
//        System.out.println("sample2 "+student1.getDepartmentID());
//    }
//
//    List<Student> itemList2 = studentDao.getStudentsBySection("St.Hannibal");
//        for(int i = 0; i < itemList2.size(); i++)
//    {
//        Student student1 = itemList2.get(i);
//        System.out.println("===========================");
//        System.out.println("sample3 "+student1.getStudentID());
//        System.out.println("sample3 "+student1.getSurname());
//        System.out.println("sample3 "+student1.getFirstName());
//        System.out.println("sample3 "+student1.getMiddleName());
//        System.out.println("sample3 "+student1.getStudentLevel());
//        System.out.println("sample3 "+student1.getSection());
//        System.out.println("sample3 "+student1.getDepartmentID());
//    }
//
//    List<Student> itemList3 = studentDao.getStudentsByStudentLevel("Grade-11");
//        for(int i = 0; i < itemList3.size(); i++)
//    {
//        Student student1 = itemList3.get(i);
//        System.out.println("===========================");
//        System.out.println("sample4 "+student1.getStudentID());
//        System.out.println("sample4 "+student1.getSurname());
//        System.out.println("sample4 "+student1.getFirstName());
//        System.out.println("sample4 "+student1.getMiddleName());
//        System.out.println("sample4 "+student1.getStudentLevel());
//        System.out.println("sample4 "+student1.getSection());
//        System.out.println("sample4 "+student1.getDepartmentID());
//    }
//        System.out.println("===========================");
