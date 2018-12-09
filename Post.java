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
public class Post {
    protected int id;
    protected String caption;
    protected ArrayList<Comment> comments;     // comment has to be converted from inheritance to aggregation
    protected User_Account user;
    
    
    Post(int i,String c)
    {
        id=i;
        caption=c;
        comments = new ArrayList<Comment>();
//        user=new User_Account
    }
    
    public void setUser(User_Account u)
    {
        user=u;
    }
    
    public User_Account getUser()
    {
        return user;
    }
    
    public void addcomment(Comment c)
    {
        comments.add(c);
    }
    
    public int getId()
    {
        return id;
    }
    public ArrayList<Comment> getComments()
    {
        return comments;
    }
    public String getCaption()
    {
        return caption;
    }
    
    public void show(){
            System.out.println("Post id : " + id);
            System.out.println("Post caption : " + caption);
            System.out.println("Post by : "+ user.getName());
//            ArrayList<Comment> temp= posts.get(i).getComments();
            
            for(int j=0;j<comments.size();j++)
            {
                System.out.println("Comment by " + comments.get(j).getUser().getName());
                System.out.println("Comment : " + comments.get(j).getCom());
            }
    }
    
    
}
