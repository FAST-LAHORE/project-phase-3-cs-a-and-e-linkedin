/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author KHAWAJA ZEESHAUR
 */
public class job {
    
    int id;
    String title;
    String degree;
    String description;
    String company;
    String country;
    int salary;
    
    job(int ID, String t, String deg, String desc, String com, String coun, int sal){  
        id = ID;
        title = t;
        degree = deg;
        description = desc;
        company = com;
        country = coun;
        salary = sal;
    }
}
