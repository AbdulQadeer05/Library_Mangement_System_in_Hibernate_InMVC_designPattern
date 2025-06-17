package Controller;
import Model.Author;
import javax.swing.*;
import Model.userEntity;
import Model.Book;
import Model.BookIssue;
import Model.Publish;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatabaseManager {
    public static SessionFactory sessionFactory;
   // public static Session session;
    static {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            sessionFactory = cfg.buildSessionFactory();
            //session = sessionFactory.openSession();
        } catch (Exception e) {
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
