/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BookIssue {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        
        @OneToOne
       // @JoinColumn(name = "user_id", referencedColumnName = "id")
        private userEntity user;
        
        @OneToOne
       // @JoinColumn(name = "book_id", referencedColumnName = "bookId")
        private Book book;
    
        private LocalDate issue_date;
        private LocalDate return_date;

        public void setId(int id) {
                this.id = id;
        }
        public int getId() {
                return id;
        }

        public void setBook(Book book) {
                this.book = book;
        }
        public Book getBook() {
                return book;
        }

        public void setUser(userEntity user) {
                this.user = user;
        }

        public userEntity getUser() {
                return user;
        }

        public void setIssue_date(LocalDate issue_date) {
                this.issue_date = issue_date;
        }
        public LocalDate getIssue_date() {
                return issue_date;
        }

        public void setReturn_date(LocalDate return_date) {
                this.return_date = return_date;
        }
        public LocalDate getReturn_date() {
                return return_date;
        }


}



