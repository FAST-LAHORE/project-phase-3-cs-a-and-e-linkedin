/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Dell
 */
public class Comment {
    private String comments;
    private User_Account user;
    
    Comment(String a,User_Account u){
        comments =a;
        user=u;
    }
    
    public String getCom()
    {
        return comments;
    }
    public User_Account getUser()
    {
        return user;
    }
    
    
}
