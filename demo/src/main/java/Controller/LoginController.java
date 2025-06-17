/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.userEntity;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Qadeer
 */
public class LoginController {
    public static SessionFactory sessionFactory;
    
    static{
    try{
            Configuration cfg=new Configuration();
            cfg.configure("hibernate.cfg.xml");
            sessionFactory=cfg.buildSessionFactory();
            
    }catch(Exception e){
    e.printStackTrace();
    }
    }
    
      public static int login(String name, String password){
          Session session=null;
          try{
          session=sessionFactory.openSession();
         
          
          String hql="FROM userEntity WHERE name = : name AND password = : password";
           userEntity user=(userEntity) session.createQuery(hql)
                   .setParameter("name",name)
                   .setParameter("password",password)
                   .uniqueResult();
                   
           if(user!=null){
           JOptionPane.showMessageDialog(null,"Wellcome");
           //System.out.print("Wellcome");
           }else{
           JOptionPane.showMessageDialog(null,"Invalid credentials ");
          //System.out.print("Invalid Password");
           }
          
          
          }catch(Exception e){
          e.printStackTrace();
          }
          return 1;
    }
    
}
