/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Author;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Qadeer
 */
public class AuthorController {
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
    
    public static int addAuthor(String bookName, String authorName, int phone){
      Transaction transaction=null;
      Session session=null;
      
      try{
      session=sessionFactory.openSession();
      transaction=session.beginTransaction();
      
      Author author=new Author();
      
      author.setAuthorName(authorName);
      author.setBookName(bookName);
      author.setAuthorContact(phone);
      
      session.save(author);
      transaction.commit();
      
      JOptionPane.showMessageDialog(null,"Record Added Successfully");
      
      }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(null,"error");
      }
      return 1;
      }
    
    public static int updateAuthor(String oldName, String newName){
      Transaction transaction=null;
      Session session=null;
      
      try{
      session=sessionFactory.openSession();
      transaction=session.beginTransaction();
      
      Author author=new Author();
       
      String hql = "Update Author set authorName = :newName Where authorName = :oldName";
      session.createQuery(hql)
              .setParameter("newName",newName)
              .setParameter("oldName",oldName)
              .executeUpdate();
      transaction.commit();
      JOptionPane.showMessageDialog(null,"Record Update Successfully ");
      
      }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(null,"Error");
      }
      return 1;
      }
    
    public static int deleteAuthor(String name){
      Transaction transaction =null;
      Session session =null;
      
      try{
          session =sessionFactory.openSession();
          transaction=session.beginTransaction();
          
          String hql="Delete From Author where authorName = :name";
          session.createQuery(hql)
                  .setParameter("name",name)
                  .executeUpdate();
          transaction.commit();
          JOptionPane.showMessageDialog(null,"Record Delete Successfully ");
      }catch(Exception e){
      e.printStackTrace();
      JOptionPane.showMessageDialog(null,"Error");
      }
      return 1;
      }
    
}
