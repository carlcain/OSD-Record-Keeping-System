package com.osd.prefect.system;

import com.osd.prefect.system.data.connection.ConnectionHelper;
import com.osd.prefect.system.data.dao.users.impl.UsersDaoImpl;
import com.osd.prefect.system.model.users.User;

import java.util.List;

public class PrefectSystemApplication
{

    public static void main(String[] args)
    {
//             test
//     feel free to delete
    ConnectionHelper connectionHelper = new ConnectionHelper();

    UsersDaoImpl usersDao1 = new UsersDaoImpl();
    User user1 = usersDao1.getUserbyID("1002");
        System.out.println("sample1: "+user1.getUserID());
        System.out.println("sample1: "+user1.getUsername());
        System.out.println("sample1: "+user1.getUserPassword());
        System.out.println("sample1: "+user1.getUserRole());

    UsersDaoImpl usersDao2 = new UsersDaoImpl();
    User user2 = usersDao2.getUserbyUsername("keith123");
        System.out.println("sample2: "+user2.getUserID());
        System.out.println("sample2: "+user2.getUsername());
        System.out.println("sample2: "+user2.getUserPassword());
        System.out.println("sample2: "+user2.getUserRole());

    UsersDaoImpl usersDao3 = new UsersDaoImpl();
    List<User> array = usersDao3.getUserbyRole("STUDENT");
        for(int i = 0; i < array.size(); i++)
    {
        User user3 = array.get(i);
        System.out.println("==================================");
        System.out.println("sample3: "+user3.getUserID());
        System.out.println("sample3: "+user3.getUsername());
        System.out.println("sample3: "+user3.getUserPassword());
        System.out.println("sample3: "+user3.getUserRole());
    }
    }
}
