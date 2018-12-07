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
public class SavedLib {
    
    ArrayList<job> savedJobs; 
    ArrayList<article> savedArticles;
    
    public SavedLib(){
        savedJobs = new ArrayList(); 
        savedArticles = new ArrayList();
    }
    
    public void addJob( job j){
        savedJobs.add(j);
    }
    
    public void addArticle( article a){
        savedArticles.add(a);
    }
}
