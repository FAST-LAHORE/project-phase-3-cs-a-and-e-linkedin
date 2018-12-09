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
public class video extends Post {
    private String vidName;
    public video(int i,String n, String c) {
        super(i, c);
        vidName=n;
    }
    @Override
    public void setUser(User_Account u)
    {
        user=u;
    }
    
    @Override
    public void show(){
            System.out.println("Photo id : " + super.id);
            System.out.println("Caption : " + super.caption);
            System.out.println("Photo by : "+ super.user.getName());
//            ArrayList<Comment> temp= posts.get(i).getComments();
            
            for(int j=0;j<comments.size();j++)
            {
                System.out.println("Comment by " + super.comments.get(j).getUser());
                System.out.println("Comment : " + super.comments.get(j).getCom());
            }
    }
    
    
    
}
