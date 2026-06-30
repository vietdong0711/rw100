package com.vti;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = HibernateUtils.sessionFactory;
        Session session = sessionFactory.openSession();
        Department department = session.find(Department.class, 1);
        System.out.println(department);
    }
}
