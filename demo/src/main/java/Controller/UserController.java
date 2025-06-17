/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.userEntity;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Qadeer
 */
public class UserController {
    public static SessionFactory sessionFactory;
    
    static{
        try{
            Configuration cfg=new Configuration();
            cfg.configure("hibernate.cfg.xml");
            sessionFactory = cfg.buildSessionFactory();
            
        }catch(Exception e){
        e.printStackTrace();
        }
    }
    
    public static int addUser(String name, String email, String password) {
        Transaction transaction = null;
        Session session=null;
        try {
            session=sessionFactory.openSession();
            transaction = session.beginTransaction();
            
            userEntity user = new userEntity();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            
            session.save(user);
            transaction.commit();
      JOptionPane.showMessageDialog(null,"Record Added Successfully");
            return 1;
      
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
            return 0;
        } 
    }
    
     public static int updateUser(String oldName, String newName){
    Transaction transaction = null;
    Session session=null;
            
            try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            
            userEntity user=new userEntity();
            
            String hql="Update userEntity set name = :newName where name = : oldName";
            session.createQuery(hql)
                    .setParameter("newName",newName)
                    .setParameter("oldName",oldName)
                    .executeUpdate();
            transaction.commit();
            JOptionPane.showMessageDialog(null,"Record Update Successfully");
            return 1;
            
            }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
           return 0;
            }
    }
     
     
      public static int userDelete(String name){
            Transaction transaction=null;
            Session session=null;

            try{
            session=sessionFactory.openSession();
            transaction = session.beginTransaction();
            
            userEntity user=new userEntity();
            String hql="Delete From userEntity where name = : name";
            session.createQuery(hql)
                    .setParameter("name", name)
                    .executeUpdate();
            transaction.commit();
            JOptionPane.showMessageDialog(null,"Record Delete Successfully");
            return 1;
            
            }catch(Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error");
            return 0;   
            }
            }
     
     
        
    
}
