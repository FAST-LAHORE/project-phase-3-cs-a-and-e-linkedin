/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtableexp;

import java.util.ArrayList;

/**
 *
 * @author KHAWAJA ZEESHAUR
 */

public class user {
    
    String username;
    String password;
    String name;
    String email;
    String country;
    String university;
    String degree;
    String profession;
    String website; 
    int salary;
    SavedLib s1= new SavedLib();;
    ArrayList<job> AppliedJobs = new ArrayList();
    
    private static user u = new user();
    private user(){};
    
    public static user getInstance(){
        return u;
    }
    
    public void setValues(String un, String pass, String nm, String em, String coun, String uni, String deg, String prof, String web, int sal){
        username = un;
        password = pass;
        name = nm;
        email = em;
        country = coun;
        university = uni;
        degree = deg;
        profession = prof;
        website = web;
        salary = sal;
    }
    
    public String getUsername(){
        return username;
    }
   
}
