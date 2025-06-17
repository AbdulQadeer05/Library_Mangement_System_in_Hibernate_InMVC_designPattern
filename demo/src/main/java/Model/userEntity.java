/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.persistence.*;

/**
 *
 * @author Qadeer
 */
@Entity
public class userEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String name;
    private String email;
    private String password;
    
    public void  setId(int id){
    this.id=id;
    }
    public int getId(){
    return id;
    }
    
    public void setName(String name){
    this.name=name;
    }
    public String getName(){
    return name;
    }
    
    public void setEmail(String email){
    this.email=email;
    }
    public String getEmail(){
    return email;
    }
    
    public void setPassword(String password){
    this.password=password;
    }
    public String getPassword(){
    return password;
    }
    
//    public String tooString(){
//    return "name"+name+"email"+email+"password"+password;
//    }
    
    
}
