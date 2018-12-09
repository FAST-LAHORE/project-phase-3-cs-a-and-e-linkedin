/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class friendslist{
    private String username;
    private String password;
    private String name;
//    private String email;
//    private String country;
//    private String degree;
//    private String website;
//    private String profession;
//    private int no_of_products_bought; 
//    private String university;
//    private ArrayList<String> expertise;
//    private ArrayList<String> industry_sector;
//    private ArrayList<String> skills;
//    Saved_Items_Library library;
//    ArrayList<Article> article;
//    private int views;
//    private ArrayList<Post> posts;     //changing inheritance from aggregation
//    private ArrayList<User_Account> friends;     //changing inheritance from aggregation
    
    
    public friendslist(){
        
    }
    
    
    public void setName(String n)
    {
        name=n;
    }
    
    public void setuserName(String n)
    {
        username=n;
    }
    public String getuserName()
    {
        return username;
    }
    
    
    public String getName()
    {
        return name;
    }
    
    
}
