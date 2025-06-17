/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Book;
import Model.BookIssue;
import Model.userEntity;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Qadeer
 */
public class IssueBook_Controller {
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
        
        public static int bookIssue(int bookId, int userId, LocalDate issueDate, LocalDate returnDate){
          Transaction transaction=null;
          Session session=null;
          
          try{
              session=sessionFactory.openSession();
              transaction=session.beginTransaction();
              //BookIssue issue=new BookIssue();
              
           Book book= session.get(Book.class,bookId);
           userEntity user= session.get(userEntity.class,userId);
           
           BookIssue issue=new BookIssue();
           
           issue.setUser(user);
           issue.setBook(book);
           
           issue.setIssue_date(issueDate);
           issue.setReturn_date(returnDate);
           
           
           session.save(issue);
          
           transaction.commit();
           JOptionPane.showMessageDialog(null,"Record Added Successfully");
          }catch(Exception e){
          e.printStackTrace();
          JOptionPane.showMessageDialog(null,"Error");
          }
      return 1;
      }
        
        
        
}
