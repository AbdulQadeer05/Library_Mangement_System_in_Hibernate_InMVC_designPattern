/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Book;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Qadeer
 */
public class BookController {
    
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
    
    public static int addBook(String name, String author){
      Transaction transaction=null;
      Session session=null;
      
      try{
      
          session=sessionFactory.openSession();
          transaction=session.beginTransaction();
            
          Book book=new Book();
          book.setBookName(name);
          book.setAuthor(author);
          
          session.save(book);
          transaction.commit();
          JOptionPane.showMessageDialog(null,"Record Added Successfully ");
          
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,"Error");
      e.printStackTrace();
      }
      return 1;
      }
    
    public static int updateBook(String newBook, String oldBook){
      Transaction transaction=null;
      Session session=null;
      
      try{
      session=sessionFactory.openSession();
      transaction=session.beginTransaction();
      
      Book book=new Book();
      String hql="Update Book set bookName = :newBook Where bookName = :oldBook ";
      session.createQuery(hql)
              .setParameter("newBook",newBook)
              .setParameter("oldBook",oldBook)
              .executeUpdate();
      transaction.commit();
              JOptionPane.showMessageDialog(null,"Record Update Successfully");
      
      }catch(Exception e){
      JOptionPane.showMessageDialog(null,"Error");
      e.printStackTrace();
      }
      return 1;
      
      }
    
    
      public static int deleteBook(String a){
      Transaction transaction=null;
      Session session=null;
      
      try{
      session=sessionFactory.openSession();
      transaction=session.beginTransaction();
      
      Book book=new Book();
      String hql="Delete From Book where bookName = :a";
      session.createQuery(hql)
              .setParameter("a",a)
              .executeUpdate();
      transaction.commit();
      JOptionPane.showMessageDialog(null,"Record Delete Successully");
      
      }catch(Exception e){
      JOptionPane.showMessageDialog(null,"Error");
      e.printStackTrace();
      }
      return 1;
      }
    
    
}
