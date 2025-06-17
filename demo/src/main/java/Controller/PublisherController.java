/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Model.Publish;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Qadeer
 */
public class PublisherController {
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
    
    public static int addPublish(String name, String address, int phone){
      Transaction transaction=null;
      Session session=null;
      
      try{
          session=sessionFactory.openSession();
          transaction=session.beginTransaction();
          
          Publish p=new Publish();
          p.setName(name);
          p.setAddress(address);
          p.setPhone(phone);
          
          session.save(p);
          transaction.commit();
          JOptionPane.showMessageDialog(null,"Record Added Successfully");
      }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(null,"Error");
      }
      return 1;
      }
    
    
      public static int updatePublish(String oldName, String newName){
      Transaction transaction=null;
      Session session=null;
      
      try{
      session=sessionFactory.openSession();
      transaction=session.beginTransaction();
      
      String hql="Update Publish set name =:newName where name =:oldName";
            session.createQuery(hql)
                    .setParameter("newName",newName)
                    .setParameter("oldName",oldName)
                    .executeUpdate();
            transaction.commit();
            JOptionPane.showMessageDialog(null,"Record Update Successfully");
      }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(null,"Error");
      }
      return 1;
      }
      
      public static int deletePublish(String name){
      Transaction transaction=null;
      Session session=null;
      
      try{
      session=sessionFactory.openSession();
      transaction=session.beginTransaction();
      
      String hql="Delete From Publish where name = :name";
      session.createQuery(hql)
              .setParameter("name",name)
              .executeUpdate();
      transaction.commit();
      JOptionPane.showMessageDialog(null,"Record Delete Successfully");
          
      }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(null,"Error");
      }
      return 1;
      }
    
}
