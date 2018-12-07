/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectl164387;

/**
 *
 * @author Muntaha
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
    //savedLibrary s1 = new savedLibrary();
    Career_Interests career;
    
    
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
    public void addCareer(Career_Interests c){
        this.career=Career_Interests.getInstance();
    }
    public Career_Interests getCareer(){
        return this.career;
    }
    
}
