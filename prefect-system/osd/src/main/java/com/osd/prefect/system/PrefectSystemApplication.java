package com.osd.prefect.system;

import com.osd.prefect.system.data.dao.department_head.impl.DepartmentHeadDaoImpl;
import com.osd.prefect.system.data.dao.users.impl.UsersDaoImpl;
import com.osd.prefect.system.model.department_head.DepartmentHead;
import com.osd.prefect.system.model.users.User;

import java.util.Locale;
import java.util.Scanner;

public class PrefectSystemApplication
{
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[]args)
    {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        User user = usersDao.getUserbyID("1002");
        DepartmentHead(user);
    }

    // request student
    // with name
    public static void DepartmentHead(User user)
    {
        //Department head semi login
        DepartmentHeadDaoImpl departmentHeadDao = new DepartmentHeadDaoImpl();
        DepartmentHead departmentHead = departmentHeadDao.getDepartmentHeadById(user.getUserID());

        System.out.println("Welcome "+ user.getUsername() +"! ");
        System.out.println("would you like to make a request?");
        System.out.println("request = r");
        System.out.println("exit = e");
            String input = sc.next().toLowerCase();

            if(input.equals("r"))
            {

            }
            else if(input.equals("e"))
            {
                // back(a method instance here)
            }
            else
            {
                System.out.println("Unknown input");
            }
        }
        else
        {
            System.out.println("sorry cant find ID");
        }
    }


}